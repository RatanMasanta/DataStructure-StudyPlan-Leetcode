package com.masanta.ratan.leetcode.study.plan.algorithms.one;

public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	static int m,n;
    public static int[][] floodFill(int[][] images, int sr, int sc, int newColor) {
        m = images.length;
        n = images[0].length;
        
        int prevColor = images[sr][sc];
        if(prevColor != newColor )                  // avoid stackoverflow
            dfs(images, sr, sc, prevColor, newColor);
        
        return images;
    }
    
    private static void dfs(int[][] images, int r, int c, int prevColor, int newColor){
        if(r < 0 || c < 0 || r >= m || c >= n || images[r][c] != prevColor)
            return ;
        
        images[r][c] = newColor;
        
        int[] row = {1,0,-1,0};
        int[] col = {0,1,0,-1};
        for(int i=0; i<4; i++)
            dfs(images, r+row[i], c+col[i], prevColor, newColor);
    }
	
}
