package com.masanta.ratan.leetcode.study.plan.algorithms.one;

public class FindFirstBadVersion {
	
	private static String[] versionArray = new String[] {"ok","ok","ok","ok","bad","bad","bad","bad","bad","bad"};

	public static void main(String[] args) {
		System.out.println(firstBadVersion(8));

	}

	 public static int firstBadVersion(int n) {
	        int start = 1;
	    int end = n;
	    while(start<end){
	         int mid = start + (end - start)/2;
	        if(!isBadVersion(mid)){
	            start = mid + 1;
	        }else {
	            end = mid;
	        }
	    }
	       return start;
	    }
	 
	 public static boolean isBadVersion(int version) {
		 return versionArray[version].equalsIgnoreCase("bad");
	 }
	
}
