package bs;
/**
 * 二分查找的问题是基于排好序的数组
 * */
import util.Util;

public class FindMinimumInRotatedSoredArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test={1,2};
		Util.log(findMin(test));
	}
	//binary search method O(logn) solve duplicates
	public static int findMin(int[] num) {
        if(num==null||num.length==0)
            return -1;
        if(num.length==1)
            return num[0];
        int low=0,high=num.length-1;
        int mid=0,min=num[0];
        while(low<=high){
        	mid=(low+high)>>1;
        	System.out.println("mid"+num[mid]);
        	if(num[mid]>num[high]){
        		low=mid+1;
        	}
        	else if(num[mid]<num[high]){
        		high=mid-1;
        	}
        	else{
        		return Math.min(min,num[mid]);
        	}
        	min=Math.min(min,num[mid]);
        }
        return min;
    }
	//FOLLOW-UP what if a lot of rotations?

}
