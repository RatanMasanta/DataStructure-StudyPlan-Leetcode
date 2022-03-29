package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.ArrayList;
import java.util.List;

public class LinkedListDesign {

	private List<Integer> myList;
	public LinkedListDesign() {
		myList=new ArrayList<>();
	}

	public int get(int index) {
		if(index<myList.size()){
			return myList.get(index);
		}else
			return -1;
	}

	public void addAtHead(int val) {
		myList.add(0,val);
	}

	public void addAtTail(int val) {
		myList.add(myList.size(),val);
	}

	public void addAtIndex(int index, int val) {
		if(index<=myList.size())
			myList.add(index,val);
	}

	public void deleteAtIndex(int index) {
		if(index<myList.size()){
			myList.remove(index);
		}
	}

	public static void main(String[] args) {
		int index = 0;
		int val = 5;
		LinkedListDesign obj = new LinkedListDesign();
		int param_1 = obj.get(index);
		obj.addAtHead(val);
		obj.addAtTail(val);
		obj.addAtIndex(index,val);
		obj.deleteAtIndex(index);

	}

}
