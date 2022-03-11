package com.masanta.ratan.leetcode.study.plan.algorithms.one;

import java.util.Arrays;

public class PermutationsInString {

	public static void main(String[] args) {
		System.out.println(checkInclusion("abc", "cab"));

	}
	
	public static boolean checkInclusion(String s1, String s2) {
        int [] f1 = new int[26];
       int [] f2 = new int[26];
       int n1 = s1.length();
       int n2 = s2.length();
       
       if(n1 > n2)
           return false;
       
       for(int i = 0;i<n1; i++){
           f2[s2.charAt(i) - 'a']++;
           f1[s1.charAt(i) - 'a']++;
       }
       
       if(Arrays.equals(f1, f2)){
           return true;
       }
       
       for(int i = n1; i<n2; i++){
           f2[s2.charAt(i) - 'a']++;
           f2[s2.charAt(i - n1) - 'a']--;
           
           if(Arrays.equals(f1, f2)){
               return true;
           }
       }
       return false;
   }

}
