package DynamicProgramming;
/*
 * #62 Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */
public class Solution62 {

    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        for (int i=0;i<n;i++){
            path[0][i] = 1;
        }
        
        for (int i=1;i<m;i++){
            for (int j=0;j<n;j++){
                if (j == 0)
                    path[i][j] = path[i-1][j];
                else
                    path[i][j] = path[i-1][j] + path[i][j-1];
                
            }
        }
        
        return path[m-1][n-1];
        
    }
}
