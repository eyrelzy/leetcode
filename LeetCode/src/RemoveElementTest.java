import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElementTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] B = { 1, 3, 6,4 };
		List<List<Integer>> arr=permute(B);
		for(List<Integer> l:arr){
			log(Arrays.toString(l.toArray()));
		}
	}

	public static void log(String s) {
		System.out.println(s);
	}

	// O(n) test case:int[] A={-2,1,1,3,1};
	public static int removeElement(int[] A, int elem) {
		int i = 0, j = A.length - 1;
		while (i <= j) {
			if (A[i] == elem) {
				A[i] = A[j];
				j--;
			} else {
				i++;
			}
		}
		return j + 1;

	}

	// A[num] override the A[i]
	public static int removeElement2(int[] A, int elem) {
		int num = 0;
		for (int i = 0; i < A.length; i++) {
			if (elem != A[i]) {
				A[num++] = A[i];
			}
		}
		return num;
	}

	// o(n) { 1, 1, 1, 2, 3, 3, 4 }
	public static int removeDuplicates(int[] A) {
		if (A.length == 0)// special cases
			return 0;
		int num = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1]) {
				A[num++] = A[i];
			}
		}
		return num;
	}

	// o(n)
	/**
	 * @testcase int[] A = { 1, 1, 1, 2, 3, 3, 4 ,-1,-1,-1,-1,-1}; int[]
	 *           B={1,3,6}; merge(A, 7, B, 3);
	 * */
	public static void merge(int A[], int m, int B[], int n) {
		int size = m + n - 1, i = m - 1, j = n - 1;
		while (i >= 0 && j >= 0) {
			if (A[i] >= B[j]) {
				A[size--] = A[i--];
			} else {
				A[size--] = B[j--];
			}
		}
		while (i >= 0) {
			A[size--] = A[i--];
		}
		while (j >= 0) {
			A[size--] = B[j--];
		}
	}
//O(n^3)
	public static List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());

		for (int i = 0; i < num.length; i++) {
			List<List<Integer>> sub = new ArrayList<List<Integer>>();
			for (List<Integer> l : result) {
//				log("l result:"+Arrays.toString(l.toArray()));
				for (int j = 0; j <= l.size(); j++) {
					l.add(j, num[i]);
					List<Integer> temp = new ArrayList<Integer>(l);
					sub.add(temp);//if we add l into sub here, when we remove j, it also changes
//					log("temp:"+Arrays.toString(temp.toArray()));
//					log("l:"+Arrays.toString(l.toArray()));
					l.remove(j);
//					log("l:"+Arrays.toString(l.toArray()));
					
				}
//				log("============");
			}
			result = new ArrayList<List<Integer>>(sub);
		}
		return result;
	}
	public static ArrayList<ArrayList<Integer>> permute2(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permute(num, 0, result);
		return result;
	}
	 
	static void  permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
	 
		if (start >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		}
	 
		for (int j = start; j <= num.length - 1; j++) {
			swap(num, start, j);
			permute(num, start + 1, result);
			swap(num, start, j);//保证还原之前的swap
		}
	}
	 
	private static ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}
	 
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}

}
