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


	/*
	 * Each recursion level focuses on all the following elements. We scan through
	 * all the following elements and decide whether to choose or not choose that
	 * element. (Every level split into N branches.)
	 */	
	public List<List<Integer>> subsetsWithDup1(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		helper(res,new ArrayList<>(),nums,0);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> ls, int[] nums, int pos) {
		res.add(new ArrayList<>(ls));
		for(int i=pos;i<nums.length;i++) {
			if(i>pos&&nums[i]==nums[i-1]) continue;
			ls.add(nums[i]);
			helper(res,ls,nums,i+1);     
			ls.remove(ls.size()-1);
		}
	}
	
	/*
	 * Each recursion level focuses on one element, we need to decide choose or not
	 * choose this element. (Every level split into 2 branches.)
	 */	 
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		helper(res,new ArrayList<>(),nums,0,false);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> ls, int[] nums, int pos, boolean choosePre) {
		if(pos==nums.length) {
			res.add(new ArrayList<>(ls));
			return;
		}
		helper(res,ls,nums,pos+1,false);
		if(pos>=1&&nums[pos]==nums[pos-1]&&!choosePre) return;
		ls.add(nums[pos]);
		helper(res,ls,nums,pos+1,true);
		ls.remove(ls.size()-1);
	}


}