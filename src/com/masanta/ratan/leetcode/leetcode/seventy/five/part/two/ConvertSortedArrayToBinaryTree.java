package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

public class ConvertSortedArrayToBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static TreeNode sortedArrayToBST(int[] num) {
	    if (num.length == 0) {
	        return null;
	    }
	    TreeNode head = helper(num, 0, num.length - 1);
	    return head;
	}

	public static TreeNode helper(int[] num, int low, int high) {
	    if (low > high) { // Done
	        return null;
	    }
	    int mid = (low + high) / 2;
	    TreeNode node = new TreeNode(num[mid]);
	    node.left = helper(num, low, mid - 1);
	    node.right = helper(num, mid + 1, high);
	    return node;
	}

}
