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
	public static void logMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print("[");
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+",");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	public static void logIntegerList(List<List<Integer>> ret) {
		for (int i = 0; i < ret.size(); i++) {
			System.out.println(ret.get(i));
		}
	}
	public static void logStringList(List<String> arr) {
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
