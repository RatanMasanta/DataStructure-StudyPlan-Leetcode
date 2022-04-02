package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeRightSideView {
	
	/*
	 * Given the root of a binary tree, imagine yourself standing on the right side
	 * of it, return the values of the nodes you can see ordered from top to bottom.
	 */
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left =  new TreeNode(2);
		tree.left.right =  new TreeNode(5);
		tree.right =  new TreeNode(3);
		tree.right.right = new TreeNode(4);
		
		List<Integer> rightView = rightSideView(tree);
		
		System.out.println(Arrays.toString(rightView.toArray()));
		

	}
	
	
	/*
	 * The core idea of this algorithm:
	 * 
	 * 1.Each depth of the tree only select one node. 
	 * 2. View depth is current size
	 * of result list.
	 * 
	 * Here is the code:
	 */
	
	public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public static void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }

}
