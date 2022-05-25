package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;


/*
    Given a 2D matrix matrix, handle multiple queries of the following type:
	
	Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
	Implement the NumMatrix class:
	
	NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
	int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
	
	
	Example 1:
	
	
	Input
	["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
	[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
	Output
	[null, 8, 11, 12]
	
	Explanation
	NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
	numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
	numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
	numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
 */

public class RangeSumQuery2D {

	private static int[][] dp;

	public RangeSumQuery2D(int[][] matrix) {
		if(   matrix           == null
				|| matrix.length    == 0
				|| matrix[0].length == 0   ){
			return;   
		}

		int m = matrix.length;
		int n = matrix[0].length;

		dp = new int[m + 1][n + 1];
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] -dp[i - 1][j - 1] + matrix[i - 1][j - 1] ;
			}
		}
	}

	public static int sumRegion(int row1, int col1, int row2, int col2) {
		int iMin = Math.min(row1, row2);
		int iMax = Math.max(row1, row2);

		int jMin = Math.min(col1, col2);
		int jMax = Math.max(col1, col2);

		return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];    
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
		RangeSumQuery2D obj = new RangeSumQuery2D(matrix);
		int param_1 = obj.sumRegion(1,1,2,2);
		int param_2 = obj.sumRegion(2, 1, 4, 3);
		int param_3 = obj.sumRegion(1, 2, 2, 4);
		System.out.println(param_1);
		System.out.println(param_2);
		System.out.println(param_3);

	}

}
