package com.masanta.ratan.leetcode.study.plan.data.structure.one;


public class InvertBinaryTree {

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
		
		TreeNode invertedRoot = invertTree(root);
		
		System.out.println("Done");
	}


	// Solution Approach: Bottom Up DFS
	// 1) x is null? return null
	// 2) dfs(left), dfs(right)
	// 3) swap (x.left, x.right)
	// 4) return x;
	public static TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;

		invertTree(root.left);
		invertTree(root.right);

		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;

		return root;
	}

}
