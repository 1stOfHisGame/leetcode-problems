package leetcode;

public class TrappingRainWater {

	public int trap(int[] height) {
		// for saving how many units of water filled
		int waterUnitsFilled = 0;
		
		// for saving the level of water that we have already scoped out and added to units filled
		int levelScoped = 0;
		
		// i is left most and j is right most position of our endpoints
		int i = 0, j = height.length-1;
		
		// iterating over end points
		while(i<j) {
			// minimum level upto which water could be filled for endpoints i and j
			int minLevel = height[i] < height[j] ? height[i] : height[j];
			
			// if the minimum level between the two endpoints is not already scoped and included...
			if(minLevel > levelScoped) {
				for(int k=i+1; k<j; k++) { //...then look for all gaps between the two endpoints
					int waterTrapped = minLevel - height[k]; //...this would be the water actually trapped at this this position
					if(waterTrapped > 0) { //...if no water trapped then ignore this postion...
						if(levelScoped > height[k]) // ...otherwise we'll check if units in our trapped water are already scoped out...
							waterTrapped = waterTrapped - (levelScoped - height[k]); //...and eliminate the scoped out units
						waterUnitsFilled += waterTrapped; // lastly add the tallied units
					}
				}
				// update scoped level
				levelScoped = minLevel;
			}
			
			// shift one of the endpoints; one that's shorter
			if(height[i] < height[j]) 
				i++;
			else j--;			
		}
		
		return waterUnitsFilled;
	}

	public static void main(String args[]) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new TrappingRainWater().trap(height));
	}
}
