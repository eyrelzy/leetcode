package util;

import java.util.List;

public class Util {
	public static void log(String s) {
		System.out.println(s);
	}

	public static void log(int a) {
		System.out.println(a + "");
	}

	public static void log(double a) {
		System.out.println(a + "");
	}

	public static void logDoubleIntegerList(List<List<Integer>> arr) {
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.get(i).size(); j++) {
				System.out.println(arr.get(i).get(j));
			}
		}
	}

	public static void logIntegerList(List<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
	public static void logStringList(List<String> arr) {
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
