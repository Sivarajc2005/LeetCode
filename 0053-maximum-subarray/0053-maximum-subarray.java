class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int tempMax = 0;

        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            tempMax += curr;
            max = Math.max(max, tempMax);
            if(tempMax < 0) {
                tempMax = 0;
            }
        }

        return max;
    }
}