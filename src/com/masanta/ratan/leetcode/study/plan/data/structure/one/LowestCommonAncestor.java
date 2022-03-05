package com.masanta.ratan.leetcode.study.plan.data.structure.one;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.right.left = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		
		TreeNode p = new TreeNode(6);
		TreeNode q = new TreeNode(4);
		
		TreeNode lowestCommonAncestor = lowestCommonAncestor(root, p, q);
		
		System.out.println("Done");

	}
	
	 public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
	        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
	        return root;
	    }

}
