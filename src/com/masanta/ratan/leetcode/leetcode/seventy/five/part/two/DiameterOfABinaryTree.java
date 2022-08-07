package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

public class DiameterOfABinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static int diameterOfBinaryTree(TreeNode root) {
	        if(root == null) return 0;
	        int[] ans = dfs(root);
	        return ans[0];
	    }
	    
	 private static int[] dfs(TreeNode root){
	        int[] ans = new int[2];
	        if(root == null ) return ans;
	        
	        int[] left = dfs(root.left);
	        int[] right = dfs(root. right);
	        
	        ans[1] = 1 + Math.max(left[1], right[1]);
	        ans[0] = Math.max(left[0],Math.max(right[0],left[1]+ right[1]));
	        
	        return ans;
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
