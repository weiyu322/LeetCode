package DynamicProgramming;
/*
 * #53 Maximum Subarray
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

public class Solution53 {
	
	public static void main(String[] args){
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		Solution53 s = new Solution53();
		System.out.println(s.maxSubArray(nums));
	}
	
	public int maxSubArray(int[] nums){
	
		int maxSum = Integer.MIN_VALUE;
		int dp = 0;
		
		for (int i=0;i<nums.length;i++){
			if (dp < 0)
				dp = nums[i];
			else
				dp += nums[i];
			
			if (dp > maxSum)
				maxSum = dp;
		}
		
		return maxSum;
	}
}
