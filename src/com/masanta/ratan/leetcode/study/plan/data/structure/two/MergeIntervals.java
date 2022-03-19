package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};
		int[][] newIntervals = merge(intervals);
		int[][] newIntervals2 = merge2(intervals);
		System.out.println("Done");
		
	}
	
	public static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}

	
	/*
	    * Time= O(n log(n))
	    * Space = O(n)
	    */
	    
	    public static int[][] merge2(int[][] intervals) {
			Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
	        LinkedList<int[]> merged = new LinkedList<>();
	        for(int[] interval: intervals){
	            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
	                merged.add(interval);
	            } else {
	                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
	            }
	        }
	        return merged.toArray(new int[merged.size()][]);
		}
}
