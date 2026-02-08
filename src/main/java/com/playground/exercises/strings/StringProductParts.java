package main.java.com.playground.exercises.strings;

import main.java.com.playground.utils.LoggerUtil;

/*
Question: Write a method to determine the maximum number of products that can be produced from the number of parts available.
Eg: Product = "cab", parts = "acbbda", a max of 2 products can be built since you have 2a's, 2b's, and 2c's available and one product requires 1a, 1b, 1c.
*/
public class StringProductParts {

    /**
     * Calculates the maximum number of products that can be built from available parts.
     * Time Complexity: O(N + M) where N is productParts.length() and M is product.length().
     * Space Complexity: O(N + M) due to creation of character arrays.
     * 
     * @param product The string representing the product to be built.
     * @param productParts The string containing all available parts.
     * @return The maximum number of complete products that can be formed.
     */
    public static int maxProducts(String product, String productParts) {
        // Handle null inputs to prevent NullPointerException
        if (product == null || productParts == null) {
            return 0;
        }
        // If either string is empty, no products can be formed
        if (product.length() == 0 || productParts.length() == 0) {
            return 0;
        }
        
        // Trim whitespace and validate that both strings contain only alphabetic characters
        productParts = productParts.trim();
        product = product.trim();
        if (!productParts.matches("[a-zA-Z]+") || !product.matches("[a-zA-Z]+")) {
            LoggerUtil.info("Contains non-alphabets...");
            return 0;
        }
        
        // A product cannot be built if there are fewer total part characters than required for one product
        if (productParts.length() < product.length()) {
            return 0;
        }

        // Convert strings to lowercase char arrays for case-insensitive processing
        char[] productPartsInChars = productParts.toLowerCase().toCharArray();
        char[] productInChars = product.toLowerCase().toCharArray();
        
        // Array to store frequency of each character 'a' through 'z' (index 0-25)
        int[] charCountArray = new int[26];
        
        // Initial upper bound for max products based on total character counts
        int maxPossibleProduct = (productParts.length() / product.length());

        // Count occurrences of each character available in productParts
        for (int i = 0; i < productPartsInChars.length; i++) {
            // Subtracting 'a' maps 'a'->0, 'b'->1, ..., 'z'->25
            charCountArray[(int) productPartsInChars[i] - 'a']++;
        }

        // Iterate through each character required by the product and find the limiting factor
        for (int i = 0; i < productInChars.length; i++) {
            int count = charCountArray[(int)productInChars[i] - 'a'];
            // If any required character's availability is less than current max, update the bottleneck
            if (count < maxPossibleProduct) {
                maxPossibleProduct = count;
            }
        }

        return maxPossibleProduct;
     }

     public static void testProductParts() {
         LoggerUtil.info("Testing ProductParts...");
         LoggerUtil.assertEquals(String.valueOf(2), String.valueOf(maxProducts("abc", "aabbCcd ")), "Max products should be 2");
         LoggerUtil.assertEquals(String.valueOf(0), String.valueOf(maxProducts("", "aabbccd")), "Max products should be 0");
         LoggerUtil.assertEquals(String.valueOf(1), String.valueOf(maxProducts("cab", "acBbda")), "Max products should be 1");
         LoggerUtil.assertEquals(String.valueOf(1), String.valueOf(maxProducts("abc", "abc")), "Max products should be 1");
         LoggerUtil.assertEquals(String.valueOf(0), String.valueOf(maxProducts("abc", "ab")), "Max products should be 0");
         LoggerUtil.assertEquals(String.valueOf(1), String.valueOf(maxProducts("aaa", "aaaaa")), "Max products should be 1");
         LoggerUtil.assertEquals(String.valueOf(2), String.valueOf(maxProducts("aaa", "aaaaaa")), "Max products should be 2");
         LoggerUtil.assertEquals(String.valueOf(2), String.valueOf(maxProducts("ABC", "aabbcc")), "Max products should be 2 (case insensitive)");
         LoggerUtil.assertEquals(String.valueOf(0), String.valueOf(maxProducts("a1b", "aabbccd")), "Max products should be 0 (non-alphabetic product)");
         LoggerUtil.assertEquals(String.valueOf(0), String.valueOf(maxProducts("abc", "aabbcc1")), "Max products should be 0 (non-alphabetic parts)");
         LoggerUtil.assertEquals(String.valueOf(0), String.valueOf(maxProducts("", "")), "Max products should be 0");
         LoggerUtil.assertEquals(String.valueOf(0), String.valueOf(maxProducts("abc", "")), "Max products should be 0");
         LoggerUtil.assertEquals(String.valueOf(1), String.valueOf(maxProducts("aab", "aaabbb")), "Max products should be 1 (aab requires two 'a's)");
         LoggerUtil.info("All ProductParts tests passed!");
     }
}
