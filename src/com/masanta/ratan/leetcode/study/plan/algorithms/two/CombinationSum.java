package com.masanta.ratan.leetcode.study.plan.algorithms.two;

import java.util.*;

public class CombinationSum {
	
	/*
	 * Given an array of distinct integers candidates and a target integer target,
	 * return a list of all unique combinations of candidates where the chosen
	 * numbers sum to target. You may return the combinations in any order.
	 * 
	 * The same number may be chosen from candidates an unlimited number of times.
	 * Two combinations are unique if the frequency of at least one of the chosen
	 * numbers is different.
	 * 
	 * It is guaranteed that the number of unique combinations that sum up to target
	 * is less than 150 combinations for the given input.
	 */
	
	public static void main(String[] args) {
		int[] candidates = new int[] {2,3,6,7};
		int target = 7;
		List<List<Integer>> result1 =  combinationSum(candidates, target);
		for(List<Integer> intList: result1) {
			System.out.println(Arrays.toString(intList.toArray()));
		}

	}
	
	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	        // sort candidates to try them in asc order
	        Arrays.sort(candidates); 
	        // dp[t] stores all combinations that add up to t
	        List<List<Integer>>[] dp = new ArrayList[target+1];
	        
	        
	        // build up dp
	        for(int t=0; t<=target; t++) {
	            // initialize
	            dp[t] = new ArrayList();
	            // initialize
	            List<List<Integer>> combList = new ArrayList();
	            
	            // for each t, find possible combinations
	            for(int j=0; j<candidates.length && candidates[j] <= t; j++) {
	                if(candidates[j] == t) {
	                    combList.add(Arrays.asList(candidates[j])); // itself can form a list
	                } else {
	                    for(List<Integer> prevlist: dp[t-candidates[j]]) { // here use our dp definition
	                        // i thought it makes more sense to compare with the last element
	                        // only add to list when the candidates[j] >= the last element
	                        // so the list remains ascending order, can prevent duplicate (ex. has [2 3 3], no [3 2 3])
	                        // equal is needed since we can choose the same element many times   
	                        if(candidates[j] >= prevlist.get(prevlist.size()-1)){
	                            List temp = new ArrayList(prevlist); // temp is needed since 
	                            temp.add(candidates[j]); // cannot edit prevlist inside 4eeach looop
	                            combList.add(temp);
	                        }
	                    }
	                }
	            }
	            dp[t] = combList;
	        }
	        return dp[target];
	    } 

}
