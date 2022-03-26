package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequence {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toArray()));

	}
	
	public static List<String> findRepeatedDnaSequences(String s) {
        if(s.length() > 10000){
            return new ArrayList();
        }
        HashSet<String> repeating = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i+9 < s.length() ; i++ ){
            String holder = s.substring(i,i+10);
            if(!repeating.add(holder)){
                set.add(holder);
            }
        }
        return new ArrayList(set);
    }

}
