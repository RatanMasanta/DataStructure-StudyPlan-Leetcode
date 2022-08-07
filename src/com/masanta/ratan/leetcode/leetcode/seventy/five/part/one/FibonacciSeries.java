package com.masanta.ratan.leetcode.leetcode.seventy.five.part.one;

import java.util.HashMap;

public class FibonacciSeries {

	public static void main(String[] args) {
		System.out.println(fib(7));
		System.out.println(fibIterative(7));
		System.out.println(fibRecursive(7));
	}
	
	public static int fib(int N){
		if (N <= 1) {
			return N;            
		}

		// initialize base case variables
		int a = 0, b = 1;
		int sum = 0;
		
		while (N > 1) {
			// calculate next value as the sum of previous two values
			sum = a + b;

			// switch all values to the next value in the series
			a = b;
			b = sum;

			// decrement counter
			N -= 1;
		}

		return sum;
	}
	
	public static int fibIterative(int N) {
		// easy base cases/edge cases
		if (N <= 1) {
			return N;            
		}

		// initialize our memoization map
		// size N +1 so that we can accomodate from 0 to N
		int[] map = new int[N+1];
		
		// put our base cases
		map[0] = 0;
		map[1] = 1;
		
		// iterate through remaining values (2...N)
		for (int i = 2; i <= N; i += 1) {
			map[i] = map[i-1] + map[i-2];
		}
		return map[N];
	}
	
	public static int fibRecursive(int N) {
		// easy base cases/edge cases
		// this is not really necessary as our helper function already handles these use cases
		if (N <= 1) {
			return N;            
		}

		// initialize our memoization map and put our base cases
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);
		map.put(1, 1);

		// call helper function
		return fibHelper(N, map);
	}

	private static int fibHelper(int N, HashMap<Integer, Integer> map) {
		// have we already computed this sub-problem?
		// if not, then compute it and store it in our map
		if (!map.containsKey(N)) {
			int currentFib = fibHelper(N - 1, map) + fibHelper(N - 2, map);
			map.put(N, currentFib);
		}

		// since we have stored it already, simply return it
		return map.get(N);
	}

}
