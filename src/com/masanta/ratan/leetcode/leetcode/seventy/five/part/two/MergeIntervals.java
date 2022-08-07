package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static int[][] merge(int[][] intervals) {
	        Arrays.sort(intervals,(o1,o2)->Integer.compare(o1[0], o2[0]));
	        List<int[]> ansList = new ArrayList<int[]>();
	        int start = intervals[0][0];
	        int end = intervals[0][1];
	        
	        int e,s;
	        int i =0;
	        int[] newInterval = intervals[0];
	        while(i<intervals.length)
	        {
	            s = intervals[i][0];
	            e = intervals[i][1];
	            if(s<=end)
	                end = Math.max(end,e);
	            else
	            {
	                ansList.add(new int[]{start,end});
	                start = s;
	                end =  e;  
	            }
	            i++;
	        }
	        ansList.add(new int[] {start,end});
	        return ansList.toArray(new int[ansList.size()][]);
	    }

}
