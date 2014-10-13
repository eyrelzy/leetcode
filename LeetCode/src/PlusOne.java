import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 2, 3 };
		int[] B = { 8, 9, 9 };
		System.out.println(Arrays.toString(plusOne(A)));
		System.out.println(Arrays.toString(plusOne(B)));
	}

	// O(n) O(n)
	//to make code cleaner and better
	public static int[] plusOne(int[] digits) {
		int plus = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] <= 9) {
				digits[i] = (digits[i] + plus) % 10;
				if (digits[i] != 0) {
					plus = 0;
				}
			}
			if (plus == 0) {
				return digits;
			}
		}
		int[] ret = new int[digits.length + 1];
		ret[0] = 1;
		return ret;

	}

}
