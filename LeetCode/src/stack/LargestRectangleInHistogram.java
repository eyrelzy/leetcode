package stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			LargestRectangleInHistogram lr=new LargestRectangleInHistogram();
			int[] height={0,0,0};
			System.out.println(lr.largestRectangleArea(height));
	}

	class Pair {
		public int height;
		public int width;

		public Pair() {

		}

		public Pair(int height, int width) {
			this.width = width;
			this.height = height;
		}
	}

	public int largestRectangleArea(int[] height) {
		Stack<Pair> stack = new Stack<Pair>();
		int pre = 0, post = 1;
		int max_area = 0;
		stack.push(new Pair(height[pre], 1));
		int left=0;
		while (post < height.length) {
			Pair top = stack.peek();
			if (height[post] > top.height) {
				stack.push(new Pair(height[post], 1+left));
				left=0;
			} else if (height[post] == top.height) {
				top.width++;
			} else {
				int area = top.height * top.width;
				max_area = Math.max(max_area, area);
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(new Pair(height[post], 1 + top.width));
				} else {
					stack.peek().width += top.width;
					if(height[post]>stack.peek().height){
						left=top.width;
					}
					post--;
				}

			}
			post++;
		}
		int cnt=1;
		while (!stack.isEmpty()) {
			Pair top = stack.pop();
			int area = top.height * top.width;
			max_area = Math.max(max_area, area);
			if (!stack.isEmpty()) {
				stack.peek().width += cnt;
			} else {
				break;
			}
			cnt++;
		}
		return max_area;
	}
	//this is quite similar to tapping rain water!!!!
}
