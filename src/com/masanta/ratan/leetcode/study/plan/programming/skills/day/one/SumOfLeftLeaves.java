package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(9);
		tree.right = new TreeNode(20);
		tree.right.left = new TreeNode(15);
		tree.right.right = new TreeNode(7);
		
		System.out.println(sumOfLeftLeaves(tree));

	}

	public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return 0;
        
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if(curr.left != null && curr.left.left == null && curr.left.right == null) res += curr.left.val;
            if(curr.left != null) queue.offer(curr.left);
            if(curr.right != null) queue.offer(curr.right);
        }
        return res;
    
    }
	
}
