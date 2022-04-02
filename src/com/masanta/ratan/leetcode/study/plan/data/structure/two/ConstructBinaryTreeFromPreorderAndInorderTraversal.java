package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	
	/*
	 * Given two integer arrays preorder and inorder where preorder is the preorder
	 * traversal of a binary tree and inorder is the inorder traversal of the same
	 * tree, construct and return the binary tree.
	 */

	public static void main(String[] args) {
		int[] preorder = new int[] {3,9,20,15,7};
		int[] inorder = new int[] {9,3,15,20,7};
		
		TreeNode resultantTree1 = buildTree(preorder, inorder);
		TreeNode resultantTree2 = buildTree2(preorder, inorder);
		
		System.out.println("Done");
	}
	
	/*
	 * The basic idea is here: Say we have 2 arrays, PRE and IN. Preorder traversing
	 * implies that PRE[0] is the root node. Then we can find this PRE[0] in IN, say
	 * it's IN[5]. Now we know that IN[5] is root, so we know that IN[0] - IN[4] is
	 * on the left side, IN[6] to the end is on the right side. Recursively doing
	 * this on subarrays, we can build a tree out of it :)
	 * 
	 * Hope this helps.
	 */
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
	    return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
	    if (preStart > preorder.length - 1 || inStart > inEnd) {
	        return null;
	    }
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inIndex = 0; // Index of current root in inorder
	    for (int i = inStart; i <= inEnd; i++) {
	        if (inorder[i] == root.val) {
	            inIndex = i;
	        }
	    }
	    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
	    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
	    return root;
	}
	
	/*
	 * Fastest solution:
	 * 
	 */
	
	static int preIdx = 0;
    static int inIdx = 0;
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        return helper2(Integer.MAX_VALUE, preorder, inorder);
    }
    
    public static TreeNode helper2(int rightBound, int[] preorder, int[] inorder){
        if (preIdx == preorder.length || rightBound == inorder[inIdx]) return null;
        
        int val = preorder[preIdx++];
        TreeNode root = new TreeNode(val);
        root.left = helper2(val, preorder, inorder);
        inIdx++;
        root.right = helper2(rightBound, preorder, inorder);
        return root;
    }

}
