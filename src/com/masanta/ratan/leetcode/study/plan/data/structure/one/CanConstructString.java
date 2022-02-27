package com.masanta.ratan.leetcode.study.plan.data.structure.one;

import java.util.HashMap;
import java.util.Map;

public class CanConstructString {

	public static void main(String[] args) {
		System.out.println(canConstruct("ab","ac"));
	}
	
	 public static boolean canConstruct(String ransomNote, String magazine) {
	        char[] c = ransomNote.toCharArray();
	        char[] cm = magazine.toCharArray();
	        Map<Character, Integer> map = new HashMap<>();
	        for(int i = 0; i < c.length; i++){
	            char ch = c[i];
	            map.put(ch, map.getOrDefault(ch, 0)+1);
	        }
	        
	        for(int i = 0; i < cm.length; i++){
	            if(map.get(cm[i]) != null){
	                map.put(cm[i], map.get(cm[i]) - 1);
	            }
	        }
	        
	        return map.values().stream().noneMatch(value -> value > 0);
	    }

}
