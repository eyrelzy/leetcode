package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import util.Util;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num={3,0,-2,-1,1,2};
		List<List<Integer>> ret=threeSum(num);
		Util.logIntegerList(ret);
	}

	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		System.out.println(Arrays.toString(num));
		HashSet<List<Integer>> hs=new HashSet<List<Integer>>();
		for(int i=0;i<num.length-2;i++){//critical point
			int j=i+1;
			int k=num.length-1;
			while(j<k){
				int sum=num[i]+num[j]+num[k];
				if(sum==0){
					List<Integer> li=new ArrayList<Integer>();
					li.add(num[i]);
					li.add(num[j]);
					li.add(num[k]);
					if(hs.add(li)){
						ret.add(li);
					}
					j++;
					k--;
				}else if(sum<0){
					j++;
				}else{
					k--;
				}
			}
		}
		return ret;
	}

}
