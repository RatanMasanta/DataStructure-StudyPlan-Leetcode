package com.masanta.ratan.leetcode.study.plan.data.structure.one;

import java.util.ArrayDeque;
import java.util.Deque;


public class PathSumInTree {
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}


	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(10);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		
		System.out.println(hasPathSum(root, 18));
		
	}
	
	 // Iterative solution (preorder traversal)
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // Deque is more recommended than Stack<E>
        Deque<Pair> stack = new ArrayDeque<>();
        stack.offerLast(new Pair(root, targetSum - root.val));

        while (!stack.isEmpty()) {
            // Get the remaining sum
            int remain = stack.peekLast().difference;
            TreeNode node = stack.pollLast().node;
            // Check if leaf and remaining == 0
            if (node.left == null && node.right == null && remain == 0) {
                return true;
            }
            if (node.right != null) {
                stack.offerLast(new Pair(node.right, remain - node.right.val));
            }
            if (node.left != null) {
                stack.offerLast(new Pair(node.left, remain - node.left.val));
            }

        }
        return false;
    }
    
    private static class Pair {
        TreeNode node;
        int difference;

        Pair(TreeNode node, int difference) {
            this.node = node;
            this.difference = difference;
        }
    }

}
