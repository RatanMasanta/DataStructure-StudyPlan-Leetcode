package com.masanta.ratan.leetcode.study.plan.data.structure.one;

public class SearchInBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.right = new TreeNode(6);
		root.right.left = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		
		TreeNode result = searchBST(root, 7);
		System.out.println("Done");

	}
	
	public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        if(root.val > val){
            root = root.left;
            return searchBST(root,val);
        } else {
            root = root.right;
            return searchBST(root,val);
        }
    }

}
