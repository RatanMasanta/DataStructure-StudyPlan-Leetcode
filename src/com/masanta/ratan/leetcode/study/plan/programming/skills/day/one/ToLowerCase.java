package com.masanta.ratan.leetcode.study.plan.programming.skills.day.one;

public class ToLowerCase {

	public static void main(String[] args) {
		System.out.println(toLowerCase("Hello@#"));

	}
	
	public static String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        return new String(a);
    }

}
