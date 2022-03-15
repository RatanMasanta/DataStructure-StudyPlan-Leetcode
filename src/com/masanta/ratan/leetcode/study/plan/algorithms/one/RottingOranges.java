package com.masanta.ratan.leetcode.study.plan.algorithms.one;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	public static void main(String[] args) {
		int[][] rottenOrangesGrid = {{2,1,1}, {1,1,0}, {0,1,1}};
		int orangesRotting  = orangesRotting(rottenOrangesGrid);
		System.out.println(orangesRotting);
	}
	
	public static int[][] grid;
	static int m;
	static int n;
	public static int orangesRotting(int[][] grid1) {
		// 1. Do DFS, find count
		grid = grid1;
		m = grid.length;
		n = grid[0].length;
		int count = 0;
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < m; i += 1) {
			for (int j = 0; j < n; j += 1) {
				if (grid[i][j] == 2) {
					queue.offer(new int[]{i, j});
					grid[i][j] = 0;
				}
			}
		}
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			while (qSize-- > 0) {
				int[] e = queue.poll();
				int x = e[0];
				int y = e[1];

				// top
				if (x > 0 && grid[x - 1][y] == 1) {
					queue.offer(new int[]{x - 1, y});
					grid[x - 1][y] = 0;
				}
				// left
				if (y > 0 && grid[x][y - 1] == 1) {
					queue.offer(new int[]{x, y - 1});
					grid[x][y - 1] = 0;
				}
				// right
				if (y < n -1 && grid[x][y + 1] == 1) {
					queue.offer(new int[]{x, y + 1});
					grid[x][y + 1] = 0;
				}
				// bottom
				if (x < m - 1 && grid[x + 1][y] == 1) {
					queue.offer(new int[]{x + 1, y});
					grid[x + 1][y] = 0;
				}
			}
			count += 1;
		}

		// 2. If fresh orange return -1
		for (int i = 0; i < m; i += 1) {
			for (int j = 0; j < n; j += 1) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}
		return count == 0 ? count : count - 1;
	}

}
