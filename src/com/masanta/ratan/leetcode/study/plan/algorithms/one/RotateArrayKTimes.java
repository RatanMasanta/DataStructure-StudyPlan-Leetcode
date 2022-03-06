package com.masanta.ratan.leetcode.study.plan.algorithms.one;

import java.util.Arrays;

public class RotateArrayKTimes {

	public static void main(String[] args) {
		
		int[] nums = new int[] {1,3,5,8,-1,0,-4,6,-7};
		rotate(nums, 4);
		System.out.print(Arrays.toString(nums));

	}
	
	public static void rotate(int[] nums, int k) {
        /**
         *
         * For a given array of length N if we will rotate it N times the initial and final array will be same
         * like for arr = [1, 2, 3, 4, 5]
         * Rotate-1 :  [5, 1, 2, 3, 4]  -> Rotate-2 :  [4, 5, 1, 2, 3]   ...   Rotate-5 :  [1, 2, 3, 4, 5]
         *
         * So, If k is greater than length of the array, then we can say (k % nums.length) value time rotation state will
         * be the final state of the array.
         */
        if (k > nums.length) {
            k = k % nums.length;
        }

        /**
         *   As per the problem statement below check is not required as value of k is 0 <= k <= 105
         *
         *   Constraints:
         *      1 <= nums.length <= 105
         *      -231 <= nums[i] <= 231 - 1
         *      0 <= k <= 105
         */


        /***
         * If value of k is negative and for all -ve value it should rotate left wise
         * Like arr = [1, 2, 3, 4, 5]  and k = -1 the final array should be arr : [2, 3, 4, 5, 1]
         *
         * Now to handle this kind of -ve cases, lets analyze the rotation
         *          arr = [1, 2, 3, 4, 5]
         *
         *  Rotation  -2 :  [3, 4, 5, 1, 2]   ###
         *  Rotation  -1 :  [2, 3, 4, 5, 1]      ****
         *  Rotation  0  :  [1, 2, 3, 4, 5]
         *  Rotation  1  :  [5, 1, 2, 3, 4]
         *  Rotation  2  :  [4, 5, 1, 2, 3]
         *  Rotation  3  :  [3, 4, 5, 1, 2]   ###
         *  Rotation  4  :  [2, 3, 4, 5, 1]     ****
         *  Rotation  5  :  [1, 2, 3, 4, 5]
         *
         *  Now if we will see Rotation for -1 and 4 is same or -2 and 3 is also same.
         *  So, we can say -k rotation is equivalent to -k + array length position
         */
//        if (k < 0) {
//            k = k + nums.length;
//        }


        // Step-1 : Divide the Array into two part
        int numsLength = nums.length - 1;
        int dividePosition = numsLength - k;

        //Step-2 : Reverse the above part individually
        reverse(0, dividePosition, nums);
        reverse(dividePosition + 1, numsLength, nums);

        //Step-3 : Now reverse the whole array
        reverse(0, numsLength, nums);
    }

    private static void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
