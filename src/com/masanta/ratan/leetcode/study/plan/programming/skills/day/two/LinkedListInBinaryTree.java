package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

public class LinkedListInBinaryTree {

	public static void main(String[] args) {
		ListNode list = new ListNode(4);
		list.next = new ListNode(2);
		list.next.next = new ListNode(8);
		
		TreeNode tree = new TreeNode(1);
		tree.right = new TreeNode(4);
		tree.left = new TreeNode(4);
		tree.left.right = new TreeNode(2);
		tree.left.right.left = new TreeNode(1);
		tree.right.left = new TreeNode(2);
		tree.right.left.left = new TreeNode(6);
		tree.right.left.right = new TreeNode(8);
		tree.right.left.right.left = new TreeNode(1);
		tree.right.left.right.right = new TreeNode(3);
		
		System.out.println(isSubPath(list, tree));

	}

	public static boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;
        
        //if head val, found in tree
        //search path
        if(head.val == root.val){
            if(searchPath(head, root)) return true;
        }
        
        //path didn't find
        //now search in left subtree, 
        //if didn't found search in right subtree
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    
    
    private static boolean searchPath(ListNode listNode, TreeNode treeNode){
        //base cases
        //if tree node reached to end,
        //check list node reached to end or node
        if(treeNode == null) return listNode == null;
        
        //list node reached to end, it meand found 
        if(listNode == null) return true;
        
        //if treeNode val is not match with list val,
        //return, no need to search further
        if(treeNode.val != listNode.val) return false;
        
        return searchPath(listNode.next, treeNode.left) 
            || searchPath(listNode.next, treeNode.right);
    }
	
}
