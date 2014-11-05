package dp;
/**
 * 理解题目的意思真是太重要了，这个就没懂
 * s="rabbbit" t="rabbit"
 * t是s的subsequence，有几种可能
 * Rabbbit 有三种方式包含Rabbit
 * */
public class DistinctSubsequences {
//	private static int disNum=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="rabbbit";
		String t="rabbit";
		System.out.println(numDistinct(s, t));
	}
	//this dfs method leads to TLE
	public static int numDistinct(String s,String t){
		int[] flags=new int[s.length()];
		int num=0;
		int disNum=dfs(num, flags, 0, 0, s, t);
		return disNum;
		
	}
	//quite like the problem "word search"
	//some ideas from backtracing problem, to return back to the original state
	public static int dfs(int num,int[] flags, int indexs, int indext, String s, String t){
		int disNum=0;
		if(num==t.length()){
			disNum++;
			return disNum;
		}
		else{
			for(int i=indexs;i<s.length();i++){
				if(s.charAt(i)==t.charAt(indext)&&flags[i]==0){
					flags[i]=1;
					num++;
					disNum=disNum+dfs(num,flags,i+1,indext+1,s,t);
					flags[i]=0;//below two key steps
					num--;
				}
			}
			
		}
		return disNum;
	}
	//pass all the test cases
	public int numDistinct2(String S, String T) {
        //s: m
        //t: n
        //#rabbit,#rabbbit
        //keep track of the index in rabbit and rabbbit
        int m=S.length()+1;
        int n=T.length()+1;
        int[][] opt=new int[m+1][n+1];
        opt[0][0]=1;
        for(int i=1;i<m;i++){
            opt[i][0]=1;
        }
        for(int j=1;j<n;j++){
            opt[0][j]=0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //i in s matches j in t
                //i could be matched or ignored, just like we have done running rabbbit, we could ignore the last character "b"
                opt[i][j]=(S.charAt(i-1)==T.charAt(j-1))?opt[i-1][j-1]+opt[i-1][j]:opt[i-1][j];
            }
        }
        return opt[m-1][n-1];
    }

}
