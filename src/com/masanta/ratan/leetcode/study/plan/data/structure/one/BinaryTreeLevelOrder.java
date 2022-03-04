package com.masanta.ratan.leetcode.study.plan.data.structure.one;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrder {

	public static void main(String[] args) {


		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(10);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		
		List<List<Integer>> result  = levelOrder(root);
		System.out.println("Done");
		
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        List<List<Integer>> l = new ArrayList<>();
        if(root == null)
            return l;
        q.offer(root);
        while(!q.isEmpty()){
            int levelNo = q.size();
            ArrayList<Integer> sub = new ArrayList<>();
            for(int i = 0; i < levelNo; i++){
                if(q.peek().left != null)
                    q.offer(q.peek().left);
                if(q.peek().right != null)
                    q.offer(q.peek().right);
                sub.add(q.poll().val);
            }
            l.add(sub);
        }
        return l;
    }

}
