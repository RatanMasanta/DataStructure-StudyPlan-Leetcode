package com.masanta.ratan.leetcode.study.plan.data.structure.one;

public class SymmetricTreeCheck {
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(10);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		
		System.out.println(isSymmetric(root));
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(2);
//		root1.right.left = new TreeNode(3);
//		root1.right.right = new TreeNode(4);
//		root1.left.left = new TreeNode(3);
//		root1.left.right = new TreeNode(4);
		
		System.out.println(isSymmetric(root1));
	}
	
	public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }
    
    public static boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSymmetric(p.left, q.right)
                && isSymmetric(p.right, q.left);
    }

}
