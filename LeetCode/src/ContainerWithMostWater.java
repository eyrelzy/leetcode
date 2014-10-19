import util.Util;

/**
 * it's hard to understand what this problem is the volume of container is the
 * distance between two boards times the height of lower board.
 * 
 * */

// 非常类似求sum consecutive sequence!
public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height={3,2,2,3};
		Util.log(maxArea1(height));
	}
// this dp does not work, cause
	public static int maxArea(int[] height) {
		int max_area=0;
		int dist=1;
		int[] curr_max=new int[height.length];
		
//		curr_max[0]=dist*Math.min(height[0],height[1]);
		curr_max[1]=dist*Math.min(height[0],height[1]);
		max_area=curr_max[1];
		for(int i=2;i<height.length;i++){
//			curr_max[i]=Math.max(Math.min(curr_max[i-1],height[i])*dist,height[i] );
			int min_h=Math.min(height[i-1],height[i]);
			int min_height=Math.min(curr_max[i-1]/dist,min_h);
			System.out.println(min_height+","+dist+","+min_h);
			if(min_height*(dist+1)>min_h){
				dist++;
				curr_max[i]=min_height*dist;
				
			}
			else{
				dist=1;
				curr_max[i]=min_h;
			}
			
			max_area=Math.max(max_area, curr_max[i]);
		}
		return max_area;
	}
	//if left height is lower than right, left++
	//else right--
	//correctness: it is possible to have a bigger area if we use a bigger height
	public static int maxArea1(int[] height){
		 if (height.length <= 1)
	            return 0;
		int max_area=0;
		int i=0,len=height.length,j=len-1,tmp=0;
		while(i<j){
			tmp=Math.min(height[i],height[j])*(j-i);
			max_area=Math.max(max_area,tmp);
			if(height[i]<height[j]){
				i++;
			}
			else{
				j--;
			}
		}
		return max_area;
	}

	 public static int maxArea2(int[] height) {
	        int i, j, lh, rh, area, tmp, len = height.length;

	        lh = height[0];
	        rh = height[len - 1];
	        area = 0;
	        i = 0;
	        j = len - 1;
	        
	        while (i < j) {
	            tmp = Math.min(lh, rh) * (j - i);
	            
	            if (tmp > area) {
	                area = tmp;
	            }
	            
	            if (lh < rh) {
	                while (i < j && height[i] <= lh) {
	                    i ++;
	                }
	                if (i < j) {
	                    lh = height[i];
	                }
	            } else {
	                while (i < j && height[j] <= rh) {
	                    j --;
	                }
	                if (i < j) {
	                    rh = height[j];
	                }
	            }
	        }

	        return area;
	    }
}
