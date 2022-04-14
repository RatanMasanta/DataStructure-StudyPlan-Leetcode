package com.masanta.ratan.leetcode.study.plan.algorithms.two;

public class NumberOfProvincesUsingDFS {
	
	/*
	 * Problem statement:
	 * 
	 * There are n cities. Some of them are connected, while some are not. If city a
	 * is connected directly with city b, and city b is connected directly with city
	 * c, then city a is connected indirectly with city c.
	 * 
	 * A province is a group of directly or indirectly connected cities and no other
	 * cities outside of the group.
	 * 
	 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
	 * ith city and the jth city are directly connected, and isConnected[i][j] = 0
	 * otherwise.
	 * 
	 * Return the total number of provinces.
	 */

	public static void main(String[] args) {
		System.out.println(findCircleNum(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));

	}
	
	public static int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length]; //visited[i] means if ith person is visited in this algorithm
        int count = 0;
        for(int i = 0; i < M.length; i++) {
            if(!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    private static void dfs(int[][] M, boolean[] visited, int person) {
        for(int other = 0; other < M.length; other++) {
            if(M[person][other] == 1 && !visited[other]) {
                //We found an unvisited person in the current friend cycle 
                visited[other] = true;
                dfs(M, visited, other); //Start DFS on this new found person
            }
        }
    }

}
