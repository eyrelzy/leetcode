package bs;

public class Search2DMatrix {
  
  // O(logm + logn)
  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0 || matrix[0].length == 0)
        return false;
    int row = matrix.length, col = matrix[0].length;
    int top=0, bottom = row-1,left=0, right = col-1;
    if(matrix[0][0] == target){
        return true;
    }
    if(row != 1){
        while(top<=bottom){
            int mid = top + (bottom-top)/2;
            if(matrix[mid][0] == target){
                return true;
            }
            if(matrix[mid][0]<target){
                top = mid+1;
            }else{
                bottom = mid-1;
            }
        }
    }
    if(bottom<0)    return false;
    if(col!=1){
        while(left<=right){
            int mid = left +(right-left)/2;
            if(matrix[bottom][mid] == target){
                return true;
            }
            if(matrix[bottom][mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
    }
    return false;
}
}
