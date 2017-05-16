package DynamicProgramming;
/*
 * #523 Continuous Subarray Sum
 * Given a list of non-negative numbers and a target integer k, 
 * write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, 
 * that is, sums up to n*k where n is also an integer.
 * Memory Limit Exceed
 */
public class Solution523 {
	public static void main(String[] args){
		
		int[] nums = {1,2,3};
		int k = 5;
		Solution523 s = new Solution523();
		System.out.println(s.checkSubarraySum(nums, k));
	}
	
	public boolean checkSubarraySum(int[] nums,int k){
		
		int[][] dp = new int[nums.length][nums.length];
		for (int i = 0;i<nums.length;i++){
			dp[i][i] = nums[i];
		}
		
		
		int col = 1;
		for (int i=nums.length-1;i>0;i--){
			for (int j=0;j<i;j++){
				dp[j][col+j] = dp[j][col+j-1]+nums[col+j];
				if (isMultipleOfK(dp[j][col+j], k))
					return true;
			}
			col++;
		}
		
		return false;
		
	}
	
	private boolean isMultipleOfK(int num,int k){
		if (k == 0){
			if (num == 0)
				return true;
			else
				return false;
		}
		
		if (k < 0)
			k = -k;
		
		if (num < 0)
			num = -num;
		
		int temp = num % k;
		
		if (temp == 0)
			return true;
		
		return false;
		
	}
}
