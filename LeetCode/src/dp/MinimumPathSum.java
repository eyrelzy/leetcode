package dp;

import util.Util;
/**
 * two dimension dynamic programming
 * **/
public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid={{1,2,3},{2,4,1},{3,5,2},{2,1,3}};
		Util.log(minPathSum(grid));
	}
	
	/**
	 * opt[i][j]=Math.min(opt[i-1][j], opt[i][j-1])+grid[i][j];
	 * 
	 * */
	public static int minPathSum(int[][] grid){
		int ret=0;
		int[][] opt=new int[grid.length][grid[0].length];
		opt[0][0]=grid[0][0];
		for(int i=1;i<grid[0].length;i++){
			opt[0][i]=grid[0][i]+opt[0][i-1];
		}
		for(int i=1;i<grid.length;i++){
			opt[i][0]=grid[i][0]+opt[i-1][0];
		}
		for(int i=1;i<grid.length;i++){
			for(int j=1;j<grid[0].length;j++){
				opt[i][j]=Math.min(opt[i-1][j], opt[i][j-1])+grid[i][j];
			}
		}
		ret=opt[grid.length-1][grid[0].length-1];
//		Util.logMatrix(opt);
		return ret;
	}

}
