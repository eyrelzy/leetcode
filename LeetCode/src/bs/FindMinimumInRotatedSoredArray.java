package bs;
/**
 * 二分查找的问题是基于排好序的数组
 * */

public class FindMinimumInRotatedSoredArray {

	//binary search method O(logn) solve duplicates
	public int findMin(int[] nums) {
      int left = 0, right = nums.length-1;
      if(nums.length == 1)
          return nums[0];
      while(left<right){
          int mid = left + (right - left)/2;
          // #1 
          if(mid-1>=0 &&nums[mid]<nums[mid-1])
              return nums[mid];
          // only if it's the peak, this could happen, and the minimal must be in your right
          if(nums[mid] >= nums[left] && nums[mid] > nums[right]){
              left = mid + 1;
          }else{
              right = mid - 1;
          }
      }
      return nums[left];
  }
	//FOLLOW-UP what if we have duplicates
	public int findMin2(int[] nums) {
      int left = 0, right = nums.length-1;
      if(nums.length == 1)
          return nums[0];
      while(left<right){
          int  mid = left+(right-left)/2;
          if(mid-1>=0 && nums[mid]<nums[mid-1]){
              return nums[mid];
          }
          if(nums[mid]>=nums[left] && nums[mid]>nums[right]){
              left = mid+1;
          }else if(nums[mid] == nums[right]){
              right--; // the worst case might be O(n)
          }else{
              right = mid-1;
          }
      }
      return nums[left];
  }
	// O(n) solution
	public int findMin_1(int[] nums) {
      int curr = nums[0];
      for(int i=1;i<nums.length;i++){
          if(nums[i]>curr){
              curr = nums[i];
          }else{
              return nums[i];
          }
      }
      return nums[0];
  }

}
