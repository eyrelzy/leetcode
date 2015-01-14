package math;

import java.util.ArrayList;

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerToRoman itr = new IntegerToRoman();
		System.out.println(itr.intToRoman(11));
	}

	public String intToRoman(int num) {
		if (num < 1 || num > 3999)
			return "";

		StringBuffer res = new StringBuffer();
		ArrayList<Integer> digits = new ArrayList<Integer>();
		while (num > 0) {
			int digit = num % 10;
			num /= 10;
			digits.add(digit);
		}
		for (int i = 0; i < digits.size(); i++) {
			if (i == 0) {
				res.insert(0,convert(digits.get(0), 'I', 'V', 'X'));
			} else if (i == 1)
				res.insert(0,convert(digits.get(1), 'X', 'L', 'C'));
			else if (i == 2) {
				res.insert(0,convert(digits.get(2), 'C', 'D', 'M'));
			} else if (i == 3) {
				res.insert(0,convert(digits.get(3), 'M', ' ', ' '));
			}
		}
		return res.toString();

	}

	public String convert(int digit, char one, char five, char ten) {
		StringBuilder res = new StringBuilder();
		switch (digit) {
		case 9:
			res.append(one);
			res.append(ten);
			break;
		case 8:
		case 7:
		case 6:
		case 5:
			res.append(five);
			for (int i = 5; i < digit; i++)
				res.append(one);
			break;
		case 4:
			res.append(one);
			res.append(five);
			break;
		case 3:
		case 2:
		case 1:
			for (int i = 0; i < digit; i++)
				res.append(one);
			break;
		default:
			break;
		}
		return res.toString();
	}
}
