package com.masanta.ratan.leetcode.study.plan.data.structure.one;

import java.util.Arrays;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersect(new int[] {5,3,9,4,7,2,6,1,1,1,5,4,5,9},
				new int[] {5,5,1,1,1,85,4,6,9,7,5})));

	}

	 public static int[] intersect(int[] nums1, int[] nums2) {
	        int len1 = nums1.length;
	        int len2 = nums2.length;
	        return len1>=len2?sect(nums1,nums2):sect(nums2,nums1);
	    }
	    public static int[] sect(int[] nums1, int[] nums2){
	        int len1 = nums1.length;
	        int len2 = nums2.length;
	        int[] hashtable1 = new int[1010];//for count how many number is same.
	        int[] hashtable2 = new int[1010];//just temp
	        int len = 0;
	        for (int i = 0; i < len1; i++) {
	            hashtable1[nums1[i]]++;
	            hashtable2[nums1[i]]++;
	        }
	        for (int i = 0; i < len2; i++) {
	            if (hashtable1[nums2[i]]>0){
	                len++;
	                hashtable1[nums2[i]]--;
	            }
	        }
	        int[] res = new int[len];
	        int index = 0;
	        for (int i = 0; i < len2; i++) {
	            if (hashtable2[nums2[i]]>0){
	                res[index++] = nums2[i];
	                hashtable2[nums2[i]]--;
	            }
	        }
	        return res;
	    }
	
}
