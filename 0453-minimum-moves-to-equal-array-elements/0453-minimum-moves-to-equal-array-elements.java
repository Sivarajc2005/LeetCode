class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = nums[0];
        int n = nums.length;
        for(int val : nums){
            sum += val;
            min = Math.min(min , val);
        }

        return sum - (min * n);

    }
}