package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class DesignParkingSystem {

	public static void main(String[] args) {
		ParkingSystem parking = new ParkingSystem(100, 10, 5);
		System.out.println(parking.addCar(1));
		

	}
	
	static class ParkingSystem{
		int[] count;
	    public ParkingSystem(int big, int medium, int small) {
	        count = new int[]{big, medium, small};
	    }

	    public boolean addCar(int carType) {
	        return count[carType - 1]-- > 0;
	    }
	}

}
