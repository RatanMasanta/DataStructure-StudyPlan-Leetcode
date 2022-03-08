package com.masanta.ratan.leetcode.study.plan.algorithms.one;

import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {
		char[] charArray = new char[] {'b','a','l','l','o','o','n'};
//		reverseString(charArray);
		reverseStringFasterApproach(charArray);
		System.out.println(Arrays.toString(charArray));
	}
	
	/*
	 * this is a slow method and is only 5% faster than most submissions
	 * */
	public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        for(int i = 0; i< s.length/2; i++){
            swap(s,left+i,right-i);
           
        }
    }
    
    public static void swap(char[] s, int leftIndex, int rightIndex){
        System.out.println(s[leftIndex] + " " + s[rightIndex]);
        char temp = s[leftIndex];
        s[leftIndex] = s[rightIndex];
        s[rightIndex] = temp;
        System.out.println("After switch: " + s[leftIndex] + " " + s[rightIndex]);
    }

    public static void reverseStringFasterApproach(char[] s) {
    	 int l = 0, h = s.length - 1;
         char temp;
         while (l < h) {
             temp = s[l];
             s[l] = s[h];
             s[h] = temp;
             l++;
             h--;
         }
    }
    
}
