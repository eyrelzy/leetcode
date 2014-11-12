package bs;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] A={1,3,5,6};
int[] B={};
System.out.println(new SearchInsertPosition().searchInsert(A, 5));
System.out.println(new SearchInsertPosition().searchInsert(A, 2));
System.out.println(new SearchInsertPosition().searchInsert(A, 7));
System.out.println(new SearchInsertPosition().searchInsert(A, 0));
System.out.println(new SearchInsertPosition().searchInsert(B, 2));
	}

	public int searchInsert(int[] A, int target) {
		if (A.length == 0)
			return 0;
		int index = 0;
		while (index<A.length&&target > A[index])
			index++;
		return index;
	}
}
