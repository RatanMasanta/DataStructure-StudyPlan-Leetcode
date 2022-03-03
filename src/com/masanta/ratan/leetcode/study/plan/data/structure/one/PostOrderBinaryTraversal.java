package com.masanta.ratan.leetcode.study.plan.data.structure.one;

import java.util.ArrayList;
import java.util.List;


public class PostOrderBinaryTraversal {
	
	private static class TreeNode {
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

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(10);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		
		List<Integer> postorderTraversalArray = postorderTraversal(root);
		
		for(Integer nodeVal: postorderTraversalArray ) {
			System.out.println(nodeVal);
		}

	}
	
	public static List<Integer> postorderTraversal(TreeNode root) {
	    List<Integer> list = new ArrayList<Integer>();

			recPostOrder(root, list);

			return list;
		}

		private static void recPostOrder(TreeNode node, List<Integer> list){

			if(node == null) return;

			recPostOrder(node.left, list);
			recPostOrder(node.right, list);
	        list.add(node.val);

		}

}
