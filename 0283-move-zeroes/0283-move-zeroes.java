class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int ind = 0;
        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            if(curr != 0) {
                nums[ind++] = curr;
            }
        }
        for(int i = ind; i < n; i++) {
            nums[i] = 0;
        }
    }
}