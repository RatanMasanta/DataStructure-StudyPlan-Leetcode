package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

public class BinarySearchIterator {


	private TreeNode curr;
	public BinarySearchIterator(TreeNode root) {
		TreeNode prev;
		//Do a morris in-order traversal, to construct a threaded binary tree
		curr = root;
		while(curr != null){
			if(curr.left == null){
				curr = curr.right;
			}
			else{
				prev = curr.left;
				while(prev.right != null && prev.right != curr)
					prev = prev.right;

				if(prev.right == null){
					prev.right = curr;
					curr = curr.left;
				}
				else{
					curr = curr.right;
				}
			}
		}

		//get the left-most child of root, i.e. the smallest TreeNode
		curr = root;
		while(curr != null && curr.left != null)
			curr = curr.left;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return curr != null;
	}

	/** @return the next smallest number */
	public int next() {

		//copy the value we need to return
		int result = curr.val;

		TreeNode next = curr.right;
		if(next == null)
			curr = next;
		//the right child relationship is a normal one, find left-most
		//child of "next"
		else if(next.left == null || next.left.val > curr.val){
			curr = next;
			while(curr.left != null)
				curr = curr.left;
		}
		//the right child relationship is made when we
		//construct the threaded binary tree
		else{
			curr.right = null;//we recover the original tree structure
			curr = next;
		}

		return result;
	}

}
