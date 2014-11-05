package dfs;

public class UniquePath2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A={{0,0,0},{0,1,0},{0,0,0}};
		System.out.print(uniquePathsWithObstacles(A));
	}
	public static int uniquePathsWithObstacles(int[][] obstacleGrid){
		int m=obstacleGrid.length;
		int n=obstacleGrid[0].length;
		int[][] opt=new int[m][n];
		int flag=0;
		for(int i=0;i<m&&obstacleGrid[i][0]!=1;i++,flag++){
			opt[i][0]=1;
		}
		while(flag<m){
			opt[flag][0]=0;
			flag++;
		}
		flag=0;
		for(int j=0;j<n&&obstacleGrid[0][j]!=1;j++,flag++){
			opt[0][j]=1;
		}
		while(flag<n){
			opt[0][flag]=0;
			flag++;
		}
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(obstacleGrid[i][j]==1)
					opt[i][j]=0;
				else
					opt[i][j]=opt[i-1][j]+opt[i][j-1];
			}
		}
		return opt[m-1][n-1];
	}

}
