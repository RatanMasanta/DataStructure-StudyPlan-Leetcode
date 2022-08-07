package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length; // length of intervals
        if (intervals == null || n == 0) {
            return new int[][] { newInterval };
        }
        
        // result list to be converted to int[] at the end
        List<int[]> result = new ArrayList<>();
        
        // skip the intervals that end before new interval
        int i = 0;
        
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // merge all intervals that overlap with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        
        // add the newly merged interval
        result.add(newInterval);
        
        // add all the remaining intervals to result
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

		// convert to a 2d array
        return result.toArray(new int[result.size()][2]);
    }

}
