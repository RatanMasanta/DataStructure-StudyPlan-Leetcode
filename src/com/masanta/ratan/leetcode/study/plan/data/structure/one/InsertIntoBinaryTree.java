package com.masanta.ratan.leetcode.study.plan.data.structure.one;

public class InsertIntoBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.right = new TreeNode(6);
		root.right.left = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		
		TreeNode result = insertIntoBST(root, 8);
		
		System.out.println("Done");

	}

	
	public static TreeNode insertIntoBST(TreeNode root, int val) {
	     //recursive
	    if(root==null)return new TreeNode(val);
	    if(root.val<val){
	        root.right=insertIntoBST(root.right,val);
	    }
	    else{
	        root.left=insertIntoBST(root.left,val);
	    }
	    return root;
	
	//itertive
	// if(root == null) return new TreeNode(val);
	// TreeNode cur = root;
	// while(true) {
	// if(cur.val <= val) {
	// if(cur.right != null) cur = cur.right;
	// else {
	// cur.right = new TreeNode(val);
	// break;
	// }
	// } else {
	// if(cur.left != null) cur = cur.left;
	// else {
	// cur.left = new TreeNode(val);
	// break;
	// }
	// }
	// }
	// return root;
	//}
	}
}
