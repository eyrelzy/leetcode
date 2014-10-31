package string;
/**
 * 类似那个abbbaaaa=1a3b4a but ab!=1a1b
	careercup 的类似问题
 *核心在于理解题意，是输出1,11,21,1211,之后第n个词
 * 
 * **/
public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(countAndSay(3));
	}
public static String countAndSay(int n) {
        
	String ret="";
	String str=String.valueOf(1);
	for(int i=0;i<n-1;i++){
		StringBuilder sb=new StringBuilder();
		int cnt=1;
		for(int j=0;j<str.length();j++){
			char a=str.charAt(j);
			if(j+1<str.length()&&a==str.charAt(j+1)){
				cnt++;
			}
			else{
				sb.append(cnt);
				sb.append(a);
				cnt=1;
			}
		}
		str=sb.toString();
	}
	ret=str;
	
	return ret;
    }

}
