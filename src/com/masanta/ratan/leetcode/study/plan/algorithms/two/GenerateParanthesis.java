package com.masanta.ratan.leetcode.study.plan.algorithms.two;

import java.util.*;

public class GenerateParanthesis {

	/*
	 * Given n pairs of parentheses, write a function to generate all combinations
	 * of well-formed parentheses.
	 */
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(generateParenthesis(8).toArray()));

	}

	public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public static void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
	
}
