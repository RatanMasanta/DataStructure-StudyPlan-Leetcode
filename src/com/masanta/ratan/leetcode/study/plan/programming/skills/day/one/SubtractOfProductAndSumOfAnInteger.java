package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class SubtractOfProductAndSumOfAnInteger {

	public static void main(String[] args) {
		System.out.println(subtractProductAndSum(1045));
	}

	
	public static int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while(n > 0){
            sum += n%10;
            product *= n%10;
            n /= 10;
        }
        return product - sum;
    }
}
