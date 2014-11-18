package string;

public class StrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "a";
		String needle = "a";
		System.out.println(brute_force_strStr(haystack, needle));
	}

	public static String brute_force_strStr(String haystack, String needle) {
		if (haystack == null || haystack.length() < needle.length())
			return null;
		if (haystack.trim().equals(needle.trim()))
			return haystack;
		// above are special cases.
		boolean flag = false;
		for (int i = 0; i < haystack.length(); i++) {
			for (int j = 0, k = i; j < needle.length(); j++, k++) {
				if (k >= haystack.length())// 试着outofindex i.e. missipi isss,
											// test to the end 'i'
					return null;
				if (needle.charAt(j) != haystack.charAt(k)) {
					flag = true;
					break;
				} else {
					flag = false;
				}
			}
			if (flag == false) {
				return haystack.substring(i);
			}
			flag = false;
		}
		return null;

	}

	public String strStr(String haystack, String needle) {

		int needleLen = needle.length();
		int haystackLen = haystack.length();

		if (needleLen == haystackLen && needleLen == 0)
			return "";
		if (needleLen == 0)
			return haystack;
		for (int i = 0; i < haystackLen; i++) {
			// make sure in boundary of needle
			if (haystackLen - i + 1 < needleLen)
				return null;
			int k = i;
			int j = 0;
			while (j < needleLen && k < haystackLen
					&& needle.charAt(j) == haystack.charAt(k)) {
				j++;
				k++;
				if (j == needleLen)
					return haystack.substring(i);
			}
		}
		return null;
	}

	/**
	 * 
	 * 接下来介绍一种比较容易理解的线性算法，称为rolling hash，想具体了解的朋友可以参见Rolling hash - Wikipedia。
	 * 基本思想是用一个hashcode来表示一个字符串，为了保证hash的唯一性，我们用比字符集大的素数为底，以这个素数的幂为基。
	 * 举例来说，字符集是小写字母集
	 * ，取素数29为底。比如字符串“abacd",转化为hashcode=1+2*29+1*29^2+3*29^3+4*29^4。
	 * 然后是如何在前进一步的时候计算新的hashcode
	 * ，比如匹配串是原串是”abacde“，匹配串长度为5，根据以上的方法计算”abacd“的hashcode=h，
	 * 那么下一步”bacde“的hashcode
	 * =h/29+5*29^4。这是一个constant的操作，所以检测所有子串的时间复杂度只需要O(m+n-m
	 * )=O(n)，也是一个线性算法。代码如下：
	 * 
	 * 比较细心的朋友可能看出来了，这个方法的hashcode比较容易越界，因为以素数为底的幂会很大，解决的办法可以用BigInteger,
	 * 或者如同Rabin–Karp algorithm -
	 * Wikipedia一样对于hashcode进行取余，但是可能存在多个字符串映射到同一hashcode的问题，尽管是很少数的情况。
	 * */

	public String strStr1(String haystack, String needle) {
		if (haystack == null || needle == null)
			return null;
		if (haystack.length() == 0) {
			return needle.length() == 0 ? "" : null;
		}
		if (needle.length() == 0)
			return haystack;
		if (haystack.length() < needle.length())
			return null;

		int base = 29;
		long patternHash = 0;
		long tempBase = 1;

		for (int i = needle.length() - 1; i >= 0; i--) {
			patternHash += (int) needle.charAt(i) * tempBase;
			tempBase *= base;
		}

		long hayHash = 0;
		tempBase = 1;
		for (int i = needle.length() - 1; i >= 0; i--) {
			hayHash += (int) haystack.charAt(i) * tempBase;
			tempBase *= base;
		}
		tempBase /= base;

		if (hayHash == patternHash) {
			return haystack;
		}

		for (int i = needle.length(); i < haystack.length(); i++) {
			hayHash = (hayHash - (int) haystack.charAt(i - needle.length())
					* tempBase)
					* base + (int) haystack.charAt(i);
			if (hayHash == patternHash) {
				return haystack.substring(i - needle.length() + 1);
			}
		}
		return null;
	}
}
