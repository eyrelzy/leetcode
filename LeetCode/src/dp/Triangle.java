package dp;

import java.util.LinkedList;
import java.util.List;
//第一个方法比较好理解，不用extra space
//从倒数第二排开始每个点 都是他的俩子孩子中较小的加上自己来更新自己
public class Triangle {
	public static void main(String[] args) {
		List<Integer> row = new LinkedList<Integer>();
		row.add(1);
		// [[1],[2,3]]
		List<List<Integer>> arr = new LinkedList<List<Integer>>();
		arr.add(row);
		row = new LinkedList<Integer>();
		row.add(2);
		row.add(3);
		arr.add(row);
		minimumTotal1(arr);

	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				triangle.get(i).set(
						j,
						triangle.get(i).get(j)
								+ Math.min(triangle.get(i + 1).get(j), triangle
										.get(i + 1).get(j + 1)));
			}
		}
		return triangle.get(0).get(0);
	}
//sol2:dp数组每次只有前triangle.get(i).size()位有用，反映从倒数第二行起，每个位置的更新值
	public static int minimumTotal1(List<List<Integer>> triangle) {
		int row = triangle.size();
		int size = triangle.get(row - 1).size();
		int[] dp = new int[size];
		for (int i = 0; i < size; i++) {
			dp[i] = triangle.get(row - 1).get(i);
		}
		for (int i = row - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
			}
		}
		return dp[0];
	}
}
