package DynamicProgramming;
/*
 * #198 House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */

public class Solution198 {
	
	public static void main(String[] args){
		
	}
	
	public int rob(int[] nums){
		
		if (nums.length == 0)
			return 0;
		else if (nums.length == 1)
			return nums[0];

		int[]  dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = nums[0]>nums[1]?nums[0]:nums[1];
		
		for (int i=2;i<nums.length;i++){
			int temp1 = dp[i-1];
			int temp2 = dp[i-2] + nums[i];
			
			dp[i] = temp1>temp2 ? temp1:temp2;
		}
		
		return dp[dp.length-1];
		
	}

}
