package bs;

public class Search2DMatrix2 {
	public boolean searchMatrix2(int[][] matrix, int target) {
		int row = 0;
		int col = matrix[0].length-1;
		while(row<matrix.length && col >= 0){
			if(matrix[row][col] ==  target){
				return true;
			}else if(matrix[row][col] <  target){
				row ++;
			}else{
				col--;
			}
		}
		return false;
    }
	
	
	public boolean searchMatrix(int[][] matrix, int target) {
        return bsSearch(matrix, 0, 0, matrix.length-1, matrix[0].length-1, target);
    }
    public boolean bsSearch(int[][] matrix, int row_l, int col_l, int row_h, int col_h, int target){
        if(row_l>row_h || col_l>col_h)
            return false;
        int row_m = (row_l+row_h)/2;
        int col_m = (col_l+col_h)/2;
        if(matrix[row_m][col_m] == target)
            return true;
        else if(matrix[row_m][col_m] > target){
            return bsSearch(matrix, row_l, col_l, row_m-1, col_h, target) || bsSearch(matrix, row_l, col_l, row_h, col_m-1, target);
        }else{
            return bsSearch(matrix, row_m+1, col_l, row_h, col_h, target) || bsSearch(matrix, row_l, col_m+1, row_h, col_h, target);
        }
    }
}
