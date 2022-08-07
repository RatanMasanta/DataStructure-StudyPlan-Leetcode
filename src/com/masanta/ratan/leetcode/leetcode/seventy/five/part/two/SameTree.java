package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        return p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
