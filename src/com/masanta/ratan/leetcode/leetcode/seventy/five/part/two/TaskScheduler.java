package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
	/*
		Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. 
		Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task 
		or just be idle.

		However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that 
		there must be at least n units of time between any two same tasks.

		Return the least number of units of times that the CPU will take to finish all the given tasks.



		Example 1:
		
		Input: tasks = ["A","A","A","B","B","B"], n = 2
		Output: 8
		Explanation: 
		A -> B -> idle -> A -> B -> idle -> A -> B
		There is at least 2 units of time between any two same tasks.
		Example 2:
		
		Input: tasks = ["A","A","A","B","B","B"], n = 0
		Output: 6
		Explanation: On this case any permutation of size 6 would work since n = 0.
		["A","A","A","B","B","B"]
		["A","B","A","B","A","B"]
		["B","B","B","A","A","A"]
		...
		And so on.
		Example 3:
		
		Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
		Output: 16
		Explanation: 
		One possible solution is
		A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
	 
	 */
	
	public static void main(String[] args) {
		char[] tasks = new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'};
		System.out.println(leastInterval(tasks, 2));

	}

	public static int leastInterval(char[] tasks, int n) {
		if (n < 1) return tasks.length;
		int[] counts = new int[26];
		for (char c: tasks) {
			int cint = (int)(c - 'A');
			counts[cint]++;
		}
		int[] lastExec = new int[26];
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> -Integer.compare(counts[a], counts[b]));
		for (int i = 0; i < 26; i++) {
			if (counts[i] > 0)  {
				pq.offer(i);
			}
		}

		int curTime = 0;
		while(!pq.isEmpty()) {
			int prevCurTime = curTime;
			List<Integer> tmp = new LinkedList<>();
			int k = n + 1;
			// don't process more than k items since an item now process may become eligible again
			while (k-- > 0 && !pq.isEmpty()) { 
				int top = pq.poll();
				counts[top]--;
				tmp.add(top);
				curTime++;
			}
			for (int cand: tmp)
				if (counts[cand] > 0) pq.offer(cand);
			if (pq.isEmpty()) return curTime;
			curTime = prevCurTime + n + 1;
		}
		return curTime;
	}

}
