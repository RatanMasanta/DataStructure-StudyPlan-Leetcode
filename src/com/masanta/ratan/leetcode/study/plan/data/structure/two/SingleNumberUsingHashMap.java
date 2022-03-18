package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberUsingHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static int singleNumber(int[] nums) {
	        Map<Integer,Integer> map = new HashMap<>();
	        for(int i =0;i<nums.length;i++){
	            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
	        }
	        int ans = 0;
	        for(int j = 0;j<nums.length;j++){
	            if(map.get(nums[j])==1){
	                ans = nums[j];
	            }
	        }
	        return ans;
	        
	    }

}
