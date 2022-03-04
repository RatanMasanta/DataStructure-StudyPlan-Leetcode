package com.masanta.ratan.leetcode.study.plan.data.structure.one;


public class MaxDepthOfBinaryTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(10);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		
		System.out.println(maxDepth(root));
		
	}

	public static int maxDepth(TreeNode root) {
	     
        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        if(rh>lh) return rh+1;
        else return lh+1;
        
    }
	
}
