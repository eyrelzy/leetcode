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

	  // binary search
	  public int searchInsert2(int[] nums, int target) {
	    int left = 0, right = nums.length - 1;// #1 point, otherwise index out of bound 
	    while(left < right){ // #2 point, here <=, then left = mid+1, right = mid-1
	        // the following two lines make sure we get the correct answer
	        if(target<nums[left])return left;
	        if(target>nums[right])return right+1;
	        
	        int mid = left + (right-left)/2;
	        if(nums[mid] == target){
	            return mid;
	        }
	        if(nums[mid] < target){
	            left = mid + 1; // but this must be, 'cause of /2 to integer
	        }else{
	            right = mid - 1; // this could be not +1
	        }
	    }
	    return left;
	}
}
