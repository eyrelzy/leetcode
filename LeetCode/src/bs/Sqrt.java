package bs;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sqrt s=new Sqrt();
System.out.println(s.sqrt(2147395599));
	}
	 public int sqrt(int x) {
	        int left=0,right=0;
	        if(x>=1){
	            //>1
	            left=1;
	            right=x/2+1;//
	        }else if (x<0){
	            return -1;
	        }else{
	            //0-1
	            left=0;
	            right=1;
	            return 0;
	        }
	        while(left<=right){
	            int mid=(left+right)/2;
//	            int mul=mid*mid;
	            if(mid<=x/mid&&x/(mid+1)<mid+1)
	            	return mid;//
	            if(x/mid>mid){
	                left=mid+1;
	            }else{
	                right=mid-1;
	            }
	        }
	        return 0;
	    }

}
