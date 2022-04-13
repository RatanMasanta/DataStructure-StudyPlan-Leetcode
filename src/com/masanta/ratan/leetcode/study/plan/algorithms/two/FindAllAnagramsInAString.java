package com.masanta.ratan.leetcode.study.plan.algorithms.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

	/*
	 * Problem statement:
	 * 
	 * Given two strings s and p, return an array of all the start indices of p's
	 * anagrams in s. You may return the answer in any order.
	 * 
	 * An Anagram is a word or phrase formed by rearranging the letters of a
	 * different word or phrase, typically using all the original letters exactly
	 * once.
	 */	
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findAnagrams("cbaebabacd", "abc").toArray()));
	}

	
	 public static List<Integer> findAnagrams(String s, String p) {
	        if (s == null || p == null) {
	            throw new IllegalArgumentException("Input string is null");
	        }

	        List<Integer> result = new ArrayList<>();
	        int sLen = s.length();
	        int pLen = p.length();
	        if (sLen * pLen == 0 || sLen < pLen) {
	            return result;
	        }

	        Map<Character, Integer> map = new HashMap<>();
	        for (int i = 0; i < p.length(); i++) {
	            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
	        }

	        int toBeMatched = map.size();
	        int start = 0;
	        int end = 0;

	        while (end < sLen) {
	            char eChar = s.charAt(end);
	            if (map.containsKey(eChar)) {
	                int count = map.get(eChar);
	                if (count == 1) {
	                    toBeMatched--;
	                }
	                map.put(eChar, count - 1);
	            }
	            end++;

	            if (end - start > pLen) {
	                char sChar = s.charAt(start);
	                if (map.containsKey(sChar)) {
	                    int count = map.get(sChar);
	                    if (count == 0) {
	                        toBeMatched++;
	                    }
	                    map.put(sChar, count + 1);
	                }
	                start++;
	            }

	            if (toBeMatched == 0) {
	                result.add(start);
	            }
	        }

	        return result;
	    }
}
