package com.masanta.ratan.leetcode.study.plan.algorithms.two;

public class BackspaceStringCompare {

	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab#c","abc##cde##"));

	} 
	
	public static boolean backspaceCompare(String S, String T) {
        return formatString(S).equals(formatString(T));
    }
    private static String formatString(String s) {
        StringBuilder builder = new StringBuilder(s);
        int index = 0;
        for (int i = 0; i < s.length(); i++ ){
            index++;
            char c = s.charAt(i);
            if (c == '#'){
                index--;
                builder.deleteCharAt(index);
                if (index >0){
                    index--;
                    builder.deleteCharAt(index);
                }
            }
        }
        return builder.toString();
    }

}
