package array;

public class RemoveDuplicatesFromSortedArray1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int removeDuplicates(int[] A) {
        if(A.length==0)
            return 0;
        int num=1;
		for(int i=1;i<A.length;i++){
			if(A[i]!=A[i-1]){
				A[num++]=A[i];
			}
		}
		return num;
    }
}
