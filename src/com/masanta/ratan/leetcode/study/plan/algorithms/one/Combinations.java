package com.masanta.ratan.leetcode.study.plan.algorithms.one;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		List<List<Integer>> resultList = combine(4,3);
		System.out.println("Done");

	}

	 public static List<List<Integer>> result;
	    
	    public static void getComb(int left, int n, int start, List<Integer> cur) {
	        if (left == 0) {
	            result.add(new ArrayList<>(cur));
	            return;
	        }
	        for (int i = start; i < n; i++) {
	            cur.add(i + 1);
	            getComb(left - 1, n, i + 1, cur);
	            cur.remove(cur.size() - 1);
	        }
	    }
	    
	    public static List<List<Integer>> combine(int n, int k) {
	        result = new ArrayList<>();
	        List<Integer> cur = new ArrayList<>();
	        getComb(k, n, 0, cur);
	        return result;
	    }
	
}
