import java.util.Arrays;
/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * */
public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 0, 1, 0, 2, 1, 1, 2 };
		// Arrays.sort(A);
		System.out.println(Arrays.toString(A));
//		sortColors(A);
		sortColorsFollowup(A);
		System.out.println(Arrays.toString(A));
	}

	public static void sortColors(int[] A) {
		int a = 0, b = 0, c = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				a++;
			} else if (A[i] == 1) {
				b++;
			} else {
				c++;
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (i < a) {
				A[i] = 0;
			} else if (i < a + b && i >= a) {
				A[i] = 1;
			} else {
				A[i] = 2;
			}
		}

	}

	//Could you come up with an one-pass algorithm using only constant space?
	//if current i is less than red flag, it means the things before red flags are all red
	//if current i is more than red flag, it means the there are some other colors between i and red flag
	//keep white in its place, swap the white after it, and blue before it
	public static void sortColorsFollowup(int[] A) {
		if (A == null || A.length == 1)
			return;
		int red=0,blue=A.length-1,i=0;
		while(red<blue){
			if(A[i]==0){
				if(i<=red){
					i++;red++;
				}
				else{
					swap(A,i,red);
					red++;
				}
			}
			else if(A[i]==2){
				if(i>=blue)
					return;
				else
				{
					swap(A,i,blue);
					blue--;
				}
			}
			else{
				i++;
			}
		}
	}

	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
