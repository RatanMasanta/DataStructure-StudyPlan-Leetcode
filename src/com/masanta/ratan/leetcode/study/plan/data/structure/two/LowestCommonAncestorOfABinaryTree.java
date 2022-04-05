package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class LowestCommonAncestorOfABinaryTree {

	
	/*
	 * Problem statement
	 * 
	 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
	 * in the tree.
	 * 
	 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
	 * is defined between two nodes p and q as the lowest node in T that has both p
	 * and q as descendants (where we allow a node to be a descendant of itself).”
	 */
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		
		
		TreeNode root1 = root.left;
		TreeNode root2 = root.right;
		
		TreeNode lowestCommonAncestor = lowestCommonAncestor(root, root1, root2);
		System.out.println(lowestCommonAncestor.val);
		

	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }

}
