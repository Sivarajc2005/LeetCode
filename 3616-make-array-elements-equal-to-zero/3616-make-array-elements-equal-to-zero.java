class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] prefSum = new int[n];
        int[] suffSum = new int[n];
        int preSum = 0;
        int sufSum = 0;
        for(int i = 0 ; i < n ; i++){
            prefSum[i] = preSum;
            suffSum[n-1-i] = sufSum;
            preSum += nums[i];
            sufSum += nums[n-1-i];
        }
        int sol = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0 && prefSum[i] == suffSum[i]){
                sol += 2;
            }
            else if(nums[i] == 0 && Math.abs(prefSum[i] - suffSum[i]) == 1){
                sol += 1;
            }
        }
        // System.out.println(Arrays.toString(prefSum)+" "+Arrays.toString(suffSum));
        return sol;

    }
}