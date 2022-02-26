package com.masanta.ratan.leetcode.study.plan.data.structure.one;

public class ReshapeMatrixInRowsColumns {

	public static void main(String[] args) {
		
	    int[][] scores = new int[2][2];
        // Initializing array element at position[0][0],
        // i.e. 0th row and 0th column
        scores[0][0] = 15;
        // Initializing array element at position[0][1],
        // i.e. 0th row and 1st column
        scores[0][1] = 23;
        // Initializing array element at position[1][0],
        // i.e. 1st row and 0th column
        scores[1][0] = 30;
        // Initializing array element at position[1][1],
        // i.e. 1st row and 1st column
        scores[1][1] = 21;
		
		int [][] results = matrixReshape(scores, 1, 5);
		
		System.out.println("Done");
		

	}
	
	public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r * c) return mat;
        
        int[][] m = new int[r][c];
        
        int t = 0;
        int s = 0;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                m[t][s] = mat[i][j];
                s++;
                if(s == c) {
                   s = 0;
                    t++;
                }
            }
        }
        
        return m;
    }

}
