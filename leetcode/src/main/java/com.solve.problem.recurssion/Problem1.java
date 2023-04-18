package com.solve.problem.recurssion;

/* DATE 18-Apr-23
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

        Return the merged string.



        Example 1:

        Input: word1 = "abc", word2 = "pqr"
        Output: "apbqcr"
        Explanation: The merged string will be merged as so:
        word1:  a   b   c
        word2:    p   q   r
        merged: a p b q c r
        Example 2:

        Input: word1 = "ab", word2 = "pqrs"
        Output: "apbqrs"
        Explanation: Notice that as word2 is longer, "rs" is appended to the end.
        word1:  a   b
        word2:    p   q   r   s
        merged: a p b q   r   s
        Example 3:

        Input: word1 = "abcd", word2 = "pq"
        Output: "apbqcd"
        Explanation: Notice that as word1 is longer, "cd" is appended to the end.
        word1:  a   b   c   d
        word2:    p   q
        merged: a p b q c   d


        Constraints:

        1 <= word1.length, word2.length <= 100
        word1 and word2 consist of lowercase English letters.
*/

//APPROACH 1
public class Problem1 {

    public static void main(String[] args) {
        String word1 = "a";
        String word2 = "pqrst";

        System.out.println("Recurssive Approach:" + mergeAlternately(word1, word2).replace(" ", ""));

        System.out.println("Two pointer Approach:" + mergeAlternatelyWithTwoPointerApproach(word1, word2));

        System.out.println("Single pointer Approach:" + mergeAlternatelyWithSinglePointerApproach(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        int word1Len = word1.length();
        int word2Len = word2.length();
        int diff = 0;
        if (word2Len > word1Len) {
            diff = word2Len - word1Len;
            for (int i = 0; i < diff; i++) {
                word1 = word1.concat(" ");
            }
        } else if (word1Len > word2Len) {
            diff = word1Len - word2Len;
            for (int i = 0; i < diff; i++) {
                word2 = word2.concat(" ");
            }
        }
        return mergeFinalAlternately(word1, word2);

    }

    private static String mergeFinalAlternately(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) {
            return "";
        }
        String output = word1.substring(0, 1) + word2.substring(0, 1) + mergeFinalAlternately(word1.substring(1, word1.length()), word2.substring(1, word2.length()));
        return output.replaceAll(" ", "").trim();
    }
    //APPROACH 2 Two Pointer
// Time Complexity O(i+j)
    private static String mergeAlternatelyWithTwoPointerApproach(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) {
            return "";
        }
        int len1 = word1.length(), len2 = word2.length();
        String result = "";
        int i = 0, j = 0;
        while (i < len1 || j < len2) {
            if (i < len1) {
                result += word1.charAt(i);
                i++;
            }
            if (j < len2) {
                result += word2.charAt(j);
                j++;
            }
        }
        return result;

    }

//Approach 3: Single Pointer

    private static String mergeAlternatelyWithSinglePointerApproach(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Math.max(m, n); i++) {
            if (i < m) {
                result.append(word1.charAt(i));
            }
            if (i < n) {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }
}
