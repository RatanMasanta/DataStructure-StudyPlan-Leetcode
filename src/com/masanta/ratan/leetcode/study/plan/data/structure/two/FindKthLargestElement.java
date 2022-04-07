package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class FindKthLargestElement {

	public static void main(String[] args) {
		int[] nums = new int[] {3,2,3,1,2,4,5,5,6};
		System.out.println(findKthLargest1(nums, 4));
		System.out.println(findKthLargest2(nums, 1));
		System.out.println(findKthLargest3(nums, 2));
		System.out.println(findKthLargest4(nums, 3));

	}
	
	/*
	 * This problem is well known and quite often can be found in various text
	 * books.
	 * 
	 * You can take a couple of approaches to actually solve it:
	 * 
	 * O(N lg N) running time + O(1) memory The simplest approach is to sort the
	 * entire input array and then access the element by it's index (which is O(1))
	 * operation:
	 */
	public static int findKthLargest1(int[] nums, int k) {
	        final int N = nums.length;
	        Arrays.sort(nums);
	        return nums[N - k];
	}

	/*
	 * O(N lg K) running time + O(K) memory Other possibility is to use a min
	 * oriented priority queue that will store the K-th largest values. The
	 * algorithm iterates over the whole input and maintains the size of priority
	 * queue.
	 */
	public static int findKthLargest2(int[] nums, int k) {

	    final PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int val : nums) {
	        pq.offer(val);

	        if(pq.size() > k) {
	            pq.poll();
	        }
	    }
	    return pq.peek();
	}

	/*
	 * O(N) best case / O(N^2) worst case running time + O(1) memory The smart
	 * approach for this problem is to use the selection algorithm (based on the
	 * partion method - the same one as used in quicksort).
	 */
	public static int findKthLargest3(int[] nums, int k) {

	        k = nums.length - k;
	        int lo = 0;
	        int hi = nums.length - 1;
	        while (lo < hi) {
	            final int j = partition(nums, lo, hi);
	            if(j < k) {
	                lo = j + 1;
	            } else if (j > k) {
	                hi = j - 1;
	            } else {
	                break;
	            }
	        }
	        return nums[k];
	    }

	    private static int partition(int[] a, int lo, int hi) {

	        int i = lo;
	        int j = hi + 1;
	        while(true) {
	            while(i < hi && less(a[++i], a[lo]));
	            while(j > lo && less(a[lo], a[--j]));
	            if(i >= j) {
	                break;
	            }
	            exch(a, i, j);
	        }
	        exch(a, lo, j);
	        return j;
	    }

	    private static void exch(int[] a, int i, int j) {
	        final int tmp = a[i];
	        a[i] = a[j];
	        a[j] = tmp;
	    }

	    private static boolean less(int v, int w) {
	        return v < w;
	    }
		/*
		 * O(N) guaranteed running time + O(1) space
		 * 
		 * So how can we improve the above solution and make it O(N) guaranteed? The
		 * answer is quite simple, we can randomize the input, so that even when the
		 * worst case input would be provided the algorithm wouldn't be affected. So all
		 * what it is needed to be done is to shuffle the input.
		 * 
		 * The last ALG has average O(N) time, but worst case is O(N^2).
		 */
			
	public static int findKthLargest4(int[] nums, int k) {

	        shuffle(nums);
	        k = nums.length - k;
	        int lo = 0;
	        int hi = nums.length - 1;
	        while (lo < hi) {
	            final int j = partition(nums, lo, hi);
	            if(j < k) {
	                lo = j + 1;
	            } else if (j > k) {
	                hi = j - 1;
	            } else {
	                break;
	            }
	        }
	        return nums[k];
	    }

	private static void shuffle(int a[]) {

	        final Random random = new Random();
	        for(int ind = 1; ind < a.length; ind++) {
	            final int r = random.nextInt(ind + 1);
	            exch(a, ind, r);
	        }
	    }
		/*
		 * The last ALG has average O(N) time, but worst case is O(N^2)
		 * 
		 * There is also worth mentioning the Blum-Floyd-Pratt-Rivest-Tarjan algorithm
		 * that has a guaranteed O(N) running time.
		 */

}
