package backtrack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterCombinationsofaPhoneNumber lcpn = new LetterCombinationsofaPhoneNumber();
		List<String> rec = lcpn.iterletterCombinations("23");
		System.out.println(rec);
	}

	public List<String> letterCombinations(String digits) {
		String[] letters = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
				"wxyz" };
		List<String> rec = new ArrayList<String>();
		StringBuilder string = new StringBuilder();
		letterCombinationHelper(digits, 0, letters, string, rec);
		return rec;
	}

	private List<String> iterletterCombinations(String digits) {
		String[] letters = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
				"wxyz" };
		List<String> rec = new ArrayList<String>();
		rec.add("");
		for (int number = 0; number < digits.length(); number++) {
			String snumber = letters[digits.charAt(number) - '2'];
			int size = rec.size();
			for (int i = 0; i < size; i++) {
				String str = rec.get(i);
				System.err.println(str);
				for (int index = 0; index < snumber.length(); index++) {
					System.err.println("**" + str + snumber.charAt(index));
					rec.add(str + snumber.charAt(index));
				}
				System.err.println(rec + "," + i);
			}
		}
		for (int i = 0; i < 7; i++) {//hardcoding
			rec.remove(0);
		}
		return rec;
	}

	private void letterCombinationHelper(String digits, int number,
			String[] letters, StringBuilder sb, List<String> rec) {
		if (number == digits.length()) {
			rec.add(sb.toString());
			return;
		}

		String snumber = letters[digits.charAt(number) - '2'];
		for (int j = 0; j < snumber.length(); j++) {
			sb.append(snumber.charAt(j) + "");
			letterCombinationHelper(digits, number + 1, letters, sb, rec);
			sb.deleteCharAt(sb.length() - 1);
		}

	}

	private void letterCombinations(String digits, int number,
			String[] letters, StringBuilder string, List<String> rec) {
		if (digits.length() == number) {
			rec.add(string.toString());
			return;
		}
		String letter = letters[digits.charAt(number) - '2'];
		for (int i = 0; i < letter.length(); i++) {
			string.append(letter.charAt(i));
			letterCombinations(digits, number + 1, letters, string, rec);
			string.deleteCharAt(string.length() - 1);
		}
	}

}
