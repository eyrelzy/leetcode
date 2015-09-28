package divideconquer;

import java.util.Arrays;

public class KthLargestElement {
	public static void main(String[] args){
		int[] nums = {3,2,4,5,6,1};
//		System.out.println(new KthLargestElement().findKthLargest(nums, 2));
		new KthLargestElement().quickSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
	
	//test case [2, 1], 1
    public int findKthLargest(int[] nums, int k) {
        return findK(nums, nums.length-k, 0, nums.length-1);
    }
    
    public void quickSort(int[] nums, int left, int right){
    	if (left < right) {
			int partition = partition(nums, left, right);
			quickSort(nums, left, partition);
			quickSort(nums,partition+1,right);
		}
    }
    
    private int findK(int[] nums, int k, int i, int j) {
        if(i>=j) return nums[i];
        int m = partition(nums, i, j);
        if(m==k) return nums[m];
        else if(m<k) {
            return findK(nums, k, m+1, j);
        } else {
            return findK(nums, k, i, m-1);
        }
    }
    
    private int partition(int[] nums, int i, int j) {
        int x = nums[i];
        int m = i;
        int n = i+1;
        
        while(n<=j){
            if(nums[n]<x) {
                swap(nums, ++m, n);
            }
            ++n;
        }
        swap(nums,i, m);
        return m;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
