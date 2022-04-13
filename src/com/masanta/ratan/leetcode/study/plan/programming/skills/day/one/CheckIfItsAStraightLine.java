package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class CheckIfItsAStraightLine {

	public static void main(String[] args) {
		int[][] points = new int[][] {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
		System.out.println(checkStraightLine(points));

	}

	
	/*
	So basically at any point of time, any three coordinate should satisfy following condition to be colinear.

	(y2 - y1)(x3 - x1) == (x2 - x1)(y3 - y1)

	since there will be atleast two coordinates given, we can take first two coordinate and take ith coordinate to compute the formula.
	*/

	public static boolean checkStraightLine(int[][] coordinates) {
	    int[] a = coordinates[0];
	    int[] b = coordinates[1];
	    int x1 = a[0];
	    int x2 = b[0];
	    int y1 = a[1];
	    int y2 = b[1];

	    for (int i = 2; i < coordinates.length; i++) {
	      int[] curr = coordinates[i];
	      int x3 = curr[0];
	      int y3 = curr[1];
	      if((y2 - y1)*(x3 - x1) != (x2 - x1)*(y3 - y1)) return false;
	    }
	    return true;
	  }
	
}
