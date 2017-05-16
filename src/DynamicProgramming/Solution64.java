package DynamicProgramming;
/*
 * #64 Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class Solution64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minPathSum(int[][] grid){
		int m = grid.length;
		int n = grid[0].length;
		
		int[][] path = new int[m][n];
		path[0][0] = grid[0][0];
        for (int i=1;i<n;i++){
            path[0][i] = path[0][i-1] + grid[0][i];
        }
        
        for (int i=1;i<m;i++){
            for (int j=0;j<n;j++){
                if (j == 0)
                    path[i][j] = path[i-1][j] + grid[i][j];
                else
                    path[i][j] = min(path[i-1][j],path[i][j-1]) + grid[i][j];
                
            }
        }
        
        return path[m-1][n-1];
	}
	
	public static int min(int a,int b){
		return a>b?b:a;
	}
	
}
