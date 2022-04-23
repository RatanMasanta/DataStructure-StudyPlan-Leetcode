package com.masanta.ratan.leetcode.study.plan.algorithms.two;

import java.util.*;

public class Subsets {
	
	/*
	 * Given an integer array nums of unique elements, return all possible subsets
	 * (the power set).
	 * 
	 * The solution set must not contain duplicate subsets. Return the solution in
	 * any order.
	 */

	public static void main(String[] args) {
		int[] intArray = new int[] {1,2,3};
		List<List<Integer>> result1 =  subsets(intArray);
		for(List<Integer> intList: result1) {
			System.out.println(Arrays.toString(intList.toArray()));
		}
	}
	
	 public static List<List<Integer>> subsets(int[] S) {
	        List<List<Integer>> res = new ArrayList<>();
	        res.add(new ArrayList<Integer>());
	        
	        Arrays.sort(S);
	        for(int i : S) {
	            List<List<Integer>> tmp = new ArrayList<>();
	            for(List<Integer> sub : res) {
	                List<Integer> a = new ArrayList<>(sub);
	                a.add(i);
	                tmp.add(a);
	            }
	            res.addAll(tmp);
	        }
	        return res;
	    }

}
