package bs;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findPeakElement(int[] num) {
		if (num.length == 0)
			return 0;
		int i = 0;
		while (i + 1 < num.length && num[i] < num[i + 1]) {
			i++;
		}
		return i;
	}
	
//lgn
	public int bsfindPeakElement(int[] num) {
		int left = 0, right = num.length - 1;
		while (left <= right) {
			if (left == right)
				return left;
			int mid = (left + right) / 2;
			if (num[mid] < num[mid + 1])
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}

}
