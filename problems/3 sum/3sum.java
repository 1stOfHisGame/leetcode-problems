class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i<nums.length-2; i++){
            int j = i+1;
            int k = nums.length-1;
            if(i<1 || nums[i] != nums[i-1]){
                while(j<k){
                    if(j>i+1 && nums[j] == nums[j-1]){
                        j++;
                        continue;
                    }
                    if(k<nums.length-1 && nums[k] == nums[k+1]){
                        k--;
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[k] == 0){
                        result.add(Arrays.asList(new Integer[]{nums[i],nums[j++],nums[k--]}));
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[k] < 0){
                        j++;
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[k] > 0){
                        k--;
                        continue;
                    }
                }
            }
        }
        return result;
    }
}
