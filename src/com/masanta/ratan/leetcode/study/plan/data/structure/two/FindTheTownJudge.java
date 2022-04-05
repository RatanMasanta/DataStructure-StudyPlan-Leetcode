package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class FindTheTownJudge {

	/*
	 * Problem statement
	 * 
	 * In a town, there are n people labeled from 1 to n. There is a rumor that one
	 * of these people is secretly the town judge.
	 * 
	 * If the town judge exists, then:
	 * 
	 * The town judge trusts nobody. Everybody (except for the town judge) trusts
	 * the town judge. There is exactly one person that satisfies properties 1 and
	 * 2. You are given an array trust where trust[i] = [ai, bi] representing that
	 * the person labeled ai trusts the person labeled bi.
	 * 
	 * Return the label of the town judge if the town judge exists and can be
	 * identified, or return -1 otherwise.
	 */

	public static void main(String[] args) {
		/*
		 *  n = 3, trust = [[1,3],[2,3],[3,1]]
		 *  n = 3, trust = [[1,3],[2,3]]
		 *  n = 2, trust = [[1,2]]
		 */
		
		int[][] trustArray1 = new int[][] {{1,3},{2,3},{3,1}};
		int[][] trustArray2 = new int[][] {{1,3},{2,3}};
		int[][] trustArray3 = new int[][] {{1,2}};
		
		System.out.println(findJudge(3, trustArray1));
		System.out.println(findJudge(3, trustArray2));
		System.out.println(findJudge(2, trustArray3));

	}

	/*
	 * Solution:
	 * 
	 * Intuition: Consider trust as a graph, all pairs are directed edge. The point
	 * with in-degree - out-degree = N - 1 become the judge.
	 * 
	 * Explanation: Count the degree, and check at the end.
	 * 
	 * Time Complexity: Time O(T + N), space O(N)
	 */

	public static int findJudge(int N, int[][] trust) {
		int[] count = new int[N+1];
		for (int[] t: trust) {
			count[t[0]]--;
			count[t[1]]++;
		}
		for (int i = 1; i <= N; ++i) {
			if (count[i] == N - 1) return i;
		}
		return -1;
	}

}
