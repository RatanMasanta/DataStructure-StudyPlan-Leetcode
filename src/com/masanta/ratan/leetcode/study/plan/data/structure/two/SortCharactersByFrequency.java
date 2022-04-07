package com.masanta.ratan.leetcode.study.plan.data.structure.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
	
	/*
	 * Given a string s, sort it in decreasing order based on the frequency of the
	 * characters. The frequency of a character is the number of times it appears in
	 * the string.
	 * 
	 * Return the sorted string. If there are multiple answers, return any of them.
	 */

	public static void main(String[] args) {
		System.out.println(frequencySort1("Aabb"));
		System.out.println(frequencySort2("tree"));
		System.out.println(frequencySort3("cccaaa")); // doesn't work correctly
		System.out.println(frequencySort1("cccaaa"));
		System.out.println(frequencySort2("cccaaa"));
		System.out.println(frequencySort4("cccaaa"));
		System.out.println(frequencySort("cccaaa"));
		System.out.println(frequencySort("Aabb"));
		System.out.println(frequencySort("tree"));
	}
	
	/*
	 * The logic is very similar to NO.347 and here we just use a map a count and
	 * according to the frequency to put it into the right bucket. Then we go
	 * through the bucket to get the most frequently character and append that to
	 * the final stringbuilder.
	 */
	    public static String frequencySort1(String s) {
	        Map<Character, Integer> map = new HashMap<>();
	        for (char c : s.toCharArray()) 
	            map.put(c, map.getOrDefault(c, 0) + 1);
							
	        List<Character> [] bucket = new List[s.length() + 1];
	        for (char key : map.keySet()) {
	            int frequency = map.get(key);
	            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
	            bucket[frequency].add(key);
	        }
					
	        StringBuilder sb = new StringBuilder();
	        for (int pos = bucket.length - 1; pos >= 0; pos--)
	            if (bucket[pos] != null)
	                for (char c : bucket[pos])
	                    for (int i = 0; i < pos; i++)
	                        sb.append(c);

	        return sb.toString();
	    }


	/*
	 * And we have normal way using PriorityQueue as follows: according to user
	 * "orxanb", O(n) ignore logm since m is the distinguish character, can be O(1)
	 * since only 26 letters. So the overall time complexity should be O(n), the
	 * same as the buck sort with less memory use.
	 */

	    public static String frequencySort2(String s) {
	        Map<Character, Integer> map = new HashMap<>();
	        for (char c : s.toCharArray())
	            map.put(c, map.getOrDefault(c, 0) + 1);
							
	        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
	        pq.addAll(map.entrySet());
					
	        StringBuilder sb = new StringBuilder();
	        while (!pq.isEmpty()) {
	            Map.Entry e = pq.poll();
	            for (int i = 0; i < (int)e.getValue(); i++) 
	                sb.append(e.getKey());
	        }
	        return sb.toString();
	    }


	/*
	 * There is a follow up if you are interested, when same frequency we need to
	 * maintain the same sequence as the character show in the original string, the
	 * solution is add a index as a secondary sort if the frequency is same, code as
	 * below:
	 */
	    public static String frequencySort3(String s) {
	        Map<Character, int[]> map = new HashMap<>();
	        for (int i = 0; i <s.length(); i++) {
	            char c = s.charAt(i);
	            if (!map.containsKey(c)) map.put(c, new int[]{1, i});
	            else {
	                int[] freqAndSeq = map.get(c);
	                freqAndSeq[0]++;
	                map.put(c, freqAndSeq);
	            }
	        }

	        PriorityQueue<Map.Entry<Character, int[]>> pq = new PriorityQueue<>((a, b) ->
	                a.getValue()[0] == b.getValue()[0] ? a.getValue()[1] - b.getValue()[1] : b.getValue()[0] - a.getValue()[0]);

	        pq.addAll(map.entrySet());
	        StringBuilder sb = new StringBuilder();
	        while (!pq.isEmpty()) {
	            Map.Entry<Character, int[]> e = pq.poll();
	            for (int i = 0; i < e.getValue()[0]; i++)
	                sb.append(e.getKey());
	        }
	        return sb.toString();
	    }
	    
	    public static String frequencySort4(String s) {
	        if(s.length() < 3)
	            return s;
	        int max = 0;
	        int[] map = new int[256];
	        for(char ch : s.toCharArray()) {
	            map[ch]++;
	            max = Math.max(max,map[ch]);
	        }
	        String[] buckets = new String[max + 1]; // create max buckets
	        for(int i = 0 ; i < 256; i++) { // join chars in the same bucket
	            String str = buckets[map[i]];
	            if(map[i] > 0)
	                buckets[map[i]] = (str == null) ? "" + (char)i : (str + (char) i);
	        }
	        StringBuilder strb = new StringBuilder();
	        for(int i = max; i >= 0; i--) { // create string for each bucket.
	            if(buckets[i] != null)
	                for(char ch : buckets[i].toCharArray())
	                    for(int j = 0; j < i; j++)
	                        strb.append(ch);
	        }
	        return strb.toString();
	    }
	    /*
	     * 	Fastest solution
	     * 
	     * 
	     */
	    
	    private static class Node implements Comparable<Node>{
	        public char c;
	        public int freq;
	        Node(char c, int freq) {
	            this.c = c;
	            this.freq = freq;
	        }
	        public int compareTo(Node m)
	        {
	            return this.freq - m.freq;
	        }
	    }
	    public static String frequencySort(String s) {
	        int[] freq = new int[256];
	        char[] str = new char[s.length()];
	        List<Node> data = new ArrayList<Node>();
	        
	        for(int i=s.length()-1; i>=0; i--) {
	            freq[s.charAt(i)]++;
	        }
	        for(int i=0; i<256; i++) {
	            if(freq[i] > 0) {
	                data.add(new Node((char)i, freq[i]));
	            }
	        }
	        Collections.sort(data, Collections.reverseOrder());  
	        
	        int si = 0;
	        for(int i=0; i<data.size(); i++) {
	            Node node = data.get(i);
	            for(int j=0; j<node.freq; j++) {
	                str[si++] = node.c;
	            }
	        }
	        return String.valueOf(str);
	    }

}
