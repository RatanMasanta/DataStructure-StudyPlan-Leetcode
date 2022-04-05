package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
	
	/*
	 * Problem statement
	 * 
	 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except
	 * for room 0. Your goal is to visit all the rooms. However, you cannot enter a
	 * locked room without having its key.
	 * 
	 * When you visit a room, you may find a set of distinct keys in it. Each key
	 * has a number on it, denoting which room it unlocks, and you can take all of
	 * them with you to unlock the other rooms.
	 * 
	 * Given an array rooms where rooms[i] is the set of keys that you can obtain if
	 * you visited room i, return true if you can visit all the rooms, or false
	 * otherwise.
	 */		

	public static void main(String[] args) {
		/*
		 * Input: rooms = [[1],[2],[3],[]] Output: true
		 * Explanation: We visit room 0 and
		 * pick up key 1. We then visit room 1 and pick up key 2. We then visit room 2
		 * and pick up key 3. We then visit room 3. Since we were able to visit every
		 * room, we return true.
		 */
		
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		List<Integer> list4 = new ArrayList<>();
		List<Integer> list5 = new ArrayList<>();
		list1.add(1);
		list1.add(3);
		list2.add(3);
		list2.add(0);
		list2.add(1);
		list3.add(2);
		list4.add(0);
		
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);

		
		
		System.out.println(canVisitAllRooms(list));
		

	}
	
	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> dfs = new Stack<>(); dfs.add(0);
        HashSet<Integer> seen = new HashSet<Integer>(); seen.add(0);
        while (!dfs.isEmpty()) {
            int i = dfs.pop();
            for (int j : rooms.get(i))
                if (!seen.contains(j)) {
                    dfs.add(j);
                    seen.add(j);
                    if (rooms.size() == seen.size()) return true;
                }
        }
        return rooms.size() == seen.size();
    }
	

}
