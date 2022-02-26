package com.masanta.ratan.leetcode.study.plan.data.structure.one;

public class Search2DMatrix {
	
	/*
	 * 
	 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
	 * This matrix has the following properties:
	 * Integers in each row are sorted from left to right.
	 * The first integer of each row is greater than the last integer of the previous row.
	 * 
	 * 
	 * author: ratan masanta
	 * 
	 */

	public static void main(String[] args) {
		
	}
	
	
	public static boolean searchMatrixOnComplexity(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int index = 0;
        boolean flag = false;
        
        for(int i=0;i<m;i++){
            if(matrix[i][0]<=target && matrix[i][n-1]>=target){
                index = i;
                break;
            }
        }
        
        for(int j=0;j<n;j++){
            if(matrix[index][j] == target){
                flag = true;
                break;
            }
        }
        
        return flag;
    }
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        for(int i = 0; i<rowLength; i++ ){
            for( int j = 0; j< columnLength; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

}
