class Solution {
    public void moveZeroes(int[] nums) {
        int ind = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            if(curr != 0) {
                nums[ind++] = curr;
            }
        }
        for(int i = ind; i < n; i++) {
            nums[ind++] = 0;
        }
    }
}