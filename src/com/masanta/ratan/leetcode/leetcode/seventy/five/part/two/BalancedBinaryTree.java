package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public static boolean isBalanced(TreeNode root) {
	        return getHeight(root) != -1;
	    }
	    
	    private static int getHeight(TreeNode node) {
	        if (node == null) return 0;

	        int left = getHeight(node.left);
	        int right = getHeight(node.right);

	        // left, right subtree is unbalanced or cur tree is unbalanced
	        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

	        return Math.max(left, right) + 1;
	    }
	    
	    private  class TreeNode {
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

}
