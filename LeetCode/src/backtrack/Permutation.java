package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import util.Util;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation p = new Permutation();

		int[] num = { 1, 1, 2 };
		List<List<Integer>> arr=p.permuteUnique(num);
		System.out.println(arr.size());
	}
//LTE
	HashSet<List<Integer>> hs = new HashSet<List<Integer>>();

	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permuteUnique(num, 0, result);
		return result;
	}

	private void permuteUnique(int[] num, int start, List<List<Integer>> result) {

		if (start >= num.length) {
			List<Integer> item = convertArrayToList(num);
			if (!hs.contains(item)){
				hs.add(item);
				result.add(item);
			}
		}

		for (int j = start; j <= num.length - 1; j++) {
			// if (containsDuplicate(num, start, j)) {
			swap(num, start, j);
			permuteUnique(num, start + 1, result);
			swap(num, start, j);
			// }
		}
	}

	private List<Integer> convertArrayToList(int[] num) {
		List<Integer> item = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			item.add(num[i]);
		}
		return item;
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
