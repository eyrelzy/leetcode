package array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 2, 7,2,2, 11, 15 };
		int[] ret = twoSum(numbers, 4);
		System.out.println(ret[0] + "|" + ret[1]);
	}
	// solution 1: hashmap
	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			hm.put(numbers[i], i + 1);
		}
		System.out.println(hm.size());
		int[] reta = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int one = numbers[i];
			int index = i + 1;
			if (hm.containsKey(target - one)) {
				int in = hm.get(target - one);
				if (in != index) {
					reta[0] = index;
					reta[1] = in;
					return reta;
				}
			}
		}
		int[] ret = { -1, -1 };
		return ret;
	}
	// this way if we have tie, we would not put the second tie thing into map
	public static int[] twoSum1(int[] numbers, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n = numbers.length;
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[0] = map.get(target - numbers[i]) + 1;
				result[1] = i + 1;
				break;
			} else {
				map.put(numbers[i], i);
			}
		}
		return result;

	}

	// two pointers o(nlogn)
	// sort first, one pointer from start and one from end until they get
	// together
	// then return false
	public static int[] twoSum2(int[] numbers, int target) {
		int N = numbers.length;
		int[] ret=new int[2];
		int[] sorted = new int[N];
		System.arraycopy(numbers, 0, sorted, 0, N);
		Arrays.sort(sorted);
		int pre=0,post=N-1;
		while(pre<post){
			int sum=sorted[pre]+sorted[post];
			if(sum==target){
				break;
			}
			else if(sum<target){
				pre++;
			}else{
				post--;
			}
		}
		int one=sorted[pre];
		int other=sorted[post];
		int index1=-1,index2=-1;
		for(int i=0;i<numbers.length;i++){
			if(numbers[i]==one||numbers[i]==other){
				if(index1==-1)
					index1=i+1;
				else
					index2=i+1;
			}
		}
		ret[0]=index1;
		ret[1]=index2;
		Arrays.sort(ret);
		return ret;
		
	}

}
