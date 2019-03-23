class Solution {
    public int sum(int l, int u, int[] nums){
        if(l == u){
            return nums[l];
        }
        if(l<u){
            int m = (l+u)/2;
            int left = sum(l,m,nums);
            int right = sum(m+1,u,nums);
            int sum = 0;
            int leftMidSum = Integer.MIN_VALUE;
            for(int i=m; i>=l; i--){
                sum+=nums[i];
                leftMidSum = Math.max(leftMidSum, sum);
            }
            sum = 0;
            int rightMidSum = Integer.MIN_VALUE;
            for(int i=m+1; i<=u; i++){
                sum+=nums[i];
                rightMidSum = Math.max(rightMidSum, sum);
            }
            //System.out.println(l+" "+u+" "+Math.max(Math.max(left,right), leftMidSum+rightMidSum));
            return Math.max(Math.max(left,right), leftMidSum+rightMidSum);
        }
        return 0;
    }
    
    public int maxSubArray(int[] nums) {
        return sum(0,nums.length-1,nums);
    }
}
