package string;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "fabbaabcdcbaekk";
		System.out.println(longestPalindrome(test));
	}

	public static String longestPalindrome(String s) {
		// how many divisor do we have? O(n*2-1)=n node +n-1 intervals
		String ret = "";
		int max = 0;
		for (int i = 1; i < s.length() * 2 - 1; i++) {
			int left = i / 2, right = i / 2 + 1;
			int len = 0;
			if (i % 2 == 0) {
				left--;
				len++;
			}
			while (left >= 0 && right <= s.length() - 1) {
				if (s.charAt(left) == s.charAt(right)) {
					len=len+2;
					left--;
					right++;
				} else {
					break;
				}
			}
			if(len>max){
				max=len;
				ret=s.substring(left+1,right);
			}
		}
		System.out.println(max);
		return ret;

	}

}
