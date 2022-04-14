package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class RichestCustomerWealth {
	
	/*
	 * Problem Statement:
	 * 
	 * You are given an m x n integer grid accounts where accounts[i][j] is the
	 * amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​
	 * bank. Return the wealth that the richest customer has.
	 * 
	 * A customer's wealth is the amount of money they have in all their bank
	 * accounts. The richest customer is the customer that has the maximum wealth.
	 */
	
	public static void main(String[] args) {
		System.out.println(maximumWealth(new int[][] {{1,2,3},{3,2,1}}));
	}
	
	public static int maximumWealth(int[][] accounts) {
        int total = 0, maxwealth = 0;
       
       for(int i=0; i<accounts.length; i++){
           total = 0;
           for(int j=0; j < accounts[i].length; j++){
               total += accounts[i][j];
           }
           if(total > maxwealth)
               maxwealth = total;
       }
       
       return maxwealth;
   
   }

}
