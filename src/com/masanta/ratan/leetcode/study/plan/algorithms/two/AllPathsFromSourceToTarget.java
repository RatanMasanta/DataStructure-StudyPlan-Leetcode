package com.masanta.ratan.leetcode.study.plan.algorithms.two;

import java.util.*;

public class AllPathsFromSourceToTarget {
	
	/*
	 * Statement
	 * 
	 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find
	 * all possible paths from node 0 to node n - 1 and return them in any order.
	 * 
	 * The graph is given as follows: graph[i] is a list of all nodes you can visit
	 * from node i (i.e., there is a directed edge from node i to node graph[i][j]).
	 */

	public static void main(String[] args) {
		int[][] directAcyclicGraph = new int[][] {{1,2},{3},{3},{}};
		int[][] directAcyclicGraph1 = new int[][] {{4,3,1},{3,2,4},{3},{4},{}};
		
		List<List<Integer>> result1 = allPathsSourceTarget(directAcyclicGraph1);
		for(List<Integer> intList: result1) {
			System.out.println(Arrays.toString(intList.toArray()));
		}
		System.out.println("Second graph data: ");
		
		List<List<Integer>> result2 = allPathsSourceTarget(directAcyclicGraph);
		for(List<Integer> intList: result2) {
			System.out.println(Arrays.toString(intList.toArray()));
		}
	}
	
	 public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
	        List<List<Integer>> res = new ArrayList<>();
	        List<Integer> path = new ArrayList<>();
						
	        path.add(0);
	        dfsSearch(graph, 0, res, path);
						
	        return res;
	    }

	    private static void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
	        if (node == graph.length - 1) {
	            res.add(new ArrayList<Integer>(path));
	            return;
	        }

	        for (int nextNode : graph[node]) {
	            path.add(nextNode);
	            dfsSearch(graph, nextNode, res, path);
	            path.remove(path.size() - 1);
	        }
	    }


}
