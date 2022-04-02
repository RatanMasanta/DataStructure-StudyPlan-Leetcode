package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PathSumTwo {
	/*
	 * Given the root of a binary tree and an integer targetSum, return all
	 * root-to-leaf paths where the sum of the node values in the path equals
	 * targetSum. Each path should be returned as a list of the node values, not
	 * node references.
	 * 
	 * A root-to-leaf path is a path starting from the root and ending at any leaf
	 * node. A leaf is a node with no children.
	 */

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(5);
		
		tree.left = new TreeNode(4);
		tree.left.left = new TreeNode(11);
		tree.left.left.left = new TreeNode(7);
		tree.left.left.right = new TreeNode(2);
		
		tree.right = new TreeNode(8);
		tree.right.left = new TreeNode(13);
		tree.right.right = new TreeNode(4);
		tree.right.right.left = new TreeNode(5);
		tree.right.right.right = new TreeNode(1);
		
		List<List<Integer>> result = pathSum(tree,22);
		List<List<Integer>> result2 = pathSumRecursive(tree, 18);
		System.out.println(Arrays.toString(result.toArray()));
		System.out.println(Arrays.toString(result2.toArray()));

	}

	//1. iterative: Using a stack to implement DFS
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int SUM = 0;
		TreeNode cur = root;
		TreeNode pre = null;
		while(cur!=null || !stack.isEmpty()){
			while(cur!=null){
				stack.push(cur);
				path.add(cur.val);
				SUM+=cur.val;
				cur=cur.left;
			}
			cur = stack.peek();
			if(cur.right!=null && cur.right!=pre){
				cur = cur.right;
				continue;
			} 
			if(cur.left==null && cur.right==null && SUM==sum) 
				res.add(new ArrayList<Integer>(path));

			pre = cur;
			stack.pop();
			path.remove(path.size()-1);
			SUM-=cur.val;
			cur = null;

		}
		return res;
	}


	//2. Recursive: 
	public static  List<List<Integer>> pathSumRecursive(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		dfs(root, sum, res, path);
		return res;
	}

	public static void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
		if(root==null) return;
		path.add(root.val);

		if(root.left==null && root.right==null ){
			if(root.val==sum)
				res.add(new ArrayList<Integer>(path));
			return;
		}
		if(root.left!=null) {
			dfs(root.left,sum-root.val,res,path);
			path.remove(path.size()-1);
		}
		if(root.right!=null) {
			dfs(root.right,sum-root.val,res,path);
			path.remove(path.size()-1);
		}

	}
}
