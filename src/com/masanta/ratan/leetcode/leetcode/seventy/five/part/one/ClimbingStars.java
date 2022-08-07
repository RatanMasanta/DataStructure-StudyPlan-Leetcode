package com.masanta.ratan.leetcode.leetcode.seventy.five.part.one;

public class ClimbingStars {

	public static void main(String[] args) {
		System.out.println(climbStairs(7));

	}

	private static int[] arr = new int[46];
    public static int climbStairs(int n) {
        if(n <= 3) {
            return n;
        }
        int count = 0;
        if(arr[n] > 0) {
            count = arr[n];
        } else {
            count = climbStairs(n-1)+climbStairs(n-2);
            arr[n] = count;
        }
        return count;
    }
	
}
