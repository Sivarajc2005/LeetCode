class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if(len <= 1) {
            return false;
        }
        int last = nums[0];
        for(int i = 1; i< len; i++) {
            int curr = nums[i];
            if(last == curr) {
                return true;
            }
            last = curr;
        }
        return false;
    }
}