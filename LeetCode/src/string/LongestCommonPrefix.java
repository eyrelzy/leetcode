package string;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs={"aab","aabcc","aabce"};
		System.out.println(longestCommonPrefix(strs));
	}
	//两层循环的跳出 啊哈哈哈哈
	//O(n*shortest_len
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length==0)
			return "";
		if(strs.length==1)
			return strs[0];
        int min_len=strs[0].length();
        for(int i=1;i<strs.length;i++){
            min_len=Math.min(min_len, strs[i].length());
        }
        int k=0;
        boolean flag=false;
        for(int j=0;j<min_len;j++){
        	char prefix=strs[0].charAt(j);
        	for(int i=1;i<strs.length;i++){
        		if(strs[i].charAt(j)!=prefix)
        		{
        			k=j;
        			return strs[i].substring(0,k);
        		}
        	}
        }
        if(!flag)
        	k=min_len;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<k;i++){
        	sb.append(strs[0].charAt(i)+"");
        }
        return sb.toString();
        
    }

}
