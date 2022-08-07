package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

public class MyLinkedList {

	private MyLinkedList head;
	private MyLinkedList next;
	private int val;
	private int size;
	public MyLinkedList() {
		this.head = null;
		this.next = null;
		this.val = 0;
		this.size = 0;
	}

	public int get(int index) {
		if(index<size){
			MyLinkedList temp = head;
			int count = 0;
			while(count<index){
				temp= temp.next;
				count++;
			}
			return temp.val;
		}else{
			System.out.println(size+" requested = "+index);
			return -1;
		}
	}

	public void addAtHead(int val) {
		size +=1;
		if(head==null){
			head = new MyLinkedList();
			head.val = val;
		}else{
			MyLinkedList temp = new MyLinkedList();
			temp.val = val;
			temp.next = head;
			head = temp;
		}
	}

	public void addAtTail(int val) {
		size +=1;
		if(head==null){
			head = new MyLinkedList();
			head.val = val;
			return;
		}
		MyLinkedList temp = new MyLinkedList();
		temp.val = val;
		MyLinkedList thead = head;
		while(thead.next!=null){
			thead= thead.next;
		}
		thead.next = temp;
	}

	public void addAtIndex(int index, int val) {
		if(index==0){
			addAtHead(val);
			return;
		}
		if(index==size){
			addAtTail(val);
			return;
		}
		if(index == size-1){
			MyLinkedList temp = new MyLinkedList();
			temp.val = val;
			MyLinkedList thead = head;
			while(thead.next.next!=null){
				thead = thead.next;
			}
			temp.next = thead.next;
			thead.next = temp;
			size+=1;
			return;
		}
		if(index<size){
			int count = 0;
			MyLinkedList temp = new MyLinkedList();
			MyLinkedList thead = head;
			temp.val = val;
			while(count<index-1 && count<size){
				thead = thead.next;
				count++;
			}
			temp.next = thead.next;
			thead.next = temp;
			size+=1;
		}
		return ;
	}

	public void deleteAtIndex(int index) {
		if(index ==0 ){
			head = head.next;
			size-=1;
			return;
		}
		if(index == size-1){
			MyLinkedList temp = head;
			while(temp.next.next!=null)
				temp = temp.next;
			temp.next = null;
			size-=1;
			return ;
		}
		if(index<size){
			MyLinkedList temp = head;
			int count = 0;
			while(count<index-1){
				temp = temp.next;
				count++;
			}
			temp.next = temp.next.next;
			size-=1;
			return;
		}
	}

}
