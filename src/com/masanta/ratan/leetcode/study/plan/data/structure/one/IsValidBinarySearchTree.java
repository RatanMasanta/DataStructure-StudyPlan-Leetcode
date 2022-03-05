package com.masanta.ratan.leetcode.study.plan.data.structure.one;

public class IsValidBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
//		root.right.right = new TreeNode(6);
//		root.right.left = new TreeNode(6);
//		root.left.left = new TreeNode(1);
//		root.left.right = new TreeNode(4);
		
		System.out.println(isValidBST(root));

	}

	 public static boolean isValidBST(TreeNode root) {
	        return verifyBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	    }
	    
	    public static boolean verifyBST(TreeNode t, long minVal, long maxVal) {
	        if (t == null) 
	            return true;
	        if (t.val <= minVal || t.val >= maxVal) 
	            return false;
	        
	        return verifyBST(t.left, minVal, t.val) && verifyBST(t.right, t.val, maxVal);
	    }
}
