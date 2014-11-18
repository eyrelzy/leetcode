package bit;

public class FindTwoNumbersWithOddOccurrences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={12, 23, 34, 12, 12, 23, 12, 45};
		getTwoOddOccur(arr);
	}
	public static void getTwoOddOccur(int[] arr){
		int tmp=arr[0];
		for(int i=1;i<arr.length;i++){
			tmp=tmp^arr[i];
		}
		tmp=tmp&(~(tmp-1));//get the rightmost 1 bit
		//here tmp must be 0010 or 0001 or....
		int x=0,y=0;
		for(int i=0;i<arr.length;i++){
			// this guarantee that x and y are in two distinct group.
			if((tmp&arr[i])!=0){
				x=x^arr[i];
			}else{
				y=y^arr[i];
			}
		}
		System.out.println(x+","+y);
	}

}
