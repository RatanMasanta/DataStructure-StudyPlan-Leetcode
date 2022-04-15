package com.masanta.ratan.leetcode.study.plan.algorithms.two;

public class SubTreeOfAnotherTree {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		TreeNode subTree = new TreeNode(4);
		subTree.left = new TreeNode(1);
		subTree.right = new TreeNode(2);
		tree.left = new TreeNode(4);
		tree.left.left = new TreeNode(1);
		tree.left.right = new TreeNode(2);
		tree.right = new TreeNode(5);
		
		System.out.println(isSubtree(tree, subTree));

	}
	
	public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        if (s.val != t.val) return false;
        
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

}
