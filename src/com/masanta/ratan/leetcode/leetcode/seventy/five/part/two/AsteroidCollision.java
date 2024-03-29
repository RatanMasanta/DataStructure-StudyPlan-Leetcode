package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

import java.util.Stack;

public class AsteroidCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i : asteroids) {
            if(i > 0) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(i)) {
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0)  {
                    stack.push(i);
                }
                if(stack.peek() == Math.abs(i)) {
                    stack.pop();
                }
            }
        }
        int[] res = new int[stack.size()];
        int j=stack.size()-1;
        while(!stack.isEmpty()) {
            res[j--] = stack.pop();
        }
        return res;
    }

}
