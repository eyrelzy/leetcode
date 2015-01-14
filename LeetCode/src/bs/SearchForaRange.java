package bs;

import java.util.Arrays;

public class SearchForaRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchForaRange afr = new SearchForaRange();
		int[] A = { 1 };
		int target = 1;
		System.out.println(Arrays.toString(afr.searchRange(A, target)));
	}

	public int[] searchRange(int[] A, int target) {
		int len = A.length - 1;
		int left = 0, right = len;
		boolean flag = false;
		int pos = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == A[mid]) {
				flag = true;
				pos = mid;
				break;
			} else if (target < A[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if (!flag)
			return new int[] { -1, -1 };
		else {
			// A[mid],A[mid-1]
			 int l=pos,r=pos;
	            while(l-1>=0){
	                if(A[l-1]==A[pos]){
	                    l--;
	                }else
	                    break;
	            }
	            while(r+1<A.length){
	                if(A[pos]==A[r+1])
	                    r++;
	                else
	                    break;
	            }
			    return new int[]{l,r};
			

		}
	}

}
