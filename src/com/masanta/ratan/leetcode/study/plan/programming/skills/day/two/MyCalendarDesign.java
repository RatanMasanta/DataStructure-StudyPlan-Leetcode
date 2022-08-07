package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.TreeMap;

/*
  You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.

A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Implement the MyCalendar class:

MyCalendar() Initializes the calendar object.
boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 

Example 1:

Input
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]

Explanation
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
 
 */

public class MyCalendarDesign {

	TreeMap<Integer,Integer> meetings;

	public MyCalendarDesign() {
		meetings  = new TreeMap<>();
	}

	public boolean book(int start, int end) {

		//check for nearest end time (smaller than current start) and currrent start time 
		Integer floorKey = meetings.floorKey(start);
		if(floorKey != null && start < meetings.get(floorKey))
			return false;

		//check for nearest start time (greater than current start) with current end time
		Integer ceilKey = meetings.ceilingKey(start);
		if(ceilKey != null && end > ceilKey)
			return false;

		meetings.put(start,end);
		return true;
	}


}
