package dp;

public class LongestValidParenthese {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
  public class Solution {
    // if '(' continue
    // else ')' check forward one
      // if '(', it's a pair, so dp[i-2] + 2
      // else, check dp[i - len - 1], if it's a pair, extend this
    public int longestValidParentheses(String s) {
      int n = s.length();
      if(n<=1)    
          return 0;
      int[] dp = new int[n];
      int longest_len = 0;
      for(int i=1;i<n;i++){
          if(s.charAt(i) == ')'){
              if(s.charAt(i-1) == '('){
                  dp[i] = (i-2) >= 0 ? (dp[i-2] + 2):2;
              }else{
                  if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1) == '('){
                      dp[i] = dp[i-1] + 2 + ((i-dp[i-1]-2)>=0?dp[i-dp[i-1]-2]:0);
                  }
              }
              longest_len = Math.max(longest_len, dp[i]);
          }
      }
      return longest_len;
    }
}

}
