package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.Arrays;

public class ReshapeTheMatrix {

	public static void main(String[] args) {
		int[][] matrix= new int[][] {{1,2},{3,4}};
		int[][] reshapedmatrix = matrixReshape(matrix,2,4);
		for(int[] i : reshapedmatrix) {
			System.out.println(Arrays.toString(i));
		}

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
