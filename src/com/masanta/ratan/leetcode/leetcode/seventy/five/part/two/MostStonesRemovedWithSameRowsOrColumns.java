package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostStonesRemovedWithSameRowsOrColumns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}   
	
	
	public static int removeStones(int[][] stones) {
        boolean[] visited = new boolean[stones.length];
        HashMap<Integer, List<Integer>> row = new HashMap<>();
        HashMap<Integer, List<Integer>> col = new HashMap<>();
        for (int i = 0; i < stones.length; i++){
            row.computeIfAbsent(stones[i][0], o -> new ArrayList<>()).add(i); // so we can find other stones based on row
            col.computeIfAbsent(stones[i][1], o -> new ArrayList<>()).add(i); // so we can find other stones based on col
        }

        int numOfIsland = 0;
        for (int i = 0; i < stones.length; i++)
            if (!visited[i]){
                removeIsland(visited, stones, i, row, col);
                numOfIsland++;
            }

        return stones.length - numOfIsland;
    }

    private static void removeIsland(boolean[] visited, int[][] stones, int idx,
            Map<Integer, List<Integer>> row, Map<Integer, List<Integer>> col){
        if (visited[idx]) return; // base case

        visited[idx] = true; // mark as visited.
        int r = stones[idx][0];
        int c = stones[idx][1];
        for (int index : row.get(r)) // not null because the current stone is in it
            removeIsland(visited, stones, index, row, col); // visit all the stones on this row

        for (int index : col.get(c))
            removeIsland(visited, stones, index, row, col); // visit all the stones on this col
    }

}
