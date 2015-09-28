package dp;

import util.Util;
/**
 * two dimension dynamic programming
 * **/
public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
		Util.log(minPathSum(grid));
	}
	
	/**
	 * opt[i][j]=Math.min(opt[i-1][j], opt[i][j-1])+grid[i][j];
	 * 
	 * */
	public static int minPathSum(int[][] grid){
	  if(grid == null || grid.length == 0)
        return 0;
    int m = grid.length, n=grid[0].length;
    int opt[][] = new int[m][n];
    opt[0][0] = grid[0][0];
    for(int row=1;row<m;row++){
        opt[row][0] = grid[row][0] + opt[row-1][0] ;
    }
    for(int col=1;col<n;col++){
        opt[0][col] = grid[0][col] + opt[0][col-1];
    }
    for(int row=1;row<m;row++){
        for(int col=1;col<n;col++){
            opt[row][col] = Math.min(opt[row-1][col], opt[row][col-1]) + grid[row][col];
        }
    }
    Util.logMatrix(opt);
    return opt[m-1][n-1];
	}

}
