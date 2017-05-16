package DynamicProgramming;
/*
 * #70 Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Solution70 {
	public int climbStairs(int n) {
	        
        if (n <= 2)
            return n;
            
        int p0 = 1;
        int p1 = 2;
        int sum = 0;
        for (int i=2;i<n;i++){
            sum = p0 + p1;
            p0 = p1;
            p1 = sum;
        }
        
        return sum;
    }
}
