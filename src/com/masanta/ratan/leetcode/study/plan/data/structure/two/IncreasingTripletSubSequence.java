package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class IncreasingTripletSubSequence {

	public static void main(String[] args) {
		System.out.println(increasingTriplet(new int[] {2,1,5,0,4,6}));
		System.out.println(increasingTriplet(new int[] {8,7,6,7,5,8}));

	}
	
	 public static boolean increasingTriplet(int[] nums) {
         // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }

}
