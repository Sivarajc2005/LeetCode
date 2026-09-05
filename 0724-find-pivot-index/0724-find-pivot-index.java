class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }
        int[] pre = new int[n];
        int[] suf = new int[n];

        pre[0] = nums[0];
        suf[n - 1] = nums[n - 1];

        for(int i = 1; i < n; i++) {
            int curr = nums[i];
            int las = nums[n - i - 1];
            pre[i] = curr + pre[i - 1];
            suf[n - i - 1] = las + suf[n - i]; 
        }

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                if(suf[i + 1] == 0) {
                    return i;
                }
            } else if(i == n -1) {
                if(pre[i - 1] == 0) {
                    return i;
                }
            } else if(pre[i - 1] == suf[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}