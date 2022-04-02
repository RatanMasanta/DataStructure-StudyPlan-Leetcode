package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class DeleteNodeInBST {
	
	/*
	 * Given a root node reference of a BST and a key, delete the node with the
	 * given key in the BST. Return the root node reference (possibly updated) of
	 * the BST.
	 * 
	 * Basically, the deletion can be divided into two stages:
	 * 
	 * Search for a node to remove. If the node is found, delete the node.
	 */
	 

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(3);
		tree.left.left = new TreeNode(2);
		tree.left.right = new TreeNode(4);
		tree.right = new TreeNode(6);
		tree.right.right = new TreeNode(7);
		
		TreeNode result = deleteNode(tree,4);
		
		System.out.println("Done");
		

	}
	
	
	/*
	 * Recursively find the node that has the same value as the key, while setting
	 * the left/right nodes equal to the returned subtree Once the node is found,
	 * have to handle the below 4 cases 
	 * node doesn't have left or right - return
	 * null node only has left subtree- return the left subtree
	 * node only has right subtree- return the right subtree 
	 * node has both left and right - find the minimum value in the right subtree, 
	 * set that value to the currently found
	 * node, then recursively delete the minimum value in the right subtree
	 */
	
	public static TreeNode deleteNode(TreeNode root, int key) {
	    if(root == null){
	        return null;
	    }
	    if(key < root.val){
	        root.left = deleteNode(root.left, key);
	    }else if(key > root.val){
	        root.right = deleteNode(root.right, key);
	    }else{
	        if(root.left == null){
	            return root.right;
	        }else if(root.right == null){
	            return root.left;
	        }
	        
	        TreeNode minNode = findMin(root.right);
	        root.val = minNode.val;
	        root.right = deleteNode(root.right, root.val);
	    }
	    return root;
	}

	private static TreeNode findMin(TreeNode node){
	    while(node.left != null){
	        node = node.left;
	    }
	    return node;
	}
}
