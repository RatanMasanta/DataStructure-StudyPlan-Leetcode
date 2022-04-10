package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {

	public static void main(String[] args) {
		System.out.println(average(new int[] {4000,3000,1000,2000}));
	}

	public static double average(int[] salary) {
        double sum = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = salary.length;
        for (int num : salary) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (sum - min - max) / (n - 2);        
    }
	
}
