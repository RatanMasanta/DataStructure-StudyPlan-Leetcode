package com.masanta.ratan.leetcode.leetcode.seventy.five.part.one;

import java.util.Arrays;

public class FloodFill {

	public static void main(String[] args) {
		int[][] imageMatrix = new int[][] {{1,1,1},{1,0,1},{1,1,0}};
		int[][] imageMatrix2 = new int[][] {{1,1,1},{1,1,0},{1,0,1}};
		int[][] result = floodFill(imageMatrix, 1, 1, 2);
		for(int[] arrayItem: result) {
			System.out.println(Arrays.toString(arrayItem));
		}
	}
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color != newColor)
            dfschange(image, sr, sc, newColor, color);
        return image;
    }
	
    public static void dfschange(int[][] image, int sr, int sc, int newColor, int orignal){
        if(sr < 0 || sr >= image.length || 
           sc < 0 || sc >= image[sr].length || 
           image[sr][sc] != orignal)
            return;
        image[sr][sc] = newColor;
        dfschange(image, sr + 1, sc, newColor, orignal);
        dfschange(image, sr - 1, sc, newColor, orignal);
        dfschange(image, sr, sc + 1, newColor, orignal);
        dfschange(image, sr, sc - 1, newColor, orignal);
    }

}
