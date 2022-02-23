package com.masanta.ratan.leetcode.study.plan.data.structure.one;

public class BestTimeToBuyAStock {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] {7,6,8,12,5,17,19,6,20}));

	}
	
	public static int maxProfit(int[] prices) {
        int max = Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i = 0; i<prices.length;i++){
            if( prices[i]<max){
                max=prices[i];
            }
            maxProfit = Math.max(maxProfit,prices[i]-max);
        }
        return maxProfit;
    }

}
