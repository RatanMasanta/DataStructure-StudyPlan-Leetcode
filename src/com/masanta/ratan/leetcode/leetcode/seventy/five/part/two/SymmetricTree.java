package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) 
            return true;
        
        return isSymmetric(root.left, root.right);
    }
    
    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) 
            return true;

        if (left == null || right == null) 
            return false;

        if (left.val != right.val) 
            return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
	
}
