import util.Util;


public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		Util.logMatrix(matrix);
//		clockwiseRotate(matrix);
//		rotate(matrix);
		falseclockwiseRotate(matrix);
		Util.logMatrix(matrix);
	}
	/**
	 * failure reason:
	 * 1.matrix condition leads to twice rotate the items inside
	 * 2.anticlockwise
	 * */
	public static void falseclockwiseRotate(int[][] matrix) {
        int n=matrix[0].length-1;
        for(int j=0;j<n;j++){
            for(int i=0;i<=j;i++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][n-i];
                matrix[j][n-i]=matrix[n-i][n-j];
                matrix[n-i][n-j]=matrix[n-j][i];
                matrix[n-j][i]=temp;
            }
        }
    }
	public static void anticlockwiseRotate(int[][] matrix) {
		int n=matrix[0].length-1;
		int half=n%2==1?n/2+1:n/2;
		for(int j=0;j<half;j++){
			for(int i=j;i<n-j;i++){
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][n-i];
                matrix[j][n-i]=matrix[n-i][n-j];
                matrix[n-i][n-j]=matrix[n-j][i];
                matrix[n-j][i]=temp;
			}
		}
	}
	public static void clockwiseRotate(int[][] matrix) {
        int n = matrix.length;
        int halfN;
        if (n % 2 == 0)
            halfN = n / 2;
        else
            halfN = n / 2 + 1;
        for (int i = 0; i < halfN; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

}
