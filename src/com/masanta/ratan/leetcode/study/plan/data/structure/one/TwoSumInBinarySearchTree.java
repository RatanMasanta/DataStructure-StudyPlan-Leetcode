package com.masanta.ratan.leetcode.study.plan.data.structure.one;

import java.util.ArrayList;
import java.util.List;

public class TwoSumInBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.right.left = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		
		System.out.println(findTarget(root,10));

	}

	static List<Integer> intArray = new ArrayList<Integer>();

	public static boolean findTarget(TreeNode root, int k) {
		inOrder(root);
		return twoSumInArray(intArray, k);
	}

	public static boolean twoSumInArray(List<Integer> array, int target){
		int right = array.size() - 1;
		int left = 0;
		int sum;
		boolean isTrue=false;
		while(left<right){
			sum=array.get(left)+array.get(right);
			if(sum>target){
				right--;
			}
			else if(sum<target){
				left++;
			}
			else{
				isTrue=true;
				break;
			}
		}
		return isTrue;
	}

	public static void inOrder(TreeNode root){
		if(root==null)
			return;
		inOrder(root.left);
		intArray.add(root.val);
		inOrder(root.right);
	}

}
