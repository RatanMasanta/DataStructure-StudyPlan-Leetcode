package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

public class RepeatedSubStringPattern {

	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("abcabcabcabc"));

	}
	
    public static boolean repeatedSubstringPattern(String s) {
        // corner case
        if(s == null || s.length() == 0) return true;
        
        int n = s.length();
        for(int len = 1; len <= n/2; len++){ // pattern must repeat at least twice, i.e. pattern length is at most n/2
            if(n % len != 0) continue; // s length must can be divided by the pattern length
            
            String pattern = s.substring(0, len); // pattern string
            int i = len; // start index of 2nd pattern
            int j = i + len - 1; // end index of 2nd pattern
            while(j < n){
                String substr = s.substring(i, j + 1);
                if(!pattern.equals(substr)) break; // failed for this pattern, try next pattern		
                i += len;
                j += len;
            }
			
			// if it past the last substring check, i will be n
            if(i == n) return true;
        }
        return false;
    }

}
