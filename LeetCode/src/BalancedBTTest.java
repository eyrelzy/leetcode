import util.TreeNode;

public class BalancedBTTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
TreeNode n1=new TreeNode(0);

n1.left=new TreeNode(1);

n1.left.left=new TreeNode(2);
n1.right=new TreeNode(1);
n1.right.right=new TreeNode(2);
//n1.left.left.left=new TreeNode(3);
log(""+isBalanced(n1));
	}
	public static void log(String s) {
		System.out.println(s);
	}
	public static boolean isBalanced(TreeNode root) {
		if(root==null)
			return true;
		int dif=Math.abs(depth(root.left)-depth(root.right));
		if(dif>1)
			return false;
		return isBalanced(root.left)&&isBalanced(root.right);
	}
	public static int getMaxHeight(TreeNode root){
		if(root==null)
			return 0;
		return Math.max(getMaxHeight(root.left),getMaxHeight(root.right))+1;
	}
	public static int getMinHeight(TreeNode root){
		if(root==null)
			return 0;
		return Math.min(getMaxHeight(root.left),getMaxHeight(root.right))+1;
	}
	private static int depth(TreeNode root){  
        if(root == null){  
            return 0;  
        }  
        return 1 + Math.max(depth(root.left), depth(root.right));  
    }
	
	public boolean isBalanced2(TreeNode root) {
		if (root == null)
			return true;
 
		if (getHeight(root) == -1)
			return false;
 
		return true;
	}
 
	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
 
		int left = getHeight(root.left);
		int right = getHeight(root.right);
 
		if (left == -1 || right == -1)
			return -1;
 
		if (Math.abs(left - right) > 1) {
			return -1;
		}
 
		return Math.max(left, right) + 1;
 
	}

}
