package dp;

public class MaximumSubArrary {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
  public int maxSubArray(int[] nums) {
    int max_sum = nums[0], opt = nums[0];
    for(int i=1;i<nums.length;i++){
        opt = (opt>0?opt+nums[i]:nums[i]);
        max_sum = Math.max(opt, max_sum);
    }
    return max_sum;
}

}
