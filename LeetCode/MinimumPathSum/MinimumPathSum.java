// https://leetcode.com/problems/minimum-path-sum/
// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

class Solution {
    public int minPathSum(int[][] grid) {
        
        
        int rowCount = grid.length;
        int colCount = grid[0].length;
        
        int dpMatrix[][] = new int[rowCount][colCount];
        // First row
        dpMatrix[0][0] = grid[0][0];
        for(int j=1; j<colCount; j++){
            dpMatrix[0][j] = grid[0][j] + dpMatrix[0][j-1];
        }
        for(int i=1; i<rowCount; i++){
            dpMatrix[i][0] = grid[i][0] + dpMatrix[i-1][0];
        }
        for(int i=1; i<rowCount; i++){
            for(int j=1; j<colCount; j++){
                dpMatrix[i][j] = Math.min(dpMatrix[i-1][j], dpMatrix[i][j-1]) + grid[i][j];
            }
        }
        return dpMatrix[rowCount-1][colCount-1];
    }
}
