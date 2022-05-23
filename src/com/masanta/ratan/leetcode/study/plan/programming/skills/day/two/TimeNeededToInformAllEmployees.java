package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInformAllEmployees {
	
	/*
	 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

		Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.
		
		The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.
		
		The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).
		
		Return the number of minutes needed to inform all the employees about the urgent news.
		
		 
		
		Example 1:
		
		Input: n = 1, headID = 0, manager = [-1], informTime = [0]
		Output: 0
		Explanation: The head of the company is the only employee in the company.
	 * 
	 */

	public static void main(String[] args) {
		System.out.println(numOfMinutes(6,2, new int[] {2,2,-1,2,2,2}, new int[] {0,0,1,0,0,0}));
	}


	/*
    Solution 1: Top down DFS
    dfs find out the time needed for each employees.
    The time for a manager = max(manager's employees) + informTime[manager]

    Time O(N), Space O(N)
	 */
	public static int numOfMinutes(final int n, final int headID, final int[] manager, final int[] informTime) {
		final Map<Integer, List<Integer>> graph = new HashMap<>();
		int total = 0;
		for (int i = 0; i < manager.length; i++) {
			int j = manager[i];
			if (!graph.containsKey(j))
				graph.put(j, new ArrayList<>());
			graph.get(j).add(i);
		}
		return dfs(graph, informTime, headID);
	}

	private static int dfs(final Map<Integer, List<Integer>> graph, final int[] informTime, final int cur) {
		int max = 0;
		if (!graph.containsKey(cur))
			return max;
		for (int i = 0; i < graph.get(cur).size(); i++)
			max = Math.max(max, dfs(graph, informTime, graph.get(cur).get(i)));
		return max + informTime[cur];
	}

}
