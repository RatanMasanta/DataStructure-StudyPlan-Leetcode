package com.masanta.ratan.leetcode.study.plan.algorithms.two;

public class PopulatingNextRightPointersInEachNode {
	
	/*
	Problem Statement
	
	Given a binary tree

	struct Node {
	  int val;
	  Node *left;
	  Node *right;
	  Node *next;
	}
	Populate each next pointer to point to its next right node. If there is no next right node, the
	next pointer should be set to NULL.

	Initially, all next pointers are set to NULL.
	*/

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(5);
		root.left.left = new Node(4);
		root.right.right = new Node(7);

		Node result = connect(root);

		System.out.println("Done.");

	}

	public static Node connect(Node root) {
		Node dummyHead  = new Node(0); // this head will always point to the first element in the current layer we are searching
		Node pre = dummyHead; // this 'pre' will be the "current node" that builds every single layer   
		Node real_root = root; // just for return statement

		while(root != null){
			if(root.left != null){
				pre.next = root.left;
				pre = pre.next;
			}
			if(root.right != null){
				pre.next = root.right; 
				pre = pre.next;
			}
			root = root.next; 
			if(root == null){ // reach the end of current layer
				pre = dummyHead; // shift pre back to the beginning, get ready to point to the first element in next layer  
				root = dummyHead.next; ;//root comes down one level below to the first available non null node
				dummyHead.next = null;//reset dummyhead back to default null
			}
		}
		return real_root;
	}
}
