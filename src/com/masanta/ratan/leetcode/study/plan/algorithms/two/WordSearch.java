package com.masanta.ratan.leetcode.study.plan.algorithms.two;

public class WordSearch {
	
	/*
	 * Given an m x n grid of characters board and a string word, return true if
	 * word exists in the grid.
	 * 
	 * The word can be constructed from letters of sequentially adjacent cells,
	 * where adjacent cells are horizontally or vertically neighboring. The same
	 * letter cell may not be used more than once.
	 */

	public static void main(String[] args) {
		String word = "ABCCED";
		char[][] charArrray = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(exist(charArrray, word));
	}
	
	public static boolean exist(char[][] b, String word) {
        /*Find word's first letter.  Then call method to check it's surroundings */
        for(int r=0; r<b.length; r++)
            for(int c=0; c<b[0].length; c++)
                if(b[r][c]==word.charAt(0) && help(b,word,0,r,c))
                    return true;
        
        return false;
    }
    
    public static boolean help(char[][] b, String word, int start, int r, int c){
        /* once we get past word.length, we are done. */
        if(word.length() <= start)
            return true;
        
        /* if off bounds, letter is seen, letter is unequal to word.charAt(start) return false */
        if(r<0 ||c<0 || r>=b.length || c>=b[0].length || b[r][c]=='0' || b[r][c]!=word.charAt(start))
            return false;
        
        /* set this board position to seen. (Because we can use this postion) */
        char tmp = b[r][c];
        b[r][c] = '0';
        
        /* recursion on all 4 sides for next letter, if works: return true */
        if(help(b,word,start+1,r+1,c) ||
          help(b,word,start+1,r-1,c) ||
          help(b,word,start+1,r,c+1) ||
          help(b,word,start+1,r,c-1))
            return true;
        
        //Set back to unseen
        b[r][c] = tmp;
        
        return false;
    }


}
