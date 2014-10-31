package string;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("101", "001"));
	}

	public static String addBinary(String a, String b) {
		StringBuffer sb = new StringBuffer();
		int dist = Math.abs(a.length() - b.length());
		for (int k = 0; k < dist; k++) {
			if (a.length() - b.length()<0) {
				a = "0" + a;
			} else {
				b = "0" + b;
			}
		}
		int len = a.length() - 1;
		int flag = 0;
		while (len >= 0) {

			int i = a.charAt(len) - '0';
			int j = b.charAt(len) - '0';
			int sum = i + j + flag;
			if (sum == 2) {
				flag = 1;
				sb.insert(0, '0');
			} else if (sum == 1) {
				flag = 0;
				sb.insert(0, '1');
			} else if (sum == 0) {
				flag = 0;
				sb.insert(0, '0');
			} else if (sum == 3) {
				sb.insert(0, '1');
				flag = 1;
			}
			len--;
		}
		if (flag == 1) {
			sb.insert(0, '1');
		}
		return sb.toString();
	}
	//simple and concise
	public String addBinary1(String a, String b) {
	    int m = a.length();
	    int n = b.length();
	    int carry = 0;
	    String res = "";
	    // the final length of the result depends on the bigger length between a and b, 
	    // (also the value of carry, if carry = 1, add "1" at the head of result, otherwise)
	    int maxLen = Math.max(m, n);
	    for (int i = 0; i < maxLen; i++) {
	        // start from last char of a and b
	        // notice that left side is int and right side is char
	        // so we need to  minus the decimal value of '0'
	        int p=0,q=0;
	        if(i<m)
	            p = a.charAt(m-1-i) - '0';
	        else
	            p = 0;
	        
	        if(i<n)
	            q = b.charAt(n-1-i)-'0';
	        else
	            q = 0;
	            
	        int tmp = p + q + carry;
	        carry = tmp / 2;
	        res += tmp % 2;
	    }
	    return (carry == 0) ? res : "1" + res;
	    }

}
