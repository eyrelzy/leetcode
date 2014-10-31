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
	public static boolean wordBreak(String s, Set<String> dict){
		boolean[] dp=new boolean[s.length()+1];
		dp[0]=true;
		for(int i=0;i<s.length();i++){
			for(int j=0;j<=i;j++){
				boolean b=dict.contains(s.substring(j,i+1));
				System.out.println(b);
				dp[i+1]=(dp[j]&&dict.contains(s.substring(j,i+1)));
				//tricky here, we have to store the true value to the i+1 position
				//not i position
				if(dp[i+1]){
					System.out.println(i+"|"+s.substring(j,i+1));
					break;
				}
			}
		}
		return dp[s.length()];
	}

}
