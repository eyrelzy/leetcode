package dp;


public class EditDistance {

  public static void main(String[] args) {
    String word1 = "ACGT";
    String word2 = "AGA";
    System.out.println(minDistance(word1, word2));
  }

  public static int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] opt = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      opt[i][0] = i;
    }
    for (int j = 0; j <= n; j++) {
      opt[0][j] = j;
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
          opt[i][j] = Math.min(Math.min(opt[i - 1][j], opt[i][j - 1]) + 1, opt[i - 1][j - 1] + 1);
        } else {
          opt[i][j] = opt[i - 1][j - 1];
        }
      }
    }
    return opt[m][n];
  }
}
