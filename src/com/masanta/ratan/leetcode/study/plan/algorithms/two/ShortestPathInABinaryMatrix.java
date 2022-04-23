package com.masanta.ratan.leetcode.study.plan.algorithms.two;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInABinaryMatrix {

	/*
	Problem statement

	Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

			A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

			All the visited cells of the path are 0.
			All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
			The length of a clear path is the number of visited cells of this path.
	 */

	public static void main(String[] args) {
		int[][] grid = new int[][] {{0,0,0},{1,1,0},{1,1,0}};
		System.out.println(shortestPathBinaryMatrix(grid));
		

	}

	public static int shortestPathBinaryMatrix(int[][] grid) {
		int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}, {1,1}, {-1,1}, {1,-1}, {-1,-1}};

		if(grid == null || grid.length == 0) return -1;

		if(grid[0][0] != 0) return -1;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0,0});

		while(!queue.isEmpty()){

			int[] curr = queue.poll();
			if(curr[0] == grid.length-1 && curr[1] == grid[0].length-1) return curr[2]+1;


			for(int i=0; i < dirs.length; i++){
				int x = curr[0] + dirs[i][0];
				int y = curr[1] + dirs[i][1];

				if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 0) continue;

				grid[x][y] = -1;
				queue.add(new int[]{x,y, curr[2]+1});
			}
		}

		return -1;
	}

	
}
