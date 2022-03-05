package com.masanta.ratan.leetcode.study.plan.algorithms.one;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	/**
	   * @param nums   sorted arrray
	   * @param target find this number
	   * @return index of target in given array or -1 if not present
	   * <p>
	   * Approach: Simple Binary Search
	   * I have shown both recursive and iterative approach
	   */
	  public static int search(int[] nums, int target) {
	    // uncomment anyone of it to test

	    // recursive
	    // return recursiveBinarySearch(nums, target, 0, nums.length - 1);

	    // iterative
	     return iterativeBinarySearch(nums, target);

//	    return 0;
	  }

	  /**
	   * Recursive way of binary search
	   */
	  private static int recursiveBinarySearch(int[] arr, int target, int left, int right) {
	    // base case searched the whole array, target not found
	    if (left > right) return -1;

	    // calculate mid index
	    int midIndex = left + (right - left) / 2;

	    // if mid index value is target value return the midIndex
	    if (arr[midIndex] == target) return midIndex;

	    // if target is greater, search in left array
	    if (arr[midIndex] > target)
	      return recursiveBinarySearch(arr, target, left, midIndex - 1);

	    // else search in right array
	    return recursiveBinarySearch(arr, target, midIndex + 1, right);
	  }

	  /**
	   * Binary search iterative way
	   */
	  private static int iterativeBinarySearch(int[] arr, int target) {
	    // initialize left and right pointer
	    int left = 0;
	    int right = arr.length - 1;

	    // search array until left index overflow right
	    while (left <= right) {
	      // calculate middle index
	      int midIndex = left + (right - left) / 2;

	      // return midIndex if its position contains target
	      if (arr[midIndex] == target) return midIndex;

	      // if target is smaller, search left array by making mid-1 as right pointer
	      if (arr[midIndex] > target) right = midIndex - 1;
	        // else target is greater, search right array by making mid + 1 as left pointer
	      else left = midIndex + 1;
	    }

	    // target isn't found, return the -1
	    return -1;
	  }
}
