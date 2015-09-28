package array;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="13407807929942597099574024998205846127479365820592393377723561443721764030073546976801874298166903427690031858186486050853753882811946569946433649006084096";
		System.out.println(str.length());
		FirstMissingPositive fm = new FirstMissingPositive();
		int[] A = { 2,1 };
		int ret = fm.firstMissingPositive2(A);
		System.out.println(ret);
	}

	public int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= A.length && A[i] > 0 && A[A[i] - 1] != A[i]) {
				int temp = A[A[i] - 1];// swap (i, A[i]-1) until A[i]=i+1
				A[A[i] - 1] = A[i];
				A[i] = temp;
				i--;
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1)
				return i + 1;
		}
		return A.length + 1;
	}

	public int firstMissingPositive2(int[] A) {
		int n = A.length;
		for (int i = 0; i < n; i++) {
			if (A[i] <= n && A[i] > 0 && A[i] != A[A[i] - 1]) {
				int temp = A[i];
				A[i] = A[A[i] - 1];
				A[A[i] - 1] = temp;
				i--;
			}
		}
		for (int i = 0; i < n; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		return n + 1;
	}

}
