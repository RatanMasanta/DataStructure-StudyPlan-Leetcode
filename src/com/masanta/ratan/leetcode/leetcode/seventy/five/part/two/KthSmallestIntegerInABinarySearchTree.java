package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

public class KthSmallestIntegerInABinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int kthSmallest(TreeNode root, int k) {
		var kSmallest = new int[1];
		inorder(root, new int[]{k}, kSmallest);
		return kSmallest[0];
	}

	private static void inorder(TreeNode root, int[] count, int[] kSmallest) {
		if (root == null || count[0] == 0)
			return;
		// recurse left
		inorder(root.left, count, kSmallest);
		// visit
		if (--count[0] == 0)
			kSmallest[0] = root.val;
		else
		// recurse right
			inorder(root.right, count, kSmallest);
	}

}
