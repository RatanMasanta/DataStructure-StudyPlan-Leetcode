package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.HashMap;

public class CopyListWithRandomPointer {

	/*
	 	A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.
	 
	 *	Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
		Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
	 *
	 */
	
	
	public static void main(String[] args) {
			
		
	}
	
	public Node copyRandomList(Node head) {
        // HashMap which holds old nodes as keys and new nodes as its values. 
    HashMap<Node, Node> map = new HashMap<Node, Node>();
    
    //copy list nodes into hash table
    Node p = head;
    while(p != null){
        map.put(p, new Node(p.val));
        p = p.next;
    }
    
    //deep copy using hash table
    Node q = head;
    while(q != null){
        map.get(q).next = map.get(q.next);
        map.get(q).random = map.get(q.random);
        q = q.next;
    }
    
    //return new head
    return map.get(head);
    }
	
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}

}
