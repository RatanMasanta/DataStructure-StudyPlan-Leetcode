package com.masanta.ratan.leetcode.study.plan.data.structure.one;

import java.util.ArrayList;
import java.util.List;

public class PreOrderBinaryTraversal {

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
		
		List<Integer> preOrderTraversalArray = preorderTraversal(root);
		
		for(Integer nodeVal: preOrderTraversalArray ) {
			System.out.println(nodeVal);
		}


	}
	
	/*
	 * Recursive solution
	 * 
	 */
	
	static List<Integer> list = new ArrayList<>();
	public static List<Integer> preorderTraversal(TreeNode root) {
		if(root == null)
			return new ArrayList();

		list.add(root.val);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		return list;
	}

}
