package dp;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test="acode";
		Set<String> dict=new HashSet<String>();
		dict.add("a");
		dict.add("code");
		System.out.println(wordBreak(test, dict));
	}
	public static boolean wordBreak(String s, Set<String> wordDict){
	  int n = s.length();
      boolean[] dp = new boolean[n+1];
      dp[0] = true;
      for(int j=1;j<=n;j++){
          for(int i=0;i<j;i++){
              if(dp[i] && wordDict.contains(s.substring(i,j))){
                  dp[j] = true;
                  break;// this is critical
              }
          }
      }
      return dp[n];
	}

}
