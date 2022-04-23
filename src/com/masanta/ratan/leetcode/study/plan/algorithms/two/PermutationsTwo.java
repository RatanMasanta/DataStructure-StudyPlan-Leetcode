package com.masanta.ratan.leetcode.study.plan.algorithms.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsTwo {

	/*
	 * Given a collection of numbers, nums, that might contain duplicates, return
	 * all possible unique permutations in any order.
	 */	
	public static void main(String[] args) {
		int[] intArray = new int[] {1,2,3};
		List<List<Integer>> result1 =  permuteUnique(intArray);
		for(List<Integer> intList: result1) {
			System.out.println(Arrays.toString(intList.toArray()));
		}

	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length]; // create a boolean array to check if the value has been visited or not
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue; // skips the repeteted values after they were previously sorted
            used[i]=true; // set the used flag to true
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}
