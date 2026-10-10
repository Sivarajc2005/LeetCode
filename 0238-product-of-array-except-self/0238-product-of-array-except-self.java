class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = nums[0];
        suf[n-1] = nums[n-1];

        for(int i = 1; i < n; i++) {
            int preInd = i;
            int sufInd = n -1 - i;
            pre[preInd] = nums[preInd] * pre[preInd - 1];
            suf[sufInd] = nums[sufInd] * suf[sufInd + 1];
        }
        int[] sol = new int[n];
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                sol[i] = suf[1];
            } else if (i == n-1) {
                sol[i] = pre[i-1];
            } else {
                sol[i] = pre[i-1] * suf[i+1];
            }
        }
        return sol;
    }
}