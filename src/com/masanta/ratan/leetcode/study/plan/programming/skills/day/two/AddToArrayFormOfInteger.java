package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {

	public static void main(String[] args) {
		System.out.println(addToArrayForm(new int[] {1,2,3,4}, 45));
		System.out.println(addToArrayForm1(new int[] {1,2,3,4}, 35));
	}

	/*    Explanation
	Take K as a carry.
	Add it to the lowest digit,
	Update carry K,
	and keep going to higher digit.


	Complexity
	Insert will take O(1) time or O(N) time on shifting, depending on the data stucture.
	But in this problem K is at most 5 digit so this is restricted.
	So this part doesn't matter.

	The overall time complexity is O(N).
	For space I'll say O(1)
	 */

	public static List<Integer> addToArrayForm(int[] A, int K) {
		List<Integer> res = new LinkedList<>();
		for (int i = A.length - 1; i >= 0; --i) {
			res.add(0, (A[i] + K) % 10);
			K = (A[i] + K) / 10;
		}
		while (K > 0) {
			res.add(0, K % 10);
			K /= 10;
		}
		return res;
	}

	/*
	     one loop solution
	 */
	public static List<Integer> addToArrayForm1(int[] A, int K) {
		List res = new LinkedList<>();
		for (int i = A.length - 1; i >= 0 || K > 0; --i) {
			res.add(0, (i >= 0 ? A[i] + K : K) % 10);
			K = (i >= 0 ? A[i] + K : K) / 10;
		}
		return res;
	}

}
