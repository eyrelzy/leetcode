package similar_consecutive_sum_one_loop_max_min;

public class FindMinimumInRotatedSoredArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findMin(int[] num) {
        if(num==null||num.length==0)
            return -1;
        if(num.length==1)
            return num[0];
        int min=num[0];
        for(int i=1;i<num.length-1;i++){
            if(num[i]<num[i-1]&&num[i]<num[i+1]){
                min=Math.min(min,num[i]);
            }
        }
        min=Math.min(min,num[num.length-1]);
        return min;
    }
	//FOLLOW-UP what if a lot of rotations?

}
