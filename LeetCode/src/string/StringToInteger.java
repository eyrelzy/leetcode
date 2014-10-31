package string;

import util.Util;

public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE+"|"+Integer.MIN_VALUE);
		Util.log(atoi1("-119197303560000"));
//		Util.log(Integer.valueOf("45#5"));
	}
	public static int atoi1(String str){
		long result=0;
		str=str.trim();
		if(str.length()==0)
			return 0;
		char sign=str.charAt(0);
//		System.out.println(sign);
		int index=0;
		boolean flag=false;
		if(sign=='-'){
			flag=true;
			index=1;
		}else if(sign=='+'){
			index=1;
		}else{
			
		}
		while(index<str.length()){
			if(str.charAt(index)<'0'||str.charAt(index)>'9'){
				break;
			}
			result=result*10+str.charAt(index)-'0';
			index++;
		}
		if(flag)
			result=-result;
		if(result>Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if(result<Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int)result;
	}
	
	
	public static int atoi(String str) {
        int max = Integer.MAX_VALUE;
        int min = -Integer.MIN_VALUE;
        long result = 0;
        str = str.trim();
        int len = str.length();
        if (len < 1)
            return 0;
        int start = 0;
        boolean neg = false;
 
        if (str.charAt(start) == '-' || str.charAt(start) == '+') {
            if (str.charAt(start) == '-')
                neg = true;
            start++;
        }
 
        for (int i = start; i < len; i++) {
            char ch = str.charAt(i);
 
            if (ch < '0' || ch > '9')
                break;
            result = 10 * result + (ch - '0');
            if (!neg && result > max)
                return max;
            if (neg && -result < min)
                return min;
 
        }
        if (neg)
            result = -result;
 
        return (int) result;
    }

}
