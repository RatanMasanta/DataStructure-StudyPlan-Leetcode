package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class PascalsTriangleTwo {

	public static void main(String[] args) {
		List<Integer> intListForpascalsTriangle = getRow(6);
		System.out.println(Arrays.toString(intListForpascalsTriangle.stream().toArray()));
	}

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> al = new ArrayList<>();
        al.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            ArrayList<Integer> al2 = new ArrayList<>();
            al2.add(1);
            for (int j = 0; j < al.size() - 1; j++)
                al2.add(al.get(j) + al.get(j + 1));
            al2.add(1);
            al = al2;
        }
        return al;
    }
	
}
