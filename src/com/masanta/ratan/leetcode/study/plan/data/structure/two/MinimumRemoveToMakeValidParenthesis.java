package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Stack;

public class MinimumRemoveToMakeValidParenthesis {
	
	/*
	 * Problem statement: Given a string s of '(' , ')' and lowercase English
	 * characters.
	 * 
	 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any
	 * positions ) so that the resulting parentheses string is valid and return any
	 * valid string.
	 * 
	 * Formally, a parentheses string is valid if and only if:
	 * 
	 * It is the empty string, contains only lowercase characters, or It can be
	 * written as AB (A concatenated with B), where A and B are valid strings, or It
	 * can be written as (A), where A is a valid string.
	 */

	public static void main(String[] args) {
		String s1 = "lee(t(c)o)de)";
		String s2 = "))((";
		
		String result=minRemoveToMakeValidUsingStack(s1);
		System.out.println(result);

	}
	
	
	/*
	 * ⌘ Given statement :
	 * 
	 * Your task is to remove the minimum number of parentheses. return any valid
	 * string. ⌘ Observations :
	 * 
	 * It is quite obvious to get a hunch of using stack when we see a parenthesis
	 * problem but we can for sure optimise the space in such a case where the input
	 * is limited. [ eg: here s[i] is either'(' , ')', or lowercase English letter
	 * ].
	 */
	
	
	
	 public static String minRemoveToMakeValidUsingStack(String s) {
	        Stack<Integer> stack = new Stack<>();
	        for(int i=0;i<s.length();i++) {
	            char ch = s.charAt(i);
	            if(Character.isAlphabetic(ch))
	                continue;
	            if(ch == '(')
	                stack.push(i);
	            else {
	                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(')
	                    stack.pop();
	                else stack.push(i);
	            }
	        }
	        
	        // if(stack.size() == 0) return "";
	        
	        StringBuilder result = new StringBuilder();
	        HashSet<Integer> set = new HashSet<>(stack);
	        for(int i=0;i<s.length();i++)
	            if(!set.contains(i))
	                result.append(s.charAt(i));
	        
	        return result.toString();
	    }
	 
	 
	 public static String minRemoveToMakeValidUsingDeque(String s) {
			if (s == null || s.length() == 0) {
	            return s;
	        }
	        
	        char[] chars = s.toCharArray();
	        Deque<Integer> deque = new ArrayDeque<>();
			
			// push invalid indices in deque
	        for (int i = 0; i < chars.length; i++) {
	            char c = chars[i];
	            if (c == '(') {
	                deque.push(i);
	            } else if (c == ')') {
	                if (deque.isEmpty()) {
	                    chars[i] = '#';
	                } else {
	                    deque.pop();
	                }
	            } 
	        }
	        // mark invalid indices
	        while (!deque.isEmpty()) {
	            chars[deque.pop()] = '#';
	        }
	        
	        StringBuilder ans = new StringBuilder();
	        for (char c : chars) {
	            if (c != '#') {
	                ans.append(c);
	            }
	        }
	        return ans.toString();
	    }
	 
		/*
		 * ⌘ Constant Solution 1 : [ Slow as we are using insert() function ]
		 * 
		 * ✔️ Logic : [ 2 steps ]
		 * 
		 * remove invalid close parenthesis remove invalid open parenthesis
		 */

	 public static String minRemoveToMakeValidConstantSolution(String s) {
	        StringBuilder R = new StringBuilder();
	        int open = 0, close = 0;
	        
	        // remove invalid close parenthesis
	        for(char ch : s.toCharArray()) {
	            if(Character.isAlphabetic(ch)) {
	                R.append(ch);
	            }
	            else if(ch=='(') {
	                open++;
	                R.append(ch);
	            }
	            else {
	                if(open > close) { // if there is an '(' to be considered for a valid pair
	                    R.append(ch);
	                    close++;
	                }
	                else {
	                    open = open < 0 ? 0 : open--;
	                }
	            }
	        }

	        s = R.toString();
	        R.setLength(0); // reset ans
	        int n = s.length();
	        open = close = 0;
			
			// remove invalid open parenthesis
			
	        for(int i=n-1;i>=0;i--) {
	            char ch = s.charAt(i);
	            if(Character.isAlphabetic(ch)) {
	                R.insert(0, ch);
	            }
	            else if(ch == ')') {
	                R.insert(0, ch);
	                close++;
	            }
	            else {
	                if(close > open) {
	                    R.insert(0, ch);
	                    open++;
	                }
	                else {
	                    close = close < 0 ? 0 : close--;
	                }
	            }
	        }        
	        return R.toString();
	    }
	 
	 
	 public String minRemoveToMakeValidNotSoConstantSolution(String s) {
	        StringBuilder R = new StringBuilder();
	        int open = 0, close = 0;
	        
	        // remove invalid close parenthesis
	        for(char ch : s.toCharArray()) {
	            if(Character.isAlphabetic(ch)) {
	                R.append(ch);
	            }
	            else if(ch=='(') {
	                open++;
	                R.append(ch);
	            }
	            else {
	                if(open > close) {
	                    R.append(ch);
	                    close++;
	                }
	                else {
	                    open = open < 0 ? 0 : open--;
	                }
	            }
	        }

	        // remove invalid open parenthesis
	        s = R.toString();
	        int n = s.length();
	        R.setLength(0);
	        open = close = 0;
	        char[] A = s.toCharArray();
	        
	        for(int i=n-1;i>=0;i--) {
	            char ch = s.charAt(i);
	            if(Character.isAlphabetic(ch)) {
	                continue;
	            }
	            else if(ch == ')') {
	                close++;
	            }
	            else {
	                if(close > open) {
	                    open++;
	                }
	                else {
	                    A[i] = '*';
	                    close = close < 0 ? 0 : close--;
	                }
	            }
	        }
	        
	        for(char ch : A) 
	            if(ch!='*')
	                R.append(ch);
	        
	        return R.toString();
	    }
	 
	 /*
	  * 	Fastest solution
	  * 	
	  * 
	  */
	 
	 public String minRemoveToMakeValidFastest(String s) {
         char[] arr = s.toCharArray();
        int open = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(')
                open++;
            else if (arr[i] == ')') {
                if (open == 0)
                    arr[i] = '*';
                else
                    open--;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (open > 0 && arr[i] == '(') {
                arr[i] = '*';
                open--;
            }
        }

        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*')
                arr[p++] = arr[i];
        }

        return new String(arr).substring(0, p);
    }
	 
	 
}
