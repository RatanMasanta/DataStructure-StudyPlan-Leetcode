package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.ArrayList;

public class FindKthSmallestElementInBST {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(1);
		tree.left.right = new TreeNode(2);
		tree.right = new TreeNode(4);
		
		System.out.println(kthSmallest(tree,2));

	}
	
	public static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        return arr.get(k-1);
    }
    public static ArrayList<Integer> inorder(TreeNode root,ArrayList<Integer> arr){
        if(root==null) return arr;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        return arr;
    }

}
