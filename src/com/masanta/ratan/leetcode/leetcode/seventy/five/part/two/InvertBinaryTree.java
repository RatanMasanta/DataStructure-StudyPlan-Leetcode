package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public static TreeNode invertTree(TreeNode root)
	    {//we are doing the postorder traversal because we are first knowing about the child and then about the parent //Bottom Up Approach
	       
	        if(root == null)//base casewe hit the null node 
	            return null;//we just return null saying that no node is there its empty 
	        
	        TreeNode left= invertTree(root.left);//Recursing down the left subtree//knowing about the left child //LEFT
	        TreeNode right= invertTree(root.right);//Recursing down the right subtree//knowing about the right child //RIGHT
	        
	        //ROOT
	        //just swapping the pointers, to just alternate the node 
	        root.left= right;//root left is pointing to right child
	        root.right= left;//root right is pointing to left child
	        
	        return root;//returning the root to maintain the backward link//And to tell the parent that I am present
	    }
	 
	 private  class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
}
