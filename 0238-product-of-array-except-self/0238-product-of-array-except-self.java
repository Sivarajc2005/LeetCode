class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            int sufind = n - 1 - i;
            int last = nums[sufind];
            if(i == 0) {
                prefix[i] = curr;
                suffix[n - 1 - i] = last;
            } else {
                prefix[i] = prefix[i - 1] * curr;
                suffix[sufind] = last * suffix[sufind + 1];
            }
        }
        int[] sol = new int[n];
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                sol[i] = suffix[i + 1];
            } else if(i == n-1) {
                sol[i] = prefix[i - 1];
            } else {
                sol[i] = suffix[i + 1] * prefix[i - 1];
            }
        }
        return sol;
    }
}