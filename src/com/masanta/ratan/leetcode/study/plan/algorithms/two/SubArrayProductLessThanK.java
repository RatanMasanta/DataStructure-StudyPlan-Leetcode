package com.masanta.ratan.leetcode.study.plan.algorithms.two;

public class SubArrayProductLessThanK {

	public static void main(String[] args) {
		System.out.println(numSubarrayProductLessThanKOne(new int[] {10,5,6,2}, 100));
		System.out.println(numSubarrayProductLessThanKTwo(new int[] {10,5,6,2,4}, 100));

	}
	
	/*
	 * The idea is always keep an max-product-window less than K; 
	 * Every time shift window by adding a new number on the right(j), if the product is greater than
	 * k, then try to reduce numbers on the left(i), until the subarray product fit
	 * less than k again, (subarray could be empty); 
	 * Each step introduces x new subarrays, where x is the size of the current window (j + 1 - i); 
	 * example:
	 * for window (5, 2), when 6 is introduced, it add 3 new subarray: (5, (2, (6)))
	 *       (6) 
	 *    (2, 6) 
	 * (5, 2, 6)
	 */
	
	public static int numSubarrayProductLessThanKOne(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;        
    }
	
	/*
	Idea is to make a window with product less than k .
	left : Starting point of window
	Right: Pointer that is going to traverse the array (or end of window)

	After including A[right] there are 2 Cases Possible:

	CASE 1: product is less than k
	It means that I can be part of previous Subarrays (right-left) and also can start a subarray from me(+1).
	So in total Subarrays increase count by (right-left+1)

	CASE 2:Product will became greater than k
	Start relasing element from left till product will become less than k.
	Now same logic as of Case 1.

	So you think you are ready to move into coding part now?
	Well I dont think So because you haven't think about edge cases now.

	As per given constrant : k>=0 and values in array can be in b/w 0 to 1000.
	As we want subarrays whose product are strictly less than k.
	so if(k<=1) return 0.
	and luckily here you dont have the problem that product of number is exceeding the Integer.Max Range.
	*/

	 public static int numSubarrayProductLessThanKTwo(int[] nums, int k) {
	        if(k<=1) return 0;
	        
	        int ans=0;
	        int prod=nums[0];
	        if(prod<k)  ans++;
	        int left=0;
	        int right=1;
	        while(right!=nums.length){
	            int val=nums[right];
	            prod=prod*val;
	            
	            if(prod<k){
	                ans+=right-left+1;
	            }else{
	                while(prod>=k){
	                    prod=prod/nums[left];
	                    left++;
	                }
	                ans+=right-left+1;
	            }
	            right++;
	        }
	        return ans;
	    }
	
	/* Time:O(N) and Space:O(1) */
	

}
