package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

public class AddTwoNumbersUsingLinkedList {

	public static void main(String[] args) {
		ListNode one = new ListNode(2);
		one.next = new ListNode(4);
		one.next.next = new ListNode(3);
		ListNode two = new ListNode(5);
		two.next = new ListNode(6);
		two.next.next = new ListNode(4);
		ListNode result = addTwoNumbers(one, two);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	/*
    How's going, Ladies n Gentlemen, today we are going to solve one of the coolest problem Add Two Numbers

	So, what the problem statement is saying we have given 2 linkedlist we have to add them and get the sum in another linkedlist.
	
	What, am saying let's understand with an example:-
	Input: l1 = [1,2,4,3], l2 = [5,4,6]
	Output: [6,6,0,4]
	
	image
	
	Now let's create another list in which we will get our sum. So, that list intially we will called as dummy list with any value of your choice present in that. I'll put 0 as we indian has invented that. <^^>
	
	And one more last thing, we'll gonna create one pointer and let's say i'll call it curr which is pointing on dummy node and traverse along with it
	
	image
	
	Alright so, here we go ladies n gentlemen, It's time to sum up these node value, for that we will create one another variable let's called it sum and put the sum of l1 & l2 them into our dummy list. So, we start it from all the way left go to all the way right. Now you will ask, dude what about the carry values we get after sum up.
	Well, hold on i'm coming on that point don't worry.
	
	So, for that what you have to do is, we will intialize one more variable name carry if we found carry of let's say 10. First we will modulo it like carry = sum % 10 i.e. carry = 10 % 10 i.e. 0 we will add 0 into our node and after that what we will do is get the carry as carry = sum / 10 i.e. carry = 10 / 10 i.e. 1. Now we are having carry as 1. So, in the next node sum of l1 & l2 we will add carry as well.
	
	For sum we will use this formula :- sum = l1 + l2 + carry
	
	We did a lot of talk, let's understand it visually:-
	
	1st step->
	image
	
	2nd Step->
	image
	
	3rd Step->
	image
	
	Now I hope Ladies n Gentlemen, you got the crystal clear idea, what we are doing. So, without any further due let's code up

	 */

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0); // creating an dummy list
		ListNode curr = dummy; // intialising an pointer
		int carry = 0; // intialising our carry with 0 intiall
		// while loop will run, until l1 OR l2 not reaches null OR if they both reaches null. But our carry has some value in it. 
		// We will add that as well into our list
		while(l1 != null || l2 != null || carry == 1){
			int sum = 0; // intialising our sum
			if(l1 != null){ // adding l1 to our sum & moving l1
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){ // adding l2 to our sum & moving l2
				sum += l2.val;
				l2 = l2.next;
			}
			sum += carry; // if we have carry then add it into our sum
			carry = sum/10; // if we get carry, then divide it by 10 to get the carry
			ListNode node = new ListNode(sum % 10); // the value we'll get by moduloing it, will become as new node so. add it to our list
			curr.next = node; // curr will point to that new node if we get
			curr = curr.next; // update the current every time
		}
		return dummy.next; // return dummy.next bcz, we don't want the value we have consider in it intially!!
	}


}
