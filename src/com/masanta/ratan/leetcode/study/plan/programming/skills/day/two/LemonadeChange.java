package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

public class LemonadeChange {
	/*
	At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you
	 and order one at a time (in the order specified by bills). Each customer will only buy one 
	 lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to
	  each customer so that the net transaction is that the customer pays $5.

	Note that you do not have any change in hand at first.

	Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can
	 provide every customer with the correct change, or false otherwise.
	*/
	public static void main(String[] args) {
		
		System.out.println(lemonadeChange(new int[] {5,5,5,10,20}));
	}
	
	 /*
    Intuition:
	When the customer gives us $20, we have two options:
	
	To give three $5 in return
	To give one $5 and one $10.
	On insight is that the second option (if possible) is always better than the first one.
	Because two $5 in hand is always better than one $10
	
	
	Explanation:
	Count the number of $5 and $10 in hand.
	
	if (customer pays with $5) five++;
	if (customer pays with $10) ten++, five--;
	if (customer pays with $20) ten--, five-- or five -= 3;
	
	Check if five is positive, otherwise return false.
	
	
	Time Complexity
	Time O(N) for one iteration
	Space O(1)

    */
    public static boolean lemonadeChange(int[] bills) {
         int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
        
    }

}
