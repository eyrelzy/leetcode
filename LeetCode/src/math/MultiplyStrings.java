package math;

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings ms=new MultiplyStrings();
		String num1="9133";
		String num2="0";
		String ret=ms.multiply(num1, num2);
		System.out.println(ret);
	}

	public String multiply(String num1, String num2) {
		if(num1.equals("0")||num2.equals("0")){
			return "0";
		}
		String ret="";
		int i=0,j=0;
		int carry=0;
		int m=num1.length();
		int n=num2.length();
		int t=0;
		while(t<=m+n-2){
			i=0;
			j=t-i;
			while(j>=m){
				j--;
				i++;
			}
			int mul=0;
			while(i>=0&&j>=0&&i<n&&j<m){
				mul+=(Integer.parseInt(""+num1.charAt(m-1-j)))*(Integer.parseInt(""+num2.charAt(n-1-i)));
				i++;
				j--;
			}
			int digit=(mul+carry)%10;
			ret=digit+ret;
			carry=(mul+carry)/10;
			t++;
		}
		if(carry>0){
			ret=carry+ret;
		}
		return ret;
	}

}
