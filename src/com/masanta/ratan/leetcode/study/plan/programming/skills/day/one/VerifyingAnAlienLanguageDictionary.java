package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class VerifyingAnAlienLanguageDictionary {
	
	/*
	 * In an alien language, surprisingly, they also use English lowercase letters,
	 * but possibly in a different order. The order of the alphabet is some
	 * permutation of lowercase letters.
	 * 
	 * Given a sequence of words written in the alien language, and the order of the
	 * alphabet, return true if and only if the given words are sorted
	 * lexicographically in this alien language.
	 */

	public static void main(String[] args) {
		
		String[] words = new String[] {"hello","leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		
		System.out.println(isAlienSorted(words,order));
	}
	
	/*

	Build a transform mapping from order,
	Find all alien words with letters in normal order.

	For example, if we have order = "xyz..."
	We can map the word "xyz" to "abc" or "123"

	Then we check if all words are in sorted order.
	*/
	
	static int[] mapping = new int[26];
    public static boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++)
            mapping[order.charAt(i) - 'a'] = i;
        for (int i = 1; i < words.length; i++)
            if (bigger(words[i - 1], words[i]))
                return false;
        return true;
    }

    static boolean bigger(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        for (int i = 0; i < n && i < m; ++i)
            if (s1.charAt(i) != s2.charAt(i))
                return mapping[s1.charAt(i) - 'a'] > mapping[s2.charAt(i) - 'a'];
        return n > m;
    }
}
