package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class MaxDepthOfABinaryTree {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(9);
		tree.right = new TreeNode(20);
		tree.right.left = new TreeNode(15);
		tree.right.right = new TreeNode(7);
		
		System.out.println(maxDepth(tree));

	}

	public static int maxDepth(TreeNode root) {
	     
        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        if(rh>lh) return rh+1;
        else return lh+1;
        
    }
	
}
