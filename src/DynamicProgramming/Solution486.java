package DynamicProgramming;
/*
 * #486 Predict the Winner
 * Given an array of scores that are non-negative integers. 
 * Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. 
 * Each time a player picks a number, that number will not be available for the next player. 
 * This continues until all the scores have been chosen. The player with the maximum score wins.
 */
public class Solution486 {

	public static void main(String[] args){
		int[] nums = {1,5,233,7};
		Solution486 s = new Solution486();
		System.out.println(s.PredictTheWinner(nums));
	}
	
	public boolean PredictTheWinner(int[] nums){
		if (nums.length<=1)
			return true;
		
		int[][] dp = new int[nums.length][nums.length];
		for (int i=0;i<nums.length;i++){
			dp[i][i] = nums[i];
		}
		
		int col = 1;
		for (int i=nums.length-1;i>0;i--){
			for (int j=0;j<i;j++){
				int right = dp[j][col+j-1];
				int left = dp[j+1][col+j];
				int m = right>left?left:right;
				dp[j][col+j] = sum(nums, j, col+j) - m;
				
			}
			col++;
		}
		
		int p1 = dp[0][nums.length-1];
		int p2 = sum(nums, 0, nums.length-1) - p1;
		if (p1 >= p2)
			return true;
		return false;
		
	}
	
	public static int sum(int[] nums,int i,int j){
		int sum = 0;
		for (int k=i;k<=j;k++){
			sum += nums[k];
		}
		return sum;
	}
	
}
