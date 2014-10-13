import util.Util;

public class UniquePaths1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Util.log(uniquePaths(5, 4));
		Util.log(uniquePaths1(5,4));
	}
	//O(n^2) O(n^2)
	public static int uniquePaths1(int m, int n){
		int[][] metrix=new int[m][n];
		for(int i=0;i<n;i++)
			metrix[0][i]=1;
		for(int j=0;j<m;j++)
			metrix[j][0]=1;
		for(int j=1;j<n;j++){
			for(int i=1;i<m;i++){
				metrix[i][j]=metrix[i-1][j]+metrix[i][j-1];
			}
		}
		return metrix[m-1][n-1];
	}
	//O(n^2) O(n)
	//needs review
	public static int uniquePaths2(int m,int n){
		int[] res=new int[n];
		for(int j=0;j<n;j++) res[j]=1;
		for(int i=1;i<m;i++){
			res[0]=1;
			for(int j=1;j<n;j++){
				res[j]=res[j-1]+res[j];
			}
		}
		return res[n-1];
	}
//time limited
	public static int uniquePaths(int m, int n) {
		if (m == 1 || n == 1)
			return 1;

		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}
}