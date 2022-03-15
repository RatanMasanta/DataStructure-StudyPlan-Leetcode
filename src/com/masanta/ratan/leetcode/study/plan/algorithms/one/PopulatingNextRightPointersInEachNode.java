package com.masanta.ratan.leetcode.study.plan.algorithms.one;

public class PopulatingNextRightPointersInEachNode {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		Node connectedNode = connect(root);
		System.out.println("Node is connected");

	}

	public static Node connect(Node root) {
		if (root==null||root.left==null||root.right==null)return root;
		root.left.next=root.right;
		if (root.next!=null)
			root.right.next=root.next.left;
		connect(root.left);
		connect(root.right);
		return root;
	}

}
