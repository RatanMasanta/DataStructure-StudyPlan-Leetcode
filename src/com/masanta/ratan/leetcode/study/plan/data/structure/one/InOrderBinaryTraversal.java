package com.masanta.ratan.leetcode.study.plan.data.structure.one;

import java.util.ArrayList;
import java.util.List;

import com.masanta.ratan.leetcode.study.plan.data.structure.one.PreOrderBinaryTraversal.TreeNode;

public class InOrderBinaryTraversal {

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
		
		List<Integer> inOrderTraversalArray = inorderTraversal(root);
		
		for(Integer nodeVal: inOrderTraversalArray ) {
			System.out.println(nodeVal);
		}

	}

	private static List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<Integer>();

		recInorder(root, list);

		return list;
	}

	private static void recInorder(TreeNode node, List<Integer> list){

		if(node == null) return;

		recInorder(node.left, list);
		list.add(node.val);
		recInorder(node.right, list);

	}

}
