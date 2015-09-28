package array;

import java.util.LinkedList;
import java.util.Queue;

public class MininumSizeSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int minSubArrayLen(int s, int[] nums) {
        Queue<Integer> arrQueue = new LinkedList<Integer>();
        int sum = 0;
        boolean flag = false;//this field could be ignore when following the ways below
        int len = Integer.MAX_VALUE;
        for(int i=0; i < nums.length; i++){
            if(sum < s){
            	if(i == nums.length)
                    break;
                arrQueue.add(nums[i]);
                sum += nums[i];
            }else{
            	flag = true;
            	len = Math.min(len, arrQueue.size());
            	sum -= arrQueue.peek();
            	arrQueue.poll();
            	i--;
            }
        }
        return flag?len:0;
    }
    
	public int minSubArrayLen1(int s, int[] nums) {
		int left = 0, right = 0;
		int sum = 0;
		int re = nums.length + 1;
		while (right < nums.length) {
			sum += nums[right];
			while (sum >= s) {
				if (right - left + 1 == 1)
					return 1;
				re = Math.min(re, right - left + 1);
				sum -= nums[left++];
			}
			right++;
		}
		return re == nums.length + 1 ? 0 : re;
	}
    //nlogn
//    class Solution:
//        # @param {integer} s
//        # @param {integer[]} nums
//        # @return {integer}
//        def minSubArrayLen(self, s, nums):
//            size = len(nums)
//            left, right = 0, size
//            bestAns = 0
//            while left <= right:
//                mid = (left + right) / 2
//                if self.solve(mid, s, nums):
//                    bestAns = mid
//                    right = mid - 1
//                else:
//                    left = mid + 1
//            return bestAns
//
    //this increases the lens of the sub array
//        def solve(self, l, s, nums):
//            sums = 0
//            for x in range(len(nums)):
//                sums += nums[x]
//                if x >= l:
//                    sums -= nums[x - l]
//                if sums >= s:
//                    return True
//            return False

}
