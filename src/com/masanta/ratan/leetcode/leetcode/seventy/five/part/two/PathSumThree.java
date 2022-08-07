package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

import java.util.HashMap;
import java.util.Map;

public class PathSumThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    static Map<Long, Long> map;
    static int ans;
    public static int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        map = new HashMap<>();
        map.put(0L, 1L);
        ans = 0;
        helper(root, 0L, (long)sum);
        return ans;
    }
    
    private static void helper(TreeNode root, long curSum, long sum){
        if (root == null)
            return;
        curSum += root.val;
        if (map.containsKey(curSum - sum)){
            ans += map.get(curSum - sum);
        }
        map.put(curSum, map.getOrDefault(curSum, 0L) + 1);
        helper(root.left, curSum, sum);
        helper(root.right, curSum, sum);
        map.put(curSum, map.get(curSum) - 1);
        if (map.get(curSum) == 0)
            map.remove(curSum);
    }

}
