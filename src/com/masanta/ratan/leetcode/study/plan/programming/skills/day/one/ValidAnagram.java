package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("book","koob"));

	}
	
	public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> m1=new HashMap<>();
        for(int i=0;i<s.length();i++) 
        m1.put(s.charAt(i),m1.getOrDefault(s.charAt(i),0)+1);
         for(int i=0;i<t.length();i++) 
        m1.put(t.charAt(i),m1.getOrDefault(t.charAt(i),0)-1);
        for(int val:m1.values())
            if(val!=0)
                return false;
        return true;
    }

}
