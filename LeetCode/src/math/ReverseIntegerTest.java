package math;

import java.util.Arrays;

public class ReverseIntegerTest {
	public int reverse(int x) throws Exception {
		// 123->321
		int result = 0;
		String xs = "";
		if (x < 0) {
			xs = String.valueOf(-x);
		} else {
			xs = String.valueOf(x);
		}
		for (int i = 0; i < xs.length(); i++) {
			result = (int) (result + Integer.parseInt("" + xs.charAt(i))
					* Math.pow(10.0, i));
		}
		// if overflow
		// java的integer是32位的。范围在-2147483648 到2147483648
		// 溢出Integer.Max_Value
		if (result >= Integer.MAX_VALUE) {
			// throw new Exception();
			return -1;
		}
		if (x < 0) {
			return 0 - result;
		}
		return result;
	}

	// Solution 2: save some running time
	// do not have to consider whether it is a negative or a positive
	public int reverse2(int x) {
		int newN = 0, left = 0;
		while (x != 0) {
			left = x % 10;
			newN = newN * 10 + left;
			x = x / 10;
		}
		if (newN >= Integer.MAX_VALUE || newN <= Integer.MIN_VALUE)
			return -1;
		return newN;
	}
	public int maxProfit(int[] prices){
		int max_profit=0;
		int[] tags=new int[prices.length];
		int[] tmp=new int[prices.length];
		for(int i=0;i<prices.length;i++){
			tmp[i]=prices[i];
		}
		mergeSort(tmp, tags, 0, prices.length-1);
		System.out.println(Arrays.toString(tmp));
		int a=0,b=tags.length-1;
		while(a<b){
			if(tags[a]<=tags[b]){
				max_profit=max_profit+prices[tags[b]]-prices[tags[a]];
				a++;
				b--;
			}
			else{
				int left=prices[tags[a]];
				int right=prices[tags[b]];
			}
		}
		return -1;
	}
	public void mergeSort(int[] prices, int[] tags,int left,int right){
		if(left>=right)
			return;
		else{
			int middle=(left+right)/2;
			mergeSort(prices,tags,left,middle);
			mergeSort(prices, tags, middle+1, right);
			merge(prices,tags, left, middle, right);
//			System.out.println(Arrays.toString(tags));
		}
	}
	public void merge(int[] prices,int[] tags,int left,int middle,int right){
		//System.out.println("left:"+left+"mid:"+middle+"right"+right);
		if(left==0&&right==prices.length-1){
			int middle1=middle+1;
			int[] temp=new int[prices.length];
			int[] tmp=new int[prices.length];
			int i=left,j=left;
			while(left<=middle && middle1<=right){
				if(prices[left]>prices[middle1]){
					//tags[i]=middle1;
					temp[i]=tags[middle1];
					tmp[i++]=prices[middle1++];
				}
				else{
					temp[i]=tags[left];
					tmp[i++]=prices[left++];
				}
			}
			while(left<=middle){
				temp[i]=tags[left];
				tmp[i++]=prices[left++];
			}
			while(middle1<=right){
				temp[i]=tags[middle1];
				tmp[i++]=prices[middle1++];
			}
			while(j<=right){
				prices[j]=tmp[j];
				tags[j]=temp[j];
				j++;
			}
			return;
		}
		int middle1=middle+1;
		//int[] temp=new int[prices.length];
		int[] tmp=new int[prices.length];
		int i=left,j=left;
		while(left<=middle && middle1<=right){
			if(prices[left]>prices[middle1]){
				tags[i]=middle1;
				//temp[i]=tags[middle1];
				tmp[i++]=prices[middle1++];
			}
			else{
				tags[i]=left;
				tmp[i++]=prices[left++];
			}
		}
		while(left<=middle){
			tags[i]=left;
			tmp[i++]=prices[left++];
		}
		while(middle1<=right){
			tags[i]=middle1;
			tmp[i++]=prices[middle1++];
		}
		while(j<=right){
			prices[j]=tmp[j];
			j++;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println(new ReverseIntegerTest().reverse(1000000003));
		int[] prices={-1,3,6,1,4,2,10,5,11};
		int[] tags=new int[prices.length];
		new ReverseIntegerTest().mergeSort(prices, tags, 0, prices.length-1);
		System.out.println(Arrays.toString(prices));
		System.out.println(Arrays.toString(tags));
	}

}
