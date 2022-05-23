package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.Arrays;

public class KClosestPointsToOrigin {
	
	/*
	 * 
	 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
	 */

	public static void main(String[] args) {
		int[][] pointsGroup = new int[][] {{3,3},{5,-1},{-2,4}};
		int k = 2;
		int[][] result2 = kClosest2(pointsGroup,k);
		int[][] result1 = kClosest1(pointsGroup,k);
		for(int[] row: result1) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("Second method: ");
		for(int[] row: result2) {
			System.out.println(Arrays.toString(row));
		}
		

	}

	public static int[][] kClosest1(int[][] points, int k) {
		Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
		return Arrays.copyOfRange(points, 0, k);
	}

	public static int[][] kClosest2(int[][] points, int K) {
		if (points == null || points.length == 0)
			return points;
		if (K > points.length)
			K = points.length;
		int[][] res = new int[K][2];
		for(int i = 0; i < K; i++)
		{
			res[i] = points[i];
			swim(res, i, K);
		}
		for (int i = K; i < points.length; i++)
		{
			if (dist(res[0]) > dist(points[i]))
			{
				res[0] = points[i];
				sink(res, 0, K);
			}
		}
		return res;

	}
	private static void sink(int[][] res, int n, int K)
	{
		int dist = dist(res[n]);
		while (2*n+1 < K)
		{
			int kid = n*2+1; //left child
			int dist1 = dist(res[kid]); //right child if exist
			int dist2 = Integer.MIN_VALUE;
			if (kid + 1 < K)
				dist2 = dist(res[kid+1]);
			if(dist1 < dist2)
				kid++;
			if (dist > Math.max(dist1, dist2))
				break;
			swap(res, n, kid);           
			n = kid;
		}
	}
	private static void swim(int[][] res, int n, int K)
	{
		int dist = dist(res[n]);
		while (n > 0)
		{
			int d = dist(res[(n-1)/2]); //parent
			if (d < dist)
			{
				swap(res, n, (n-1)/2);
				n = (n-1)/2;
			}
			else
				break;
		}
	}
	private static void swap(int[][] res, int a, int b)
	{
		int[] t = res[a];
		res[a] = res[b];
		res[b] = t;
	}

	private static int dist(int[] point)
	{
		return point[0]*point[0] + point[1]*point[1];
	}

}
