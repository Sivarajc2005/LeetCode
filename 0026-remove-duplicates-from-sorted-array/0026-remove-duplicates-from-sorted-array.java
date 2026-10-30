class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int st = 0;
        int last = nums[0];
        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            if(last != curr) {
                nums[st++] = last;
            } 

            if(i == n-1) {
                nums[st++] = curr;
            }
            last = curr;
        }
        return st;
    }
}