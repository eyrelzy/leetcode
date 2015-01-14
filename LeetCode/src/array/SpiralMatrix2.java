package array;

import util.Util;

public class SpiralMatrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrix2 sm = new SpiralMatrix2();
		int[][] matrix = sm.generateMatrix(0);
		Util.logMatrix(matrix);

	}

	public int[][] generateMatrix(int n) {
		int index = 1;
		int i = 0;
		int j = 0;
		int[][] matrix = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		while (index <= n * n) {
			while (j < n&&!visited[i][j]) {
					matrix[i][j] = index;
					visited[i][j] = true;
					j++;
					index++;
			}
			j--;
			i++;
			while (i < n&&!visited[i][j]) {
					matrix[i][j] = index;
					visited[i][j] = true;
					i++;
					index++;
			}
			i--;
			j--;
			while (j >= 0&&!visited[i][j] ) {
				matrix[i][j] = index;
				visited[i][j] = true;
				j--;
				index++;
			}
			j++;
			i--;
			while (i >= 0&&!visited[i][j]) {
				matrix[i][j] = index;
				visited[i][j] = true;
				i--;
				index++;
			}
			i++;
			j++;
		}
		return matrix;
	}

}
