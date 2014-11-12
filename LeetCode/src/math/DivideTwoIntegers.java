package math;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(5, 2));
	}
	//still LTE
	//WHY:: div<<cnt execute several times, instead we need to first div=<<cnt and then div>>1
	public static int divide(int dividend, int divisor) {
        int cnt=0, ret=0;
        int divide=Math.abs(dividend);
        int div=Math.abs(divisor);
        while((div<<cnt)<divide){
            cnt++;
        }
        ret+=1<<(cnt-1);
        divide-=div<<(cnt-1);
        cnt-=2;
        while(cnt>0){
           divide-=div<<(cnt);
           ret+=1<<(cnt);
           cnt--;
        }
        if((dividend<0&&divisor>0)||dividend>0&&divisor<0)
            return -ret;
        else
            return ret;
    }
//@see the final solution accepted
}
