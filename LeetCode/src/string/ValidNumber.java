package string;
//ask for requirements, this is for testers to consider all the cases.
// String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";  
public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test1="1e";
		System.out.println(isNumber(test1));
		String test2="   0.2.4";
		System.out.println(isNumber(test2));
	}
	public static boolean isNumber(String s){
		//start with 0
		s=s.trim();
		boolean zero=false;
		boolean dot=false;
		char[] arr=s.toCharArray();
		for(int i=0;i<s.length();i++){
			char c=arr[i];
//			System.out.println(c);
			if(c=='0'){
				
				if(i==0&&i+1<s.length()){
					char next=s.charAt(i+1);
					if(next!='.')
						return false;
					else{
						if(s.length()==2)
							return false;
					}
				}
				zero=true;
			}else if(c-'0'<=9&&c-'0'>=1){
			}else if(c=='.'){
				if(dot){
					return false;
				}
				if(s.length()==1)
					return false;
				dot=true;
			}else{
				
				return false;
			}
		}
		return true;
	}

}
