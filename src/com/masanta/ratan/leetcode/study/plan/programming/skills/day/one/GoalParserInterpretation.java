package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class GoalParserInterpretation {
	
	/*
	 * statement:
	 * 
	 * You own a Goal Parser that can interpret a string command. The command
	 * consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal
	 * Parser will interpret "G" as the string "G", "()" as the string "o", and
	 * "(al)" as the string "al". The interpreted strings are then concatenated in
	 * the original order.
	 * 
	 * Given the string command, return the Goal Parser's interpretation of command.
	 */
	
	public static void main(String[] args) {
		System.out.println(interpret("G()(al)"));
	}
	
	public static String interpret(String command) {
		StringBuilder S = new StringBuilder(command.length());
		for(int i = 0 ; i < command.length() ; i++){
			if(command.charAt(i)=='G') S.append('G');
			if(command.charAt(i)=='('){
				if(command.charAt(i+1)==')') {S.append('o'); i++;}
				else{S.append("al"); i = i + 3;}
			}
		}
		return S.toString();
	}

}
