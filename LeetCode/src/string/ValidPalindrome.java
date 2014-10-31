package string;
/**
 * special cases:
 * empty string is valid
 * */
public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "A man, a plan, a canal: Panama";
		String test1 = "race a car";
		String test2 = "";
		System.out.println(isPalindrome(test));
		System.out.println(isPalindrome(test1));
		System.out.println(isPalindrome(test2));
	}

	public static boolean isPalindrome(String s) {
		// remove all the punctuation
		s = s.replaceAll("[\\p{Punct}\\p{Space}]+", "").toLowerCase();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else
				return false;
		}
		return true;
	}

}
