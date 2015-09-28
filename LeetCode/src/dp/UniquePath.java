package dp;

public class UniquePath {
  
  // #2 grid with obstacles
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if(obstacleGrid == null || obstacleGrid.length == 0 ||obstacleGrid[0][0] == 1)
        return 0;
    int m = obstacleGrid.length, n=obstacleGrid[0].length;
    int opt[][] = new int[m][n];
    opt[0][0] = 1;
    for(int row=1;row<m;row++){
        opt[row][0] = (obstacleGrid[row][0]==1?0:opt[row-1][0]);
    }
    for(int col=1;col<n;col++){
        opt[0][col] = (obstacleGrid[0][col]==1?0:opt[0][col-1]);
    }
    for(int row=1;row<m;row++){
        for(int col=1;col<n;col++){
            opt[row][col] = (obstacleGrid[row][col]==1?0:opt[row-1][col] + opt[row][col-1]);
        }
    }
    return opt[m-1][n-1];
}
}
