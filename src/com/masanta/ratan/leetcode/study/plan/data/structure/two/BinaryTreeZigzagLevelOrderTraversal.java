package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

	
	/*
	 * Given the root of a binary tree, return the zigzag level order traversal of
	 * its nodes' values. (i.e., from left to right, then right to left for the next
	 * level and alternate between).
	 */			
			
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(9);
		tree.right = new TreeNode(20);
		tree.right.left = new TreeNode(15);
		tree.right.right = new TreeNode(7);
		
		List<List<Integer>> resultantZigZagOrderTraversal = zigzagLevelOrder(tree);
		System.out.println(Arrays.toString(resultantZigZagOrderTraversal.toArray()));
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }
    
    private static void travel(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) return;
        
        if(sol.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }
        
        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);
        
        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }

}
