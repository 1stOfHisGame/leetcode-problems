class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxHere = nums[0];
        for(int i=1; i<nums.length; i++){
            maxHere = Math.max(maxHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxHere);
        }
        return maxSoFar;
    }
}
