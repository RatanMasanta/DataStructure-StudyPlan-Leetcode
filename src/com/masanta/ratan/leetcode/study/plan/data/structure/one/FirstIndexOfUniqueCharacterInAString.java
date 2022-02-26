package com.masanta.ratan.leetcode.study.plan.data.structure.one;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstIndexOfUniqueCharacterInAString {

	public static void main(String[] args) {
		System.out.println(firstUniqCharIndex("abcjabcadloje"));

	}

	
	public static int firstUniqCharIndex(String s) {
        char a[] = s.toCharArray();
        int size = a.length;
        Map<Character,Integer> map = new LinkedHashMap<>();
        int i=0;
        while(i!=size){
            if(map.containsKey(a[i])==false){
                map.put(a[i],1);
            }
            else{
                int oldval = map.get(a[i]);
                int newval = oldval+1;
                map.put(a[i],newval);
            }
            ++i;
        
        }
        for(int j=0; j<size; j++){
        if(map.get(a[j]) == 1){
            return j;
        }
    }
    return -1;
    }
	
}
