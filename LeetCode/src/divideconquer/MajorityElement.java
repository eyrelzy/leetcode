package divideconquer;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityElement me = new MajorityElement();
		int[] num = { 2, 3, 2, 2, 2, 4, 4, 3, 2 };
		int ret = me.majorityElement(num);
		System.out.println(ret);
	}

	// the same idea as the counter and current element rule
	public int majorityElement(int[] num) {
		if (num.length == 1) {
			return num[0];
		}
		boolean[] visited = new boolean[num.length];
		int prev = 0, post = 1;
		while (post < num.length) {
			if (num[prev] != num[post]) {
				visited[prev] = true;
				visited[post] = true;
			} else {
				post++;
			}
			while (visited[prev]) {
				prev++;
			}
			while (post < num.length && (visited[post] || post <= prev)) {
				post++;
			}
		}
		return num[prev];
	}
//////////////////////////////
	private int global = 0;
	private int gleft = 0;
	private int gright = 0;

	public int dcmajorityElement(int[] num) {
		div(num, 0, num.length - 1);
		return -1;
	}

	public void div(int[] num, int left, int right) {
		if (left >= right)
			return;
		int mid = (left + right) / 2;
		div(num, left, mid);
		div(num, mid + 1, right);
		// merge
		if (left + 1 == right) {
			if (num[left] == num[right]) {
				global = num[left];
			} else {
				// count
				gleft = num[left];
				gright = num[right];
			}
		}else{
			
		}

	}
	// the 3rd solution is sort first, and get the
	// int n = num.size();
	// sort(num.begin(),num.end());
	// return num[n/2];

}
