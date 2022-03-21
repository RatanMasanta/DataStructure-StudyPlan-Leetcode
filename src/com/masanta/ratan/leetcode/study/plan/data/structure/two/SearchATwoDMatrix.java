package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class SearchATwoDMatrix {
	
	/*
	 * Problem statement
	 * 
	 * Write an efficient algorithm that searches for a value target in an m x n
	 * integer matrix matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted in ascending from left to right. Integers in
	 * each column are sorted in ascending from top to bottom.
	 */

	public static void main(String[] args) {
		int[][] twoDimensionalMatrix= new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		System.out.println(searchMatrix(twoDimensionalMatrix,20));
		System.out.println(searchMatrix(twoDimensionalMatrix,24));
	}
	
	/*
	 * Soution:
	 * 
	 * If we stand on the top-right corner of the matrix and look diagonally, it's
	 * kind of like a BST, we can go through this matrix to find the target like how
	 * we traverse the BST.
	 */	
	public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int r = rows - 1, c = 0;
        while (r >= 0 && c < cols) {
            int val = matrix[r][c];
            if (val == target) return true;
            if (val > target) r--;
            else c++;
        }
        return false;
    }

}
