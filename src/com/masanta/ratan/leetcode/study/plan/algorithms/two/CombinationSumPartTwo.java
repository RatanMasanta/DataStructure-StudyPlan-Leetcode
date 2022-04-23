package com.masanta.ratan.leetcode.study.plan.algorithms.two;

import java.util.*;

public class CombinationSumPartTwo {

	/*
	 * Given a collection of candidate numbers (candidates) and a target number
	 * (target), find all unique combinations in candidates where the candidate
	 * numbers sum to target.
	 * 
	 * Each number in candidates may only be used once in the combination.
	 * 
	 * Note: The solution set must not contain duplicate combinations.
	 */
	
	public static void main(String[] args) {
		int[] candidates = new int[] {10,1,2,7,6,1,5};
		int target = 8;
		
		List<List<Integer>> results = combinationSum2(candidates, target);
		for(List<Integer> intList: results) {
			System.out.println(Arrays.toString(intList.toArray()));
		}
		
	}

	public static List<List<Integer>> combinationSum2(int[] cand, int target) {
		Arrays.sort(cand);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		dfs_com(cand, 0, target, path, res);
		return res;
	}
	public static void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList(path));
			return ;
		}
		if (target < 0) return;
		for (int i = cur; i < cand.length; i++){
			if (i > cur && cand[i] == cand[i-1]) continue;
			path.add(path.size(), cand[i]);
			dfs_com(cand, i+1, target - cand[i], path, res);
			path.remove(path.size()-1);
		}
	}

}
