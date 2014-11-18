package backtrack;

public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence ps=new PermutationSequence();
		String ret=ps.getPermutation(3, 3);
		System.out.println(ret);
	}
private int cnt=0;
	public String getPermutation(int n, int k) {
		StringBuffer sb=new StringBuffer();
		helper(sb, 1, k, n);
		System.out.println(sb);
		return sb.toString();
	}
	public void helper(StringBuffer sb, int start, int k, int n){
		if(start==n+1){
			cnt++;
			
			System.out.println(sb+","+cnt);
			if(cnt==k){
				System.out.println(sb+","+cnt);
				return;
			}
		}
		for(int i=start;i<=n;i++){
			sb.append(i);
			helper(sb, start+1, k, n);
			sb.deleteCharAt(sb.length()-1);
		}
	}

}
