package com.masanta.ratan.leetcode.study.plan.algorithms.two;

public class MInimumSizeSubArraySun {

	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));

	}

	/*

	Intuition
	Shortest Subarray with Sum at Least K
	Actually I did this first, the same problem but have negatives.
	I suggest solving this problem first then take 862 as a follow-up.

	Explanation
	The result is initialized as res = n + 1.
	One pass, remove the value from sum s by doing s -= A[j].
	If s <= 0, it means the total sum of A[i] + ... + A[j] >= sum that we want.
	Then we update the res = min(res, j - i + 1)
	Finally we return the result res


	Complexity
	Time O(N)
	Space O(1)


	Java:
	 */
	
	
	public static int minSubArrayLen(int s, int[] A) {
		int i = 0, n = A.length, res = n + 1;
		for (int j = 0; j < n; ++j) {
			s -= A[j];
			while (s <= 0) {
				res = Math.min(res, j - i + 1);
				s += A[i++];
			}
		}
		return res % (n + 1);
	}

}
