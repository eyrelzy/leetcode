package math;
/**
 * test like 12321, -1, -123321,1001
 * negative numbers are considered as not palindrome number
 * */
public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test =-1;
		System.out.println(isPalindrome(test));
	}

	public static boolean isPalindrome(int x) {
		int temp = x;
		
		int result = 0;
		while (temp!=0) {
			int digit = temp % 10;
			result = result * 10 + digit;
			temp = temp / 10;
		}
//		System.out.println(result);
		if (result == x&&x>=0) {
			return true;
		} else
			return false;
	}
}
