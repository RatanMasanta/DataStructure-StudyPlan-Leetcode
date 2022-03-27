package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class LinkedListCycleTwo {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = head.next;
		
		System.out.println("Index where cycle starts = " + detectCycle(head).val);
		

	}
	
	/*
	 * 
	 *  What question is saying we have Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
		Inorder to solve this question we will gonna use Floyd Cycle Algorithm which states that :
		
		Traverse linked list using two pointers.
		Move one pointer(slow_p) by one and another pointer(fast_p) by two.
		If these pointers meet at the same node then there is a loop. If pointers do not meet then linked list doesn’t have a loop.
		Now, let's understand how we will solve this problem using above algorithm:
		First take one example : head = [3,2,0,-4], pos = 1 and look at this visually,
		
		image
		
		We will use two pointers fast & slow. The fast one move at the speed of 2X & the slow one move at the speed of 1X intially.
		So, we will start traversing both the pointers one by one, hence there is a cycle so fast & slow pointer will gauranteed meet at a point.
		image
		
		As we see in the diagram they have meet at -4 node. Which shows that there is a cycle. But, if there is no loop then, fast will move to null OR fast.next will move to null early before slow on the middle node.
		
		But our focus is on where the cycle has started. So, for that once they meet [slow == fast] then, we will reset the slow back to head & start moving slow with 1X speed and fast will carry on from where it was previously but with 1X speed
		image
		
		Once slow & fast collab we will return either slow OR fast is same thing. As, they will return tail connects to node index 1
		
		
		Let's Do some math work. To understand this solution, you just need to ask yourself this question.
		
		Assume the distance from head to the start of the loop is x1
		the distance from the start of the loop to the point fast and slow meet is x2
		the distance from the point fast and slow meet to the start of the loop is x3
		
		What is the distance fast moved? What is the distance slow moved? And their relationship?
		
		x1 + x2 + x3 + x2
		x1 + x2
		x1 + x2 + x3 + x2 = 2 (x1 + x2)
		Q: Now your question Why x1 + x2 + x3 + x2 = 2 (x1 + x2)?
		
		Ans: Its just the relationship between the distance travelled by fast pointer and the distance travelled by the slow pointer.
		As fast pointer, runs twice the speed of slow pointer. Therefore, when they meet, distance travelled by fast pointer will be 2*(distance travelled by slow pointer).
		
		Therefore, x1 = x3.
		
		
		I hope you get the point. "Maa Kasam khayo, samaj aagya na"
		
		Let's Code it up :
		
	 * 
	 */

	public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
	
}
