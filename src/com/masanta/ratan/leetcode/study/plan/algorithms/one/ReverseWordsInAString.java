package com.masanta.ratan.leetcode.study.plan.algorithms.one;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		String result = reverseWords("Let's make breakfast.");
		System.out.println(result);

	}
	
	public static void swap(char[] ch, int i, int j) {
        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
    }
    
    public static void reverse(char[] ch, int i, int j) {
        while (i < j) {
            swap(ch, i, j);
            i++;
            j--;
        }
    }
    
    public static String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        int j = 0;
        while (i < ch.length) {
            // move till ch[j] = ' '
            while (j < ch.length && ch[j] != ' ') {
                j++;
            }
            // j - 1 to skip ' '
            reverse(ch, i, j - 1);
            // increment j to pass  ' '
            j++;
            i = j;
        }
        return new String(ch);
    }

}
