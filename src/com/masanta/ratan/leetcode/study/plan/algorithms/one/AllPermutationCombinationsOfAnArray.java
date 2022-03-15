package com.masanta.ratan.leetcode.study.plan.algorithms.one;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationCombinationsOfAnArray {

	public static void main(String[] args) {
		List<List<Integer>> resultList = permute(new int[] {1,6,4,5,8,7});
		System.out.println("Done");
	}
	
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getPerms(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }
    
    private static void getPerms(int[] nums, List<Integer> prefix, boolean[] prefixIndices, List<List<Integer>> result) {
        if (prefix.size() == nums.length) {
            result.add(prefix);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!prefixIndices[i]) {
                List<Integer> newPrefix = new ArrayList<>();
                newPrefix.addAll(prefix);
                newPrefix.add(nums[i]);
                
                prefixIndices[i] = true;
                getPerms(nums, newPrefix, prefixIndices, result);
                prefixIndices[i] = false;
            }
        }
    }

}
