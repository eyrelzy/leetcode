import java.lang.reflect.Array;
import java.util.Arrays;

import util.Util;

public class Search2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix={{1}};
		System.out.println(searchMatrix1(matrix, 1));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int[] ret=searchMid(matrix, target, 0, matrix.length-1);
		System.out.println(Arrays.toString(ret));
		return searchArrayMid(ret, target, 0, ret.length-1);
	}
	public static int[] searchMid(int[][] matrix, int target, int left, int right){
		int[] ret=new int[matrix[0].length];
		if(left>=right)
			return matrix[left];
		int mid=(left+right)>>1;
		if(target>=matrix[mid][0]&&target<=matrix[mid][matrix[mid].length-1])
			return matrix[mid];
		if(target<matrix[mid][0])
			ret=searchMid(matrix,target,left,mid);
		else if(target>matrix[mid][matrix[mid].length-1])
			ret=searchMid(matrix,target,mid+1,right);
		return ret;
	}
	public static boolean searchArrayMid(int[] ret, int target, int left, int right){
		boolean flag=false;
		if(left>=right){
			if(ret[left]==target)
				return true;
			return false;
		}
		int mid=(left+right)>>1;
		if(ret[mid]==target)
			return true;
		if(target<ret[mid])
			flag=searchArrayMid(ret,target,left,mid);
		else
			flag=searchArrayMid(ret,target,mid+1,right);
		return flag;
	}
	// it could also be consider as a sorted Array
	//similar to binary tree,递归和非递归方式解决
	//以后要注意，start<=end这种条件，以及递归的条件！！！
	public static boolean searchMatrix1(int[][] matrix, int target) {
		if(matrix==null||matrix[0].length==0||matrix.length==0)
			return false;
		int m=matrix.length;
		int n=matrix[0].length;
		int start=0,end=n*m-1;
		while(start<=end){
			int mid=(start+end)>>1;
			int x=mid/n;//row
			int y=mid%n;//col
			if(matrix[x][y]==target) 
                return true;
			if(target<matrix[x][y])
				end=mid-1;
			else
				start=mid+1;
		}
		return false;
	}

}
