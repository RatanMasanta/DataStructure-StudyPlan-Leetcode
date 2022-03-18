package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {
		System.out.println(majorityElement1(new int[] {1,2,5,1,1,1,1,1}));
		System.out.println(majorityElement2(new int[] {1,2,5,1,1,1,1,1}));
		System.out.println(majorityElement3(new int[] {1,2,5,1,1,1,1,1}));
		System.out.println(majorityElement4(new int[] {1,2,5,1,1,1,1,1}));
		System.out.println(majorityElement5(new int[] {1,2,5,1,1,1,1,1}));

	}
	
	// Sorting
	public static int majorityElement1(int[] nums) {
	    Arrays.sort(nums);
	    return nums[nums.length/2];
	}

	// Hashtable 
	public static int majorityElement2(int[] nums) {
	    Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
	    //Hashtable<Integer, Integer> myMap = new Hashtable<Integer, Integer>();
	    int ret=0;
	    for (int num: nums) {
	        if (!myMap.containsKey(num))
	            myMap.put(num, 1);
	        else
	            myMap.put(num, myMap.get(num)+1);
	        if (myMap.get(num)>nums.length/2) {
	            ret = num;
	            break;
	        }
	    }
	    return ret;
	}

	// Moore voting algorithm
	public static int majorityElement3(int[] nums) {
	    int count=0, ret = 0;
	    for (int num: nums) {
	        if (count==0)
	            ret = num;
	        if (num!=ret)
	            count--;
	        else
	            count++;
	    }
	    return ret;
	}

	// Bit manipulation 
	public static int majorityElement4(int[] nums) {
	    int[] bit = new int[32];
	    for (int num: nums)
	        for (int i=0; i<32; i++) 
	            if ((num>>(31-i) & 1) == 1)
	                bit[i]++;
	    int ret=0;
	    for (int i=0; i<32; i++) {
	        bit[i]=bit[i]>nums.length/2?1:0;
	        ret += bit[i]*(1<<(31-i));
	    }
	    return ret;
	}
	
	
	//Fastest solution using recursion:
	public static int majorityElement5(int[] nums) {
        return recurse(nums, 0);
    }
    
    public static int recurse(int[] nums, int start){
        int n = nums.length;
        int tracker= 1;
        for(int i=start+1;i<n;i++){
            if(nums[start]==nums[i]){
                tracker++;
            }else{
                tracker--;
            }
            if(tracker==0){
                return recurse(nums, i+1);
            }
        }
        return nums[start];
    }

}
