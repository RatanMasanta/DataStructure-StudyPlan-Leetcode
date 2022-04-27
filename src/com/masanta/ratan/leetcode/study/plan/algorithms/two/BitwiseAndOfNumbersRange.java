package com.masanta.ratan.leetcode.study.plan.algorithms.two;

public class BitwiseAndOfNumbersRange {

	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(25, 30));

	}
	
	public static int rangeBitwiseAnd(int m, int n) {
        if(m == 0){
           return 0;
       }
       int moveFactor = 1;
       while(m != n){
           m >>= 1;
           n >>= 1;
           moveFactor <<= 1;
       }
       return m * moveFactor;
   }

}
