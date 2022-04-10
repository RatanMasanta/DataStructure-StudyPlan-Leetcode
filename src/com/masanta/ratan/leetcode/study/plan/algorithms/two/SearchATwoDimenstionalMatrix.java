package com.masanta.ratan.leetcode.study.plan.algorithms.two;

public class SearchATwoDimenstionalMatrix {

	public static void main(String[] args) {
		
		int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		System.out.println(searchMatrix(matrix, 3));
		
	}

	
	public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int r = mid / cols;
            int c = mid % cols;
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
	
}
