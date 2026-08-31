class Solution {
    public boolean increasingTriplet(int[] nums) {
        int max, min, n;
        max = min = nums[0];
        n = nums.length;
        if(n < 3) {
            return false;
        }
    
        int count = 0;
        for(int i = 1; i < n ; i++) {
            int curr = nums[i];
            if(curr > min && curr > max) {
                count++;
                max = curr;
            } else if (curr < min) {
                min = curr;
            } else if (curr > min) {
                max = curr;
                count = 1;
            }
            if (count == 2) {
                return true;
            }
        }
        if (count >= 2) {
            return true;
        }
        return false;
    }
}