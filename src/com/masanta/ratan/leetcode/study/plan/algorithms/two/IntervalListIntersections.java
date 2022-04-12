package com.masanta.ratan.leetcode.study.plan.algorithms.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {
	
	/*
	 * Problem statement You are given two lists of closed intervals, firstList and
	 * secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj,
	 * endj]. Each list of intervals is pairwise disjoint and in sorted order.
	 * 
	 * Return the intersection of these two interval lists.
	 * 
	 * A closed interval [a, b] (with a <= b) denotes the set of real numbers x with
	 * a <= x <= b.
	 * 
	 * The intersection of two closed intervals is a set of real numbers that are
	 * either empty or represented as a closed interval. For example, the
	 * intersection of [1, 3] and [2, 4] is [2, 3].
	 */

	public static void main(String[] args) {
		int[][] firstList = new int[][] {{0,2},{5,10},{13,23},{24,25}};
		int[][] secondList = new int[][] {{1,5},{8,12},{15,24},{25,26}};
		
		int[][] result1 = intervalIntersection(firstList, secondList);
		int[][] result2 = intervalIntersection1(firstList, secondList);
		
		System.out.println(Arrays.deepToString(result1));

	}
	
	/*
	 * Intution: Take two pinters i and j for traversing the two lists starting with
	 * 0. Now at any point if the start of any interval at i or j is less than or
	 * equal to end of corresponding interval at j or i then this can be
	 * intersection if its making valid interval i.e, end>=start.
	 */
	
	
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length==0 || secondList.length==0) return new int[0][0];
        int i = 0;
        int j = 0;
        int startMax = 0, endMin = 0;
        List<int[]> ans = new ArrayList<>();
        
        while(i<firstList.length && j<secondList.length){
            startMax = Math.max(firstList[i][0],secondList[j][0]);
            endMin = Math.min(firstList[i][1],secondList[j][1]);
            
			//you have end greater than start and you already know that this interval is sorrounded with startMin and endMax so this must be the intersection
			if(endMin>=startMax){           
                ans.add(new int[]{startMax,endMin});
            }
            
			//the interval with min end has been covered completely and have no chance to intersect with any other interval so move that list's pointer
            if(endMin == firstList[i][1]) i++;       
            if(endMin == secondList[j][1]) j++;
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }

    
    /*
     * Faster solution
     */

    private static int[] getInterbvalIntersection(int[] A, int[] B){
        int lo = Math.max(A[0], B[0]);
        int hi = Math.min(A[1], B[1]);
        if (lo <= hi){
            return new int[] {lo, hi};
        }
        else{
            return new int[] {};
        }
    }
    public static int[][] intervalIntersection1(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        
        int firstLength = firstList.length;
        int secondLength = secondList.length;
        
        int firstIdx = 0;
        int secondIdx = 0;
        
        while(firstIdx < firstLength && secondIdx < secondLength){
            int[] intersection = getInterbvalIntersection(firstList[firstIdx], secondList[secondIdx]);
            if (intersection.length > 0){
                result.add(intersection);   
            }
            
            if(firstList[firstIdx][1] < secondList[secondIdx][1]){
                firstIdx += 1;
            }
            else{
                secondIdx += 1;
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
