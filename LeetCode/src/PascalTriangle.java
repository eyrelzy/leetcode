import java.util.ArrayList;
import java.util.List;
// similar to subset
public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> arr = generate(5);
		log(arr);
	}

	public static void log(List<List<Integer>> arr) {
		for (int i = 0; i < arr.size(); i++) {
			for(int j=0;j<arr.get(i).size();j++){
				System.out.println(arr.get(i).get(j));
			}
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
}
