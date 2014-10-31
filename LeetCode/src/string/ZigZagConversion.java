package string;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String test="PAYPALISHIRING";
System.out.println(convert(test,4));
	}
	public static String convert(String s, int nRows) {
        String ret="";
        if(s == null || s.length()==0 || nRows <=0)  
            return ret;  
        if(nRows == 1)  
            return s;
        int dist=2*nRows-2;
        for(int i=0;i<nRows;i++){
            for(int j=i;j<s.length();j+=dist){
            	ret=ret+s.charAt(j);
            	//not first or last line
            	if(i!=0&&i!=nRows-1&&j+dist-2*i<s.length())
            		ret=ret+s.charAt(j+dist-2*i);
            }
        }
        return ret;
    }
}
