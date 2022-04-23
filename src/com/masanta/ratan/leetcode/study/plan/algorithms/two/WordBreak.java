package com.masanta.ratan.leetcode.study.plan.algorithms.two;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	
	/*
	 * Given a string s and a dictionary of strings wordDict, return true if s can
	 * be segmented into a space-separated sequence of one or more dictionary words.
	 * 
	 * Note that the same word in the dictionary may be reused multiple times in the
	 * segmentation.
	 */

	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		String inputString = "leetcode";
		System.out.println(wordBreak(inputString, wordDict));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		boolean[] f = new boolean[s.length() + 1];

		f[0] = true;


		/* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: wordDict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/

		//Second DP
		for(int i=1; i <= s.length(); i++){
			for(int j=0; j < i; j++){
				if(f[j] && wordDict.contains(s.substring(j, i))){
					f[i] = true;
					break;
				}
			}
		}

		return f[s.length()];
	}

}
