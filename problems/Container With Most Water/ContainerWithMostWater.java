package leetcode;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {

		// will store the max area here
		int maxArea = 0;

		int i = 0, j = height.length-1;
		while(i<j) {
			
			// pick the small one in the pair to be the length
			int l = height[i] < height[j] ? height[i] : height[j];
			
			// breadth would be the distance between the position of two entries
			int b = j-i;
			
			// check if the area is greater than previously calculated one...
			if(maxArea < l*b)
				maxArea = l*b; //...if yes the assign it as new area;
			
			// since we're decreasing window size by 1, we'll shift that endpoint which has not given us good area
			if(height[i] < height[j]) {
				i++;
			}
			else j--;
		}
		
		return maxArea;
		
	}

	public static void main(String args[]) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(new ContainerWithMostWater().maxArea(height));
	}
}
