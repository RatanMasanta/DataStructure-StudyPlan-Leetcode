package com.masanta.ratan.leetcode.study.plan.algorithms.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsPartTwo {
	
	/*
	 * Given an integer array nums that may contain duplicates, return all possible
	 * subsets (the power set).
	 * 
	 * The solution set must not contain duplicate subsets. Return the solution in
	 * any order.
	 */

	public static void main(String[] args) {
		int[] intArray = new int[] {1,2,3};
		List<List<Integer>> result1 =  subsetsWithoutDup(intArray);
		for(List<Integer> intList: result1) {
			System.out.println(Arrays.toString(intList.toArray()));
		}
		
	}
	
	 public static List<List<Integer>> subsetsWithoutDup(int[] nums) {
	        List<List<Integer>> outer = new ArrayList<>();
	        outer.add(new ArrayList<>()); // adding null set
	        for(int num : nums){
	            int n = outer.size();
	            for(int i = 0; i < n; i++){
	                List<Integer> inner = new ArrayList<>(outer.get(i));
	                inner.add(num);
	                Collections.sort(inner);
	                if(! outer.contains(inner)) // check for duplicate entries
	                    outer.add(inner);
	            }
	        }
	        return outer;
	    }

}
