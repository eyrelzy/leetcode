import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// similar to subset
public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<List<Integer>> arr = generate(5);
//		log(arr);
		List<Integer> ret=getRow(3);
		log1(ret);
	}

	public static void log(List<List<Integer>> arr) {
		for (int i = 0; i < arr.size(); i++) {
			for(int j=0;j<arr.get(i).size();j++){
				System.out.println(arr.get(i).get(j));
			}
		}
	}
	public static void log1(List<Integer> arr) {
			for(int j=0;j<arr.size();j++){
				System.out.println(arr.get(j));
			}
	}

	public static List<List<Integer>> generate(int numRows) {

		if (numRows == 0){
			List<List<Integer>> ret = new ArrayList<List<Integer>>();
			return ret;
		}
		if (numRows == 1) {
			List<List<Integer>> ret = new ArrayList<List<Integer>>();
			List<Integer> a = new ArrayList<Integer>();
			a.add(1);
			ret.add(a);
			return ret;
		}
		// if(numRows==2){
		// List<Integer> a=new ArrayList<Integer>();
		// a.add(1);
		// a.add(1);
		// ret.add(a);
		// return ret;
		// }
		List<List<Integer>> subret = generate(numRows - 1);
		int size = subret.size();
		List<Integer> lastfloor = subret.get(size - 1);
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		if (numRows > 2) {
			for (int i = 1; i < lastfloor.size(); i++) {
				a.add(lastfloor.get(i - 1) + lastfloor.get(i));
			}
		}
		a.add(1);
		subret.add(a);
		return subret;
	}

	
	
	//pascal triangle problem ii
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> last=new LinkedList<Integer>();
		last.add(0);
		last.add(1);
		last.add(0);
		for(int i=1; i<=rowIndex;i++){
			List<Integer> sub=new LinkedList<Integer>();
			sub.add(0);
			for(int j=0;j<last.size()-1;j++){
				sub.add(last.get(j)+last.get(j+1));
			}
			sub.add(0);
			last=sub;
//			last=new LinkedList<Integer>(sub);
		}
		last.remove(0);
		last.remove(last.size()-1);
		return last;
	}
	//save more space
	
	public ArrayList<Integer> getRow1(int rowIndex) {  
	    ArrayList<Integer> res = new ArrayList<Integer>();  
	    if(rowIndex<0)  
	        return res;  
	    res.add(1);  
	    for(int i=1;i<=rowIndex;i++)  
	    {  
	    	//从后向前set的方式很有意思
	        for(int j=res.size()-2;j>=0;j--)  
	        {  
	            res.set(j+1,res.get(j)+res.get(j+1));  
	        }  
	        res.add(1);  
	    }  
	    return res;  
	}  
}
