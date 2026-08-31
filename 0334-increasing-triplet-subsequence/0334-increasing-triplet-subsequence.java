class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int max1, max2;
        max1 = Integer.MAX_VALUE;
        max2 = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            if (curr <= max1) {
                max1 = curr; 
            } else if (curr <= max2) {
                max2 = curr;
            } else {
                return true;
            }
        }
        return false;
    }
}