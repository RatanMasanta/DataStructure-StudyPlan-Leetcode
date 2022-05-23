package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubArrays {
	/* 
	 *A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between every two consecutive elements is the same. More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i.

		For example, these are arithmetic sequences:
		
		1, 3, 5, 7, 9
		7, 7, 7, 7
		3, -1, -5, -9
		The following sequence is not arithmetic:
		
		1, 1, 2, 5, 7
		You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range queries, where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.
		
		Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise.

	 */

	public static void main(String[] args) {
		System.out.println(Arrays.toString(checkArithmeticSubarrays(new int[] {4,6,5,9,3,7},
				new int[] {0,0,2}, new int[] {2,3,5}).toArray()));

	}
	
	public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
	    int totalNoOfQueries = l.length; // OR r.length
	    
	    List<Boolean> answerList = new ArrayList<>();
	    
	    for (int i = 0 ; i < totalNoOfQueries ; i++) {
	        int currentQuerySubArraySize = r[i] - l[i] + 1;
			// If currentQuerySubArraySize = 2 => currentSubArray Is An AP (Because Only 2 Elements)
	        if (currentQuerySubArraySize == 2) {
	            answerList.add(true);
	        }
	        else if (isCurrentSubArrayAnArithmeticSequence(nums, l[i], r[i]) == true) {
	            answerList.add(true);
	        }
	        else {
	            answerList.add(false);
	        }
	    }
	    
	    return answerList;
	}

	public static boolean isCurrentSubArrayAnArithmeticSequence(int[] nums, int startIndex, int endIndex) {
	    int minimumSubArrayElement = Integer.MAX_VALUE;
	    int maximumSubArrayElement = Integer.MIN_VALUE;
	    
	    for (int i = startIndex ; i <= endIndex ; i++) {
	        minimumSubArrayElement = Math.min(minimumSubArrayElement, nums[i]);
	        maximumSubArrayElement = Math.max(maximumSubArrayElement, nums[i]);
	    }
	    
	    if (minimumSubArrayElement == maximumSubArrayElement) { // => All SubArray Elements Are Same/Equal => currentSubArray Is An AP 
	        return true;
	    }
	    
	    int n = endIndex - startIndex + 1; // n = currentSubArrayLength
	    
	    // an = a + (n - 1) * d => d = (an - a) / (n - 1) => d(Common Diff) Is ALWAYS Divisible By (n - 1), an = Max(LastTerm), a = Min(FirstTerm)
	    if ((maximumSubArrayElement - minimumSubArrayElement) % (n - 1) != 0) {
	        return false;
	    }
	    
	    int commonDifference = (maximumSubArrayElement - minimumSubArrayElement) / (n - 1);
	    
	    // Checking Duplicate Elements Ex - [1, 3, 5, 5, 7, 9]
	    
	    boolean[] isDuplicatePresentArr = new boolean[n];
	    
	    for (int i = startIndex ; i <= endIndex ; i++) {
	        if ((nums[i] - minimumSubArrayElement) % commonDifference != 0) {
	            return false;
	        }
	        
	        // ith Term Of AP Formula => ai = a + (i - 1) * d => i = (ai - a) / d + 1. But Since Array Indexing Starts From 0 => i = (ai - a) / d
	        // So Every SubArray Element Of AP Will Have Its Unique Index In Boolean Array, So We Can Easily Find Duplicate Elements In SubArray
	        // So, ai = nums[i] , a = minimumSubArrayElement , d = commonDifference
	        
	        int currentSubArrayElementUniqueIndex = (nums[i] - minimumSubArrayElement) / commonDifference;
	        
	        // By Default All Values Of This Boolean Array Are False. For Every Unique Element Of AP Encountered, Mark True, If We Reach Any Duplicate Element Then We Will Encounter True As It Was Already Marked By Its First Occurence, Hence, Return False
	        if (isDuplicatePresentArr[currentSubArrayElementUniqueIndex] == true) { // => Duplicate Encountered Here
	            return false;
	        }
	        else {
	            isDuplicatePresentArr[currentSubArrayElementUniqueIndex] = true;
	        }
	        
	    }
	    
	    return true;
	}

}
