class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int st = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != st){
                break;
            }
            st++;
        }
        return st;
    }
}