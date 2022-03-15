package com.masanta.ratan.leetcode.study.plan.algorithms.one;

import java.util.Deque;
import java.util.LinkedList;

public class DistanceOfNewestZeroForEachCell {

	public static void main(String[] args) {
		int[][] arr = {{0,0,0}, {0,1,0}, {0,0,0}};
		int[][] arr2 = {{0,0,0}, {0,1,0}, {1,1,1}};
		
		int[][] arrUpdated = updateMatrix(arr);
		int[][] arr2Updated = updateMatrix(arr2);
		
		System.out.println("Done");

	}
	
	 public static class Pair {
	        int i = 0;
	        int j = 0;
	        Pair(int i, int j) {
	            this.i = i;
	            this.j = j;
	        }
	    }
	    
	    public static int[] di = new int[]{0, 1, 0, -1};
	    public static int[] dj = new int[]{1, 0, -1, 0};
	    public final static int INF = 1000000007;
	    
	    public static void bfs(int[][] mat, int[][] dist, int n, int m) {
	        Deque<Pair> deque = new LinkedList<>();
	        for (int is = 0; is < n; is++) {
	            for (int js = 0; js < m; js++) {
	                dist[is][js] = INF;
	            }
	        }
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                if (mat[i][j] == 0) {
	                    deque.add(new Pair(i, j));
	                    dist[i][j] = 0;
	                }
	            }
	        }
	        
	        while (!deque.isEmpty()) {
	            Pair cur = deque.removeFirst();
	            for (int h = 0; h < 4; h++) {
	                int toi = cur.i + di[h];
	                int toj = cur.j + dj[h];
	                if (toi >= 0 && toi < n && toj >= 0 && toj < m &&
	                    dist[toi][toj] > dist[cur.i][cur.j] + mat[toi][toj]) {
	                    if (mat[toi][toj] == 0) {
	                        dist[toi][toj] = dist[cur.i][cur.j];
	                        deque.addFirst(new Pair(toi, toj));
	                    } else {
	                        dist[toi][toj] = dist[cur.i][cur.j] + 1;
	                        deque.addLast(new Pair(toi, toj));
	                    }
	                }
	            }
	        }
	    }
	    
	    public static int[][] updateMatrix(int[][] mat) {
	        final int n = mat.length;
	        final int m = mat[0].length;
	        int[][] dist = new int[n][m];
	        bfs(mat, dist, n, m);
	        return dist;
	    }

}
