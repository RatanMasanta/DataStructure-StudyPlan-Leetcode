package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeIterator {
	/*
	 Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
		
		BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
		boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
		int next() Moves the pointer to the right, then returns the number at the pointer.
		Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
		
		You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
		
		 
		
		Example 1:
		
		
		Input
		["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
		[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
		Output
		[null, 3, 7, true, 9, true, 15, true, 20, false]
		
		Explanation
		BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
		bSTIterator.next();    // return 3
		bSTIterator.next();    // return 7
		bSTIterator.hasNext(); // return True
		bSTIterator.next();    // return 9
		bSTIterator.hasNext(); // return True
		bSTIterator.next();    // return 15
		bSTIterator.hasNext(); // return True
		bSTIterator.next();    // return 20
		bSTIterator.hasNext(); // return False
	 */

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
		
		inorder(root, queue);

	}
	
	static Queue<Integer> queue = new LinkedList<Integer>();;
    public BinarySearchTreeIterator(TreeNode root) {
        
        inorder(root,queue);
    }
    
    public static void inorder(TreeNode root,Queue<Integer> queue) {
        if(root==null) {
            return;
        }
        inorder(root.left, queue);
        queue.add(root.val);
        inorder(root.right,queue);
    }
    
    public static int next() {
        return queue.poll();
    }
    public static boolean hasNext() {
        if(queue.isEmpty()) {
            return false;
        }
        return true;
    }

}
