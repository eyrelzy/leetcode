package dp;
/**
 * quite similar to maximum subarray problem
 * 
 * here record the maximum positive number and the minimum negative number
 * 
 * */
public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { -3, -2, -4, 10 };
		MaximumProductSubarray mp = new MaximumProductSubarray();
		System.out.println(mp.maxProduct3(A));
//		System.out.println(maxProduct(A));
	}
//TLE
//opt(j)=max{opt(j-1), i*(i+1)*...j}
	public static int maxProduct(int[] A) {
		int[] opt = new int[A.length];
		opt[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			opt[i] = opt[i - 1];
			int k = 0;
			while (k <= i) {
				int other = 1;
				for (int j = k; j <= i; j++) {
					other = other * A[j];
				}
				System.out.print(other+" ");
				opt[i] = Math.max(other, opt[i]);
				k++;
			}
			System.out.println();
		}
		return opt[A.length - 1];
	}
//
	/**
	 * 其实子数组乘积最大值的可能性为：累乘的最大值碰到了一个正数；
	 * 或者，累乘的最小值（负数），碰到了一个负数。所以每次要保存累乘的最大
	 * （正数）和最小值（负数）。同时还有一个选择起点的逻辑，如果之前的最
	 * 大和最小值同当前元素相乘之后，没有当前元素大（或小）那么当前元素就
	 * 可作为新的起点。例如，前一个元素为0的情况，{1,0,9,2}，到9的时候9
	 * 应该作为一个最大值，也就是新的起点，{1,0,-9,-2}也是同样道理，-9比
	 * 当前最小值还小，所以更新为当前最小值。
这种方法只需要遍历一次数组即可，算法时间复杂度为O(n)。
	 * 
	 * */
	public static int maxProduct1(int[] A) {
		int neg_min=A[0],pos_max=A[0],max_product=A[0];
		for(int i=1;i<A.length;i++){
			int local_max=A[i]*pos_max;
			int local_min=A[i]*neg_min;
			neg_min=Math.min(Math.min(local_max, local_min),A[i]);
			pos_max=Math.max(Math.max(local_max, local_min),A[i]);
			max_product=Math.max(max_product,pos_max);
		}
		return max_product;
	}

  class A {
    int min = 1;
    int max = 1;
    @Override
    public String toString(){
      return "max:"+max+","+"min:"+min;
    }
    A() {
      min = 1;
      max = 1;
    }
  }

  public int maxProduct3(int[] nums) {
    A[] opt = new A[nums.length];
    for(int i=0;i<nums.length;i++){
      opt[i] = new A();
    }
    int max = nums[0];
    opt[0].max = nums[0];
    opt[0].min = nums[0];
    for (int i = 1; i < nums.length; i++) {
      opt[i].max = Math.max(Math.max(nums[i], opt[i - 1].max * nums[i]), opt[i - 1].min * nums[i]);
      opt[i].min = Math.min(Math.min(nums[i], opt[i - 1].max * nums[i]), opt[i - 1].min * nums[i]);
      max = Math.max(max, opt[i].max);
    }
    return max;
  }


}
