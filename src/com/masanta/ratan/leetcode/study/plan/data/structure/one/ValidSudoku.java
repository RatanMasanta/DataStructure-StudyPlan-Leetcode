package com.masanta.ratan.leetcode.study.plan.data.structure.one;

import java.util.HashSet;

public class ValidSudoku {

	public static void main(String[] args) {

		
	}

	public static boolean isValidSudoku(char[][] board) {
		HashSet seenSet = new HashSet();

		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(board[i][j] != '.'){
					if(!seenSet.add("row" + i + board[i][j]) || !seenSet.add("column" + j + board[i][j])){
						return false;
					}
					if(!seenSet.add("box" + ((i/3)*3+j/3) + board[i][j]) ){
						return false;
					}
				}

			}
		}
		return true;
	}

}
