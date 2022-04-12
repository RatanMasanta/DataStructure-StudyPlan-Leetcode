package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class FindNearestPointWithSameXOrYCoOrdinates {

	/*
	 * problem statement
	 * 
	 * You are given two integers, x and y, which represent your current location on
	 * a Cartesian grid: (x, y). You are also given an array points where each
	 * points[i] = [ai, bi] represents that a point exists at (ai, bi). A point is
	 * valid if it shares the same x-coordinate or the same y-coordinate as your
	 * location.
	 * 
	 * Return the index (0-indexed) of the valid point with the smallest Manhattan
	 * distance from your current location. If there are multiple, return the valid
	 * point with the smallest index. If there are no valid points, return -1.
	 * 
	 * The Manhattan distance between two points (x1, y1) and (x2, y2) is abs(x1 -
	 * x2) + abs(y1 - y2).
	 */

	public static void main(String[] args) {
		int[][] array = new int[][] {{1,2},{3,1},{2,4},{2,3},{4,4}};
		System.out.println(nearestValidPoint(3, 4, array));
		System.out.println(nearestValidPoint1(3, 4, array));
	}

	/*****
	1. We first iterate through the array and find the manhatten distance for each point.
	2. We also maintain the minimum
	3. If manhatten distance < minimum ==> found new answer till now.

	4. After iterating points return answer.

	Time C = O(N)
	SC = O(N)


	 *******/

	public static int nearestValidPoint(int x, int y, int[][] points) {

		int min = Integer.MAX_VALUE;
		int index = -1;

		for(int i=0;i<points.length; i++){
			int[] point = points[i];
			if(x == point[0] || y == point[1]){
				int d = Math.abs(x - point[0]) + Math.abs(y - point[1]);
				if(d < min){
					index = i;
					min = d;
				}
			}
		}

		return index;
	}

	public static int nearestValidPoint1(int x, int y, int[][] points) {
		int index = -1; 
		for (int i = 0, smallest = Integer.MAX_VALUE; i < points.length; ++i) {
			int dx = x - points[i][0], dy = y - points[i][1];
			if (dx * dy == 0 && Math.abs(dy + dx) < smallest) {
				smallest = Math.abs(dx + dy);
				index = i;
			}
		}
		return index;
	}

}
