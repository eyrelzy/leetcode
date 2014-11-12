package bt;

public class UniqueBST1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(new UniqueBST1().numTrees(2));
	}

	public int numTrees(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
//		if (n == 2)
//			return 2;
//		if (n == 3)
//			return 5;
		int ret = 0;
		for (int i = 0; i < n; i++) {
			ret += numTrees(i) * numTrees(n - 1 - i);
		}
		return ret;
	}
}
