package bs;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findPeakElement(int[] num) {
		if (num.length == 0)
			return 0;
		int i = 0;
		while (i + 1 < num.length && num[i] < num[i + 1]) {
			i++;
		}
		return i;
	}
	
//lgn
	public int bsfindPeakElement(int[] num) {
		int left = 0, right = num.length - 1;
		while (left <= right) {
			if (left == right)
				return left;
			int mid = (left + right) / 2;
			if (num[mid] < num[mid + 1])
				left = mid + 1;
			else
				right = mid;
		}
		return left;
	}
	
	public int findPeakElement2(int[] nums) {
      if(nums.length == 1)
          return 0;
      int n = nums.length;
      if(nums[0]>nums[1]){
          return 0;
      }
      if(nums[n-1]>nums[n-2]){
          return n-1;
      }
      int left = 0, right = n-1;
      int l=0,r=0;
      while(left<right){ //left<=right
          int mid = left + (right-left)/2;
          l = mid==0? Integer.MIN_VALUE:nums[mid-1];
          r = mid==n-1? Integer.MIN_VALUE:nums[mid+1];
          if(nums[mid] > l && nums[mid]>r) // the values to be compared is its neighbor
              return mid;
          if(nums[mid]<l){
              right = mid-1;
          }else{
              left = mid+1;
          }
      }
      return left; //-1
  }

}
