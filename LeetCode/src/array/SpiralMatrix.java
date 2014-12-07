package array;

import java.util.ArrayList;
import java.util.List;

import util.Util;
//ano
public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = { };
		List<Integer> ret=sm.spiralOrder(matrix);
		System.out.println(ret);
	}
//
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new ArrayList<Integer>();
		int n = matrix.length;
		if(n==0)//case: {}
			return ret;
		int m = matrix[0].length;
		boolean[][] visited = new boolean[n][m];
		boolean flag = false;
		int col = 0, row = 0;
		while (true) {
			flag = true;
			while (col < m && !visited[row][col]) {
				visited[row][col] = true;
				ret.add(matrix[row][col]);
				flag = false;
				col++;
			}
			col--;row++;
			if(col>=m||col<0||row>=n||row<0)
				break;
			while (row < n && !visited[row][col]) {
				visited[row][col] = true;
				ret.add(matrix[row][col]);
				flag = false;
				row++;
			}
			row--;col--;
			if(col>=m||col<0||row>=n||row<0)
				break;
			while (col >= 0 && !visited[row][col]) {
				visited[row][col] = true;
				ret.add(matrix[row][col]);
				flag = false;
				col--;
			}
			col++;row--;
			if(col>=m||col<0||row>=n||row<0)
				break;
			while (row >= 0 && !visited[row][col]) {
				visited[row][col] = true;
				ret.add(matrix[row][col]);
				flag = false;
				row--;
			}
			col++;row++;
			if(col>=m||col<0||row>=n||row<0)
				break;
			if (flag) {
				break;
			}
		}
		return ret;
	}
}
