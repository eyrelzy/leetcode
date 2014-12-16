package array;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] num={1,5,1};
NextPermutation np=new NextPermutation();
np.nextPermutation(num);
System.out.println(Arrays.toString(num));
	}

	public void nextPermutation(int[] num) {
		int i = num.length - 1;
		while (i > 0) {
			if (num[i] > num[i - 1]) {
				break;
			}else{
			}
			i--;
		}
//		System.out.println(i);
		if (i == 0) {
			Arrays.sort(num);
		} else {
			// swap i-1 and one bigger than that
			int j=num.length - 1;
			while(true){
				if(num[j]>num[i-1])
					break;
				j--;
			}
			swap(num,i-1,j);
			System.out.println("@"+Arrays.toString(num));
			//reverse not sort!! from i to the end
			reverse(num, i, num.length - 1);
		}
	}
	private void reverse(int[] num, int i, int j){
		while(i<j){
			swap(num,i,j);
			i++;
			j--;
		}
	}
	private void swap(int[] num, int i,int j){
		int temp=num[i];
		num[i]=num[j];
		num[j]=temp;
	}
}
