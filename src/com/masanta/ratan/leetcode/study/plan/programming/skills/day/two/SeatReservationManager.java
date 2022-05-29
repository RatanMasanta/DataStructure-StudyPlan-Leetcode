package com.masanta.ratan.leetcode.study.plan.programming.skills.day.two;

import java.util.PriorityQueue;

public class SeatReservationManager {

	
	/*
	 Design a system that manages the reservation state of n seats that are numbered from 1 to n.

	Implement the SeatManager class:
	
	SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are initially available.
	int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
	void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.
	 
	
	Example 1:
	
	Input
	["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
	[[5], [], [], [2], [], [], [], [], [5]]
	Output
	[null, 1, 2, null, 2, 3, 4, 5, null]
	
	Explanation
	SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
	seatManager.reserve();    // All seats are available, so return the lowest numbered seat, which is 1.
	seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
	seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
	seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
	seatManager.reserve();    // The available seats are [3,4,5], so return the lowest of them, which is 3.
	seatManager.reserve();    // The available seats are [4,5], so return the lowest of them, which is 4.
	seatManager.reserve();    // The only available seat is seat 5, so return 5.
	seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
	 */
	
	public static void main(String[] args) {

		SeatReservationManager seatReservationManager = new SeatReservationManager(10);
		System.out.println(seatReservationManager.reserve());
		System.out.println(seatReservationManager.reserve());
		System.out.println(seatReservationManager.reserve());
		System.out.println(seatReservationManager.reserve());
		System.out.println(seatReservationManager.reserve());
		System.out.println(seatReservationManager.reserve());
		System.out.println(seatReservationManager.reserve());
		seatReservationManager.unreserve(3);
		System.out.println(seatReservationManager.reserve());

	}
	
	/*
	I am trying to explain it..

	In real world or idea world , first you reserve a seat then
	if you want you can unreserve it. right.
	you can't unreserve a seat without reserving it.

	 and the reservation is happening here is sequential .example 1,2,3...n

	 whatever seat you unreserve , it will be smaller value then 
	available seats so you can return it from PriorityQueue or else from current count
	*/

	PriorityQueue<Integer> pq;
	int count;

	public SeatReservationManager(int n) {
	    count = 1;
	    pq = new PriorityQueue();
	}

	public int reserve() {
	    if (pq.size() == 0) {
	        return count++;
	    }

	    return pq.poll();
	}

	public void unreserve(int seatNumber) {
	    pq.add(seatNumber);
	}

}
