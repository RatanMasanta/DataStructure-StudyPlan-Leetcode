package com.masanta.ratan.leetcode.study.plan.data.structure.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		List<List<Integer>> pascalsTriangle = generate(5);
		for(List<Integer> row: pascalsTriangle) {
			for(int i=0; i<row.size();i++) {
				System.out.print(i +  " ");
			}
			System.out.println("\n");
		}

	}
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
       for (int i = 0; i<numRows; i++) {
           List<Integer> inner = new ArrayList<>(Collections.nCopies(i+1, 1));
           for(int j=1; j<i; j++) {
               inner.set(j, result.get(i-1).get(j-1) + result.get(i-1).get(j));
           }
           result.add(inner);
       }
       return result;
   }

}
