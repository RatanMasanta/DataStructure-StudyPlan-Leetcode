package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {

	
	/*
	 * Problem statement
	 * 
	 * Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and
	 * an array edges where edges[i] = [fromi, toi] represents a directed edge from
	 * node fromi to node toi.
	 * 
	 * Find the smallest set of vertices from which all nodes in the graph are
	 * reachable. It's guaranteed that a unique solution exists.
	 * 
	 * Notice that you can return the vertices in any order.
	 */
	
	
	public static void main(String[] args) {
		/*
		 * Input: n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]] Output: [0,3]
		 * Explanation: It's not possible to reach all the nodes from a single vertex.
		 * From 0 we can reach [0,1,2,5]. From 3 we can reach [3,4,2,5]. So we output
		 * [0,3].
		 * 
		 * Input: n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]] Output: [0,2,3]
		 * Explanation: Notice that vertices 0, 3 and 2 are not reachable from any other
		 * node, so we must include them. Also any of these vertices can reach nodes 1
		 * and 4.
		 */
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		List<Integer> list4 = new ArrayList<>();
		List<Integer> list5 = new ArrayList<>();
		list1.add(0);
		list1.add(1);
		list2.add(2);
		list2.add(1);
		list3.add(3);
		list3.add(1);
		list4.add(1);
		list4.add(4);
		list5.add(2);
		list5.add(4);
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		list.add(list5);
		
		
		System.out.println(findSmallestSetOfVertices(5,list));

	}
	
	/*
	 * Solution:
	 * 
	 * Intuition Just return the nodes with no in-degres.
	 * 
	 * 
	 * Explanation Quick prove:
	 * 
	 * Necesssary condition: All nodes with no in-degree must in the final result,
	 * because they can not be reached from All other nodes can be reached from any
	 * other nodes.
	 * 
	 * Sufficient condition: All other nodes can be reached from some other nodes.
	 * 
	 * 
	 * Complexity Time O(E) Space O(N)
	 */
	 public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
	        List<Integer> res = new ArrayList<>();
	        int[] seen = new int[n];
	        for (List<Integer> e: edges)
	            seen[e.get(1)] = 1;
	        for (int i = 0; i < n; ++i)
	            if (seen[i] == 0)
	                res.add(i);
	        return res;
	    }
}
