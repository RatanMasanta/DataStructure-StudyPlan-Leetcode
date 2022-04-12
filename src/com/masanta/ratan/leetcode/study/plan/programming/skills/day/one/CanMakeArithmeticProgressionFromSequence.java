package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CanMakeArithmeticProgressionFromSequence {

	public static void main(String[] args) {
		int[] array = new int[] {3,5,1};
		System.out.println(canMakeArithmeticProgression(array));
		System.out.println(canMakeArithmeticProgression1(array));
		System.out.println(canMakeArithmeticProgression2(array));

	}
	
	public static boolean canMakeArithmeticProgression(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int n : arr) {
            min = Math.min(n, min);
            max = Math.max(n, max);
        }
        
        if (max == min) {
            return true;
        }
        
        if ((max - min) % (arr.length - 1) != 0) {
            return false;
        }
        
        int step = (max - min) / (arr.length - 1);
        
        for (int i = 0; i < arr.length; ) {
            if ((arr[i] - min) % step != 0) {
                return false;
            }
            
            int j = (arr[i] - min) / step;
            
            if (i == j) {
                ++i;
            }
            else if (arr[j] == arr[i]) {
                return false;
            }
            else {
                arr[i] = arr[j];
                arr[j] = min + j * step;
            }
        }
        
        return true;
    }
    public static boolean canMakeArithmeticProgression2(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        int mi = Integer.MAX_VALUE, mx = Integer.MIN_VALUE, n = arr.length;
        for (int a : arr) {
            mi = Math.min(mi, a);
            mx = Math.max(mx, a);
            seen.add(a);
        }
        int diff = mx - mi;
        if (diff % (n - 1) != 0) {
            return false;
        }
        diff /= n - 1;
        while (--n > 0) {
            if (!seen.contains(mi)) {
                return false;
            }
            mi += diff;
        }
        return true;
    }
    
    public static boolean canMakeArithmeticProgression1(int[] arr) {
        Arrays.sort(arr);
        for (int i = 2; i < arr.length; ++i) {
            if (arr[i - 1] - arr[i] != arr[i - 2] - arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    

}
