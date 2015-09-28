package bs;

public class FindMinInRotatedSortedArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
FindMinInRotatedSortedArray2 fm=new FindMinInRotatedSortedArray2();
int[] num={6,2};
int ret=fm.findMin(num);
System.out.println(ret);
	}
//we could not use the left
	
	
//	public int findMin(int[] num) {
//		int min = num[0];
//		int l = 0, r = num.length - 1;
//		while (l < r) {
//			int m = (l + r) / 2;
//			if (num[l] < num[r]) {
//				return num[l];
//			}
//			if (num[m] > num[l]) {
//				l = m + 1;
//				min = Math.min(min, num[l]);
//			} else if (num[m] < num[l]) {
//				r = m - 1;
//				min = Math.min(min, num[m]);
//			} else{
//				l++;
//			}
//		}
//		if(l<num.length){
//			min = Math.min(min, num[l]);
//		}
//		return min;
//	}
	public int findMin(int[] num) {
        int l = 0;
        int u = num.length - 1;

        while(l < u) {
            int m = (l + u) / 2;

            if (num[m] > num[u])//use right is very important for [1,3], otherwise we skip left
                l = m + 1;
            else if (num[m] < num[u])
                u = m;
            else
                u--;
        }
        return num[l];
    }

}
