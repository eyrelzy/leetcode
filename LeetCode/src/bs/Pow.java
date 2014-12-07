package bs;

public class Pow {
	public static void main(String[] args){
		Pow pp=new Pow();
		
		System.out.println(pp.pow(2,-4));
	}
	public double pow(double x, int n) {
        if(n==0)
            return 1.0;
        if(n==1)
            return x;
        if(n==-1)
        	return 1/x;
        double half=pow(x,n/2);
        if(n%2==0){
            return half*half;
        }else if(n%2==1){
            return half*half*x;
        }else{
        	return half*half*(1/x);
        }
    }
}
