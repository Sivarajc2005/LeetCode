class Solution {
    public double findMaxAverage(int[] nums, int k) {
        Double maxsol = 0.0;
        Double sol = 0.0;
        for(int i = 0; i < k; i++) {
            sol += nums[i];
        }
        maxsol = sol / k;
        // System.out.println(maxsol);
        int st = 0;
        int n = nums.length;
        for(int i = k; i < n; i++) {
            int curr = nums[i];
            int ft = nums[st];
            sol -= ft;
            sol += curr;
            maxsol = Math.max(maxsol, sol / k);
            // System.out.println(maxsol+" curr = "+ (sol / k));
            st++; 
        }
        return maxsol;
    }
}