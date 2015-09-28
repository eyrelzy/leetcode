package bs;

public class SearchInRotatedSortArray {
	public int search(int[] A, int target) {
        int left=0,right=A.length-1;
        while(left<=right){//equals
            int mid=(left+right)/2;
            if(target==A[mid]){
                return mid;
            }
            else if(target==A[left]){
                return left;
            }else if(target==A[right]){
                return right;
            }
            if (A[left] <= A[mid]) {/////
                if (target >= A[left] && target <= A[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (target >= A[mid] && target <= A[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        
        return -1;
    }
	
	int FindSortedArrayRotation(int A[], int N) {
		  int L = 0;
		  int R = N - 1;
		  
		  while (A[L] > A[R]) {
		    int M = L + (R - L) / 2;
		    if (A[M] > A[R])
		      L = M + 1;
		    else
		      R = M;
		  }
		  return L;
		}
	
	
}
