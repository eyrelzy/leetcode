package hashtable;

import java.util.HashMap;
/**
 * 难点：如何识别循环体？

解决方法：用一个HashMap记录每一个余数，当出现重复的余数时，那么将会进入循环，两个重复余数之间的部分就是循环体。

示例：1/13=0.076923076923076923...，当小数部分第二次出现0时，就意味着开始了循环，那么需要把076923用括号括起来，结果为0.(076923)。

涉及技巧：1）在不断相除的过程中，把余数乘以10再进行下一次相除，保证一直是整数相除；2）HashMap的key和value分别是<当前余数, 对应结果下标>，这样获取076923时就可根据value值来找。

注意点1：考虑正负数，先判断符号，然后都转化为正数；

注意点2：考虑溢出，如果输入为Integer.MIN_VALUE，取绝对值后会溢出。
 * */
public class FractionToRecurDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FractionToRecurDecimal ftr = new FractionToRecurDecimal();
		String s = ftr.fractionToDecimal(1, 6);
		System.out.println(s);
		System.out.println((double) (1 / (double) 13));
	}

	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "";
		StringBuffer ret = new StringBuffer();
		if ((numerator < 0) ^ (denominator < 0)) {
			// simple
			ret.append("-");
		}
		long num = numerator, den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);
		HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
		long pre = num / den;
		long mode = num % den;
		if (mode == 0) {
			return pre + "";
		} else {
			ret.append(pre + ".");
			hm.put(mode, ret.length());
			while (mode != 0) {
				long a = (mode * 10) / den;
				mode = (mode * 10) % den;
				ret.append(a);
				if (!hm.containsKey(mode)) {
					hm.put(mode, ret.length());
				} else {
					int val = hm.get(mode);
					// ret.append(a);
					System.out.println(ret.length() + "|" + val);
					ret.insert(val, "(");
					ret.append(")");
					break;
				}

			}
		}
		return ret.toString();
	}

}
