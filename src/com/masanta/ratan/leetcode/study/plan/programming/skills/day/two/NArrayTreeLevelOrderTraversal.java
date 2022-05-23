package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NArrayTreeLevelOrderTraversal {

	public static void main(String[] args) {
		/*
		 * List<Node> node = new ArrayList<Node>(); node.add(new Node(1)); node.add(new
		 * Node()); node.add(new Node(3)); node.add(new Node(2)); node.add(new Node(4));
		 * node.add(new Node()); node.add(new Node(5)); node.add(new Node(6));
		 * 
		 * Node root = new Node (1,node);
		 * 
		 * List<List<Integer>> list = levelOrder(root); for(List<Integer> row: list) {
		 * System.out.println(Arrays.toString(row.toArray())); }
		 */

		// Need to check on the flow
		
	}
	
	public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        
        if (root == null) return ret;
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }
        
        return ret;
    }

}
