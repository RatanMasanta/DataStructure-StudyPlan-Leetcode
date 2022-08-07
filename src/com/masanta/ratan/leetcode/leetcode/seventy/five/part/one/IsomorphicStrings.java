package com.masanta.ratan.leetcode.leetcode.seventy.five.part.one;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	
	/*
		Given two strings s and t, determine if they are isomorphic.

		Two strings s and t are isomorphic if the characters in s can be replaced to get t.

		All occurrences of a character must be replaced with another character while preserving
 		the order of characters. No two characters may map to the same character, but a character may map to itself.

	*/
	public static void main(String[] args) {
		String word1 = "egg";
		String word2 = "add";
		
		System.out.println(isIsomorphic(word1, word2));

	}
	
	public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> mapS = new HashMap<Character, Integer>();
        Map<Character, Integer> mapT = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            int indexS = mapS.getOrDefault(s.charAt(i), -1);
            int indexT = mapT.getOrDefault(t.charAt(i), -1);
                        
            if (indexS != indexT) {
                return false;
            }
            
            mapS.put(s.charAt(i), i);
            mapT.put(t.charAt(i), i);
        }
        
        return true;
    }

}
