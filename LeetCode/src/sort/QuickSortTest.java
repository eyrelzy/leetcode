package sort;
import java.util.Arrays;

public class QuickSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int arr[]={5,4,2,1};
QuickSortTest qst=new QuickSortTest();
qst.quicksort(arr, 0, arr.length-1);
System.out.println(Arrays.toString(arr));
	}

	public void quicksort(int[] arr, int left, int right) {
		if (left < right) {
			int partition = partition(arr, left, right);
			quicksort(arr, left, partition);
			quicksort(arr,partition+1,right);
		}
	}
	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public int partition(int[] arr, int left, int right) {
		int pivot = arr[left];//random select one
		while(left<right){
			swap(arr, left, right);
			while(left<right&&arr[right]>pivot)
				right--;
			while(left<right&&arr[left]<=pivot)
				left++;
		}
		return left;

	}
}
