package dp;
/**
 * Sequence DP
 * */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import util.Util;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "0010000";
		Util.log(numDecodings(test));
	}
/**
 * this solution doesn't pass when test is 0001000
 * **/
	// 00
	// 01
	    public static int numDecodings(String s) {
	        int n = s.length();
	        if (n==0) return 0;
	        int[] dp = new int[n+1];
	        dp[0] = 1;
	        if (isValid(s.substring(0,1))) dp[1] = 1;
	        else dp[1] = 0;
	        for(int i=2; i<=n;i++){
	            if (isValid(s.substring(i-1,i)))
	                dp[i] = dp[i-1];
	            if (isValid(s.substring(i-2,i)))
	                dp[i] += dp[i-2];
	        }
	        return dp[n];
	    }
	    
	    public static boolean isValid(String s){
	        if (s.charAt(0)=='0') return false;
	        int code = Integer.parseInt(s);
	        return code>=1 && code<=26;
	    }
	

	public static HashMap<Integer, Character> findMap() {
		Map<Integer, Character> hp = new HashMap<Integer, Character>();
		hp.put(1, 'A');
		hp.put(2, 'B');
		hp.put(3, 'C');
		hp.put(4, 'D');
		hp.put(5, 'E');
		hp.put(6, 'F');
		hp.put(7, 'G');
		hp.put(8, 'H');
		hp.put(9, 'I');
		hp.put(10, 'J');
		hp.put(11, 'K');
		hp.put(12, 'L');
		hp.put(13, 'M');
		hp.put(14, 'N');
		hp.put(15, 'A');
		hp.put(15, 'A');
		hp.put(15, 'A');
		hp.put(15, 'A');
		hp.put(15, 'A');
		return (HashMap<Integer, Character>) hp;
	}

}
