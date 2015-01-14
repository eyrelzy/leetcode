package sort;

import java.util.Arrays;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestNumber ln=new LargestNumber();
//		int[] num={3, 30, 34, 5, 9};
//		int[] num={824,938,1399,5607,6973,5703,9609,4398,8247};
//		int[] num={1,2,1,2};
		int[] num={128,12};
		String ret=ln.largestNumber(num);
		System.out.println(ret);
		System.out.println("924".compareTo("9247")>0);
	}

	public String largestNumber(int[] num) {
		if(num.length==0){
			return "";
		}
		String ret="";
		int len=num.length;
		String[] strs=new String[len];
		for(int i=0;i<len;i++){
			strs[i]=String.valueOf(num[i]);
		}
		//strs[k]="99", num[k]=9
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				if(strs[j].startsWith(strs[i])||strs[i].startsWith(strs[j]))
				{
					String comb1=strs[i]+strs[j];
					String comb2=strs[j]+strs[i];
					if(comb1.compareTo(comb2)<0){
						int temp=num[j];
						num[j]=num[i];
						num[i]=temp;
						String tem=strs[j];
						strs[j]=strs[i];
						strs[i]=tem;
					}
					continue;
				}
				if(strs[j].compareTo(strs[i])>0){
					//swap num[i],num[j]
					int temp=num[j];
					num[j]=num[i];
					num[i]=temp;
					String tem=strs[j];
					strs[j]=strs[i];
					strs[i]=tem;
				}
			}
		}
//		System.out.println(Arrays.toString(num));		
		for(int i=0;i<len;i++){
			ret+=num[i];
		}
		if(ret.charAt(0)=='0')
			return "0";
//		System.out.println(Arrays.toString(strs));
		return ret;		
	}
	
	public static boolean compare(String s1, String s2) {
	    String s1s2 = s1 + s2;
	    String s2s1 = s2 + s1;
	    if (s1.length() < s2.length()) {
	        if (s1s2.compareTo(s2s1)>0)
	            return false;
	        else
	            return true;
	    } else {
	        if (s1s2.compareTo(s2s1)<0)
	            return true;
	        else
	            return false;
	    }
	}

	public static void mergeSort(int[] array) {
	    if (array.length > 1) {
	        int[] left = leftHalf(array);
	        int[] right = rightHalf(array);
	        mergeSort(left);
	        mergeSort(right);
	        merge(array, left, right);
	    }
	}

	public static int[] leftHalf(int[] array) {
	    int size1 = array.length / 2;
	    int[] left = new int[size1];
	    for (int i = 0; i < size1; i++) {
	        left[i] = array[i];
	    }
	    return left;
	}

	public static int[] rightHalf(int[] array) {
	    int size1 = array.length / 2;
	    int size2 = array.length - size1;
	    int[] right = new int[size2];
	    for (int i = 0; i < size2; i++) {
	        right[i] = array[i + size1];
	    }
	    return right;
	}

	public static void merge(int[] result, int[] left, int[] right) {
	    int i1 = 0;
	    int i2 = 0;
	    for (int i = 0; i < result.length; i++) {
	        if (i2 >= right.length
	                || (i1 < left.length && !compare(left[i1] + "", right[i2]
	                        + ""))) {
	            result[i] = left[i1];
	            i1++;
	        } else {
	            result[i] = right[i2];
	            i2++;
	        }
	    }
	}

	public static String largestNumber1(int[] num) {
	    mergeSort(num);
	    StringBuilder result = new StringBuilder();
	    for (int i = 0; i < num.length; i++) {
	        result.append(num[i]);
	        if (num[i] == 0 && i == 0)
	            break;
	    }
	    return result.toString();
	}

}
