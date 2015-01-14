package math;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
        //125 could offer 3 five, while 25 offers 2 five
        //that's a great idea!
        int res=0;
        while(n>0){
            res+=n/5;
            n=n/5;
        }
        return res;
    }
}
