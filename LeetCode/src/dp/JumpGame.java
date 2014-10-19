package dp;

import util.Util;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * */
public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 3, 1, 1, 4 };
		int[] B = { 3, 2, 1, 0, 4 };
		int[] C = { 1,2,3,0,0 };
		System.out.println(canJump1(A));
		System.out.println(canJump1(B));
		System.out.println(canJump1(C));

	}
//O(n^2)
	// if we didn't write that break, it causes time limit
	public static boolean canJump(int[] A) {
		boolean[] arr = new boolean[A.length];
		if (A == null || A.length == 0)
			return true;
		if (A.length == 1)
			return true;
		if (A[0] == 0)
			return false;
		else
			arr[0] = true;

		for (int i = 1; i < A.length; i++) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (A[j] + j >= i && arr[j]) {
					flag = true;
					break;
				}
			}
			arr[i] = flag;
		}

		return arr[A.length - 1];
	}
	
	/**
	 * another o(n) updated
	 * **/
	public static boolean canJump1(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A.length <= 1)
			return true;
		if(A[0] >= (A.length - 1))
			return true;
		int maxlength = A[0];
		if(maxlength == 0)
		    return false;
		for(int i = 1; i < A.length - 1; i++)
		{
			if(maxlength >= i && (i + A[i]) >= A.length - 1)
				return true;
			if(maxlength <= i && A[i] == 0)
				return false;
//			if((i + A[i]) > maxlength)
				maxlength = i + A[i];
		}
		return false;
    }

}
