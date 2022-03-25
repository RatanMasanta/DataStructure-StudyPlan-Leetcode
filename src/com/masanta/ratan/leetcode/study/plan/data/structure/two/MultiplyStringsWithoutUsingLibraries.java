package com.masanta.ratan.leetcode.study.plan.data.structure.two;

public class MultiplyStringsWithoutUsingLibraries {

	public static void main(String[] args) {

		System.out.println(multiply("2","6"));
		System.out.println(multiply2("2","6"));
		System.out.println(multiply3("2","6"));
		
	}

	/*
	 * Solution: 
	 * 
		Remember how we do multiplication?
		
		Start from right to left, perform multiplication on every pair of digits, and add them together. Let's draw the process! From the following draft, we can immediately conclude:
		
		 `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]` 

	 */
	
	public static String multiply(String num1, String num2) {
		int m = num1.length(), n = num2.length();
		int[] pos = new int[m + n];

		for(int i = m - 1; i >= 0; i--) {
			for(int j = n - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
				int p1 = i + j, p2 = i + j + 1;
				int sum = mul + pos[p2];

				pos[p1] += sum / 10;
				pos[p2] = (sum) % 10;
			}
		}  

		StringBuilder sb = new StringBuilder();
		for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
		return sb.length() == 0 ? "0" : sb.toString();
	}
	
	
	/*
	 *  Fastest solution in leetcode
	 * 
	 */
	
	 public static String multiply2(String num1, String num2) {
	        char[] arr1 = num1.toCharArray();
	        char[] arr2 = num2.toCharArray();
	        int[] prods = new int[arr1.length + arr2.length];
	        for (int i = arr1.length - 1; i >= 0; i--) {
	            for (int j = arr2.length - 1; j >= 0; j--) {
	                int op1 = arr1[i] - '0';
	                int op2 = arr2[j] - '0';
	                prods[i + j + 1] += op1 * op2;
	            }
	        }
	        int carry = 0;
	        for (int i = prods.length - 1; i >= 0; i--) {
	            int val = prods[i] + carry;
	            int digit = val % 10;
	            carry = val / 10;
	            prods[i] = digit;
	        }
	        StringBuilder res = new StringBuilder();
	        int start = 0;
	        while (start < prods.length && prods[start] == 0) {
	            start++;
	        }
	        for (int i = start; i < prods.length; i++) {
	            res.append(prods[i]);
	        }
	        return res.toString() == "" ? "0" : res.toString();
	    }
	 
	 
	 /*
	  *  Approach 3
	  * 
	  * 
	  */
	 public static String multiply3(String num1, String num2) {
	        if (num1.equals("0") || num2.equals("0")) {
	            return "0";
	        }
	        
	        StringBuilder firstNumber = new StringBuilder(num1);
	        StringBuilder secondNumber = new StringBuilder(num2);
	        
	        // Reverse both the numbers.
	        firstNumber.reverse();
	        secondNumber.reverse();
	        
	        // To store the multiplication result of each digit of secondNumber with firstNumber.
	        int N = firstNumber.length() + secondNumber.length();
	        StringBuilder answer = new StringBuilder();
	        for (int i = 0; i < N; ++i) {
	            answer.append(0);
	        }
	        
	        for (int place2 = 0; place2 < secondNumber.length(); place2++) {
	            int digit2 = secondNumber.charAt(place2) - '0';
	            
	            // For each digit in secondNumber multiply the digit by all digits in firstNumber.
	            for (int place1 = 0; place1 < firstNumber.length(); place1++) {
	                int digit1 = firstNumber.charAt(place1) - '0';
	                
	                // The number of zeros from multiplying to digits depends on the 
	                // place of digit2 in secondNumber and the place of the digit1 in firstNumber.
	                int currentPos = place1 + place2;
	                
	                // The digit currently at position currentPos in the answer string
	                // is carried over and summed with the current result.
	                int carry = answer.charAt(currentPos) - '0';
	                int multiplication = digit1 * digit2 + carry;
	                
	                // Set the ones place of the multiplication result.
	                answer.setCharAt(currentPos, (char)(multiplication % 10 + '0'));
	                
	                // Carry the tens place of the multiplication result by 
	                // adding it to the next position in the answer array.
	                int value = (answer.charAt(currentPos + 1) - '0') + multiplication / 10;
	                answer.setCharAt(currentPos + 1, (char)(value + '0'));
	            }
	        }
	        
	        // Pop excess 0 from the rear of answer.
	        if (answer.charAt(answer.length() - 1) == '0') {
	            answer.deleteCharAt(answer.length() - 1);
	        }
	        
	        answer.reverse();
	        return answer.toString();
	    }

}
