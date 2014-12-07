package two_pointer;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num={1,1,-1,-1,3};
		ThreeSumClosest tsc=new ThreeSumClosest();
		System.out.println(tsc.threeSumClosest(num, 1));
	}

	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int dist=Integer.MAX_VALUE;
		int ret=0;
		for(int i=0;i<=num.length-3;i++){
			int j=i+1;
			int k=num.length-1;
			while(j<k){
				int sum=num[i]+num[j]+num[k];
				if(sum<target){
					j++;
				}else if(sum>target){
					k--;
				}else{
					return target;
				}
				if(Math.abs(sum-target)<dist){
					dist=Math.abs(sum-target);
					ret=sum;
				}
			}
		}
		return ret;
		
	}

}
