package com.masanta.ratan.leetcode.study.plan.algorithms.one;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	
	/* 
	 *  Problem statement
	 *  Given a triangle array, return the minimum path sum from top to bottom.
	 *  For each step, you may move to an adjacent number of the row below. 
	 *  More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
	 * 
	 * 
	 */

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		List<Integer> list4 = new ArrayList<Integer>();
		list1.add(2);
		list2.add(3);
		list2.add(4);
		list3.add(6);
		list3.add(5);
		list3.add(7);
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		
		System.out.println(minimumTotal(list));

	}

	public static int minimumTotal(List<List<Integer>> triangle) {
        int l = triangle.size();
        int[] dp = new int[l+1];
        for(int i=l-1; i>=0; i--){
            for(int j=0; j<triangle.get(i).size(); j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
	
}
