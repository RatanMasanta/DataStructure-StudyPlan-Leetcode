package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

public class LengthOfLastWords {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
		System.out.println(lengthOfLastWord2("luffy is still joyboy"));

	}
	
	public static int lengthOfLastWord(String s) {
        int length = 0;
		
		// We are looking for the last word so let's go backward
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') { // a letter is found so count
                length++;
            } else {  // it's a white space instead
				//  Did we already started to count a word ? Yes so we found the last word
                if (length > 0) return length;
            }
        }
        return length;
    }
	
	 public static int lengthOfLastWord2(String s) {
	        s = s.trim();
	        String[] words = s.split(" ");
	        return words[words.length - 1].toCharArray().length;
	    }

}
