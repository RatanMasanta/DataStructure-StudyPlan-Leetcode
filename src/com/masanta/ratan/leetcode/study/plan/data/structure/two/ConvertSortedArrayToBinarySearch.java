package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class ConvertSortedArrayToBinarySearch {
	
	/*
	 * Given an integer array nums where the elements are sorted in ascending order,
	 * convert it to a height-balanced binary search tree.
	 * 
	 * A height-balanced binary tree is a binary tree in which the depth of the two
	 * subtrees of every node never differs by more than one.
	 */

	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4,5,6,7,8,9};
		TreeNode resultantTree = sortedArrayToBST(nums);
		System.out.println("Done");
	}
	
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        return helper(nums,0,nums.length-1);
    }
    
    public static TreeNode helper(int[] nums, int start, int end) {
        // base case
        if(start > end)
            return null;
        if(start == end)
            return new TreeNode(nums[start]);
        
        
        // Recursive case
        int mid = start + (end-start)/2;
        TreeNode rootNode = new TreeNode(nums[mid]);
        rootNode.left = helper(nums,start,mid-1);
        rootNode.right = helper(nums,mid+1,end);
        
        return rootNode;
        
    }
	

}
