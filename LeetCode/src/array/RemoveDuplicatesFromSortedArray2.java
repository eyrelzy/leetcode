package array;

import java.util.Arrays;

/**
 * recap: remove duplicates from sorted array1
 * 
 * 
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array A = [1,1,2],

 Your function should return length = 2, and A is now [1,2].

 =>solve: use the memory in the array
 * */

/**
 * 
 Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * 
 * */
public class RemoveDuplicatesFromSortedArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={1,1,1,2,2,3};
		System.out.println((removeDuplicates(A)));
	}

	public static int removeDuplicates(int[] A) {
		if(A.length==0)
			return 0;
		// we allow at most twice
		int n = A[0];
		int k = 1;
		int pointer = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == n && k < 2) {
				A[pointer++] = A[i];
				k++;
			}
			else if(A[i]!=n){
				n=A[i];
				A[pointer++]=A[i];
				k=1;
			}
		}
		return pointer;
	}

}
