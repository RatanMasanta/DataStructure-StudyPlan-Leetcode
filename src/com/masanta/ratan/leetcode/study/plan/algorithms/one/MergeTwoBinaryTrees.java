package com.masanta.ratan.leetcode.study.plan.algorithms.one;


public class MergeTwoBinaryTrees {

	public static void main(String[] args) {


		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		//		root.right.right = new TreeNode(10);
		root.left.left = new TreeNode(5);
		//		root.left.right = new TreeNode(7);

		TreeNode root1 = new TreeNode(2);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(3);
		root1.right.right = new TreeNode(7);
		//		root1.left.left = new TreeNode(3);
		root1.left.right = new TreeNode(4);


		TreeNode mergedRoot = mergeTrees(root, root1);
		System.out.println("Done");



	}

	public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

		if(root1==null && root2==null)return null;   //if both the trees are null then resultrant tree will be null too
		if(root1==null)return root2;                 //if one of the two trees is null then the other one is the resultant tree 
		if(root2==null)return root1;

		TreeNode root3 = new TreeNode(root1.val + root2.val, mergeTrees(root1.left, root2.left), mergeTrees(root1.right, root2.right));
		//root3.val = root1.val + root2.val
		//root3.left = mergeTrees(root1.left, root2.left
		//root3.right = mergeTrees(root1.right, root2.right

		return root3;
	}

}
