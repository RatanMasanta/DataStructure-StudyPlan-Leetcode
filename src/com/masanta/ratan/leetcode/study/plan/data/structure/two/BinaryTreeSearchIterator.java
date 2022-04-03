package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.Stack;

public class BinaryTreeSearchIterator {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);

		BinaryTreeSearchIterator obj = new BinaryTreeSearchIterator(root);
		int param_1 = obj.next();
		boolean param_2 = obj.hasNext();
		
		System.out.println(param_1);
		System.out.println(param_2);

	}

	private static Stack<TreeNode> stack = new Stack<TreeNode>();

	public BinaryTreeSearchIterator(TreeNode root) {
		pushAll(root);
	}

	/** @return whether we have a next smallest number */
	public static boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public static int next() {
		TreeNode tmpNode = stack.pop();
		pushAll(tmpNode.right);
		return tmpNode.val;
	}

	private static void pushAll(TreeNode node) {
		for (; node != null; stack.push(node), node = node.left);
	}

}
