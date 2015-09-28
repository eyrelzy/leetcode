package stack;

import java.util.Stack;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2,1,0,2,3};
		TrappingRainWater tr = new TrappingRainWater();
		int ret = tr.trap2(A);
		System.out.println(ret);
	}
//idea trial
	public int trap(int[] A) {
		Stack<Integer> stack = new Stack<Integer>();
		int ret = 0;
		int i = 0;
		while (i + 1 < A.length) {
			if (A[i] >= A[i + 1]) {
				stack.push(A[i]);
			} else {
				if (!stack.isEmpty()) {
					int tmp = A[i];
					int top = stack.peek();
					int cnt = 1;
					while (tmp == top && !stack.isEmpty()) {
						stack.pop();
						if(stack.isEmpty()){
							break;
						}
						top = stack.peek();
						cnt++;
					}
					if(stack.isEmpty()){
						continue;
					}
					int left = stack.pop();
					int right = A[i + 1];
					ret += (Math.min(left, right) - tmp) * cnt;
					int k = 0;
					while (k <=cnt) {
						stack.push(Math.min(left, right));
						k++;
					}
				}
			}
			i++;
		}

		return ret;
	}
	//1,0,0,2,0,3
	//0,1,1,1,2,2
	//3,3,3,3,3,0
	//min container
	//0,1,1,1,2,0
	//compare with A[]
	public int trap2(int[] A) {
	    if(A==null || A.length==0)
	        return 0;
	    int max = 0;
	    int res = 0;
	    int[] container = new int[A.length];
	    //from left to right max
	    for(int i=0;i<A.length;i++)
	    {
	        container[i]=max;
	        max = Math.max(max,A[i]);
	    }
	    max = 0;
	    //from right to left max
	    for(int i=A.length-1;i>=0;i--)
	    {
	        container[i] = Math.min(max,container[i]);
	        max = Math.max(max,A[i]);
	        res += container[i]-A[i]>0?container[i]-A[i]:0;
	    }    
	    return res;
	}

}
