package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

public class MaximumProductSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static int maxProduct(int[] A) {
	        if (A == null || A.length == 0) {
	            return 0;
	        }
	        int max = A[0], min = A[0], result = A[0];
	        for (int i = 1; i < A.length; i++) {
	            int temp = max;
	            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
	            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
	            if (max > result) {
	                result = max;
	            }
	        }
	        return result;
	    }

}
