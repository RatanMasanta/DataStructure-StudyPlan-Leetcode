package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		// TO write later

	}
	
	public static List<Integer> list = new ArrayList<>();
    public static List<Integer> preorder(Node root) {
        if (root == null)
            return list;
        
        list.add(root.val);
        for(Node node: root.children)
            preorder(node);
                
        return list;
    }

}
