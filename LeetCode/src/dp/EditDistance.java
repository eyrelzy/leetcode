package dp;

import util.Util;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "ACGT";
		String word2 = "AGA";
		System.out.println(minDistance(word1, word2));
	}

	public static int minDistance(String word1, String word2) {
		int m = word1.length() + 1;
		int n = word2.length() + 1;
		int[][] opt = new int[m][n];
		for (int i = 0; i < m; i++) {
			opt[i][0] = i;
		}
		for (int j = 0; j < n; j++) {
			opt[0][j] = j;
		}
//		Util.logMatrix(opt);
//		System.out.println();
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				int mismatch = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0
						: 1;
				opt[i][j] = Math.min(
						Math.min(opt[i - 1][j], opt[i][j - 1])+ 1, mismatch
								+ opt[i - 1][j - 1]);
			}
		}
//		Util.logMatrix(opt);
		return opt[m - 1][n - 1];
	}

}
