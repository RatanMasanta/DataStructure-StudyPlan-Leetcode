package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.HashMap;

public class DecryptStringFromAlphabetMapping {
	
	/*You are given a string s formed by digits and '#'. We want to map s to English lowercase characters as follows:

		Characters ('a' to 'i') are represented by ('1' to '9') respectively.
		Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
		Return the string formed after mapping.

		The test cases are generated so that a unique mapping will always exist.
		*/

	public static void main(String[] args) {
		
		String decrypt = "1326#";
		System.out.println(freqAlphabets(decrypt));
	}
	
	public static String freqAlphabets(String str) {
        HashMap<String, Character> map = new HashMap<>();
        int k = 1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch < 'j')
                map.put(String.valueOf(k++), ch);
            else
                map.put(String.valueOf(k++)+"#", ch);
        }
        
        StringBuilder sb = new StringBuilder();
        int i = str.length() - 1;
        while (i >= 0) {
            if (str.charAt(i) == '#') {
                sb.append(map.get(str.substring(i - 2, i+1)));
                i -= 3;
            } else {
                sb.append(map.get(str.substring(i, i + 1)));
                i--;
            }
        }
        
        return sb.reverse().toString();
    }

}
