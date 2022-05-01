package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[] {1,2,3,4,5,6,9,8,7,6}));

	}

	 public static boolean containsDuplicate(int[] nums) {
	        Map<Integer, Integer> map = new HashMap<>();
	        for(int i : nums){
	            boolean result = isDuplicateCheck(map, i);
	            if(result)
	                return true;
	        }
	        return false;
	    }
	    
	    public static boolean isDuplicateCheck(Map map, int value){
	        if(!map.containsKey(value)){
	            map.put(value,1);
	            return false;
	        } else {
	            return true;
	        }
	    }
	
}
