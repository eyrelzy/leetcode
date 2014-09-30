import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GreyCodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=(int)Math.pow(2.0, 3.0);
		log(a+"");
		log(Arrays.toString(grayCode(3).toArray()));
	}
	public static void log(String s) {
		System.out.println(s);
	}
	public static List<Integer> grayCode(int n) {
		
		if(n==0){
			List<Integer> result = new ArrayList<Integer>();
			result.add(0);
			return result;
		}
		List<Integer> tmp=grayCode(n-1);
		List<Integer> result=new ArrayList<Integer>(tmp);
		int add=1<<(n-1);//not (n-1)*2!!!!!
		//如：A = (1<<2)，1写成二进制就是0000 0001，
		//这个一左移2位就是0000 0100，所以得到的数A为0000 0100，即0x04。
		log("add:"+add+","+(n-1));
		for(int i=tmp.size()-1;i>=0;i--){
			result.add(add + tmp.get(i));
		}
		
		
		return result;
	}

}
