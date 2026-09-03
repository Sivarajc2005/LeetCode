class Solution {
    public int longestOnes(int[] nums, int k) {
        int st  = 0;
        int flip = 0;
        int n = nums.length;
        int sol = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            if(curr == 1) {
                sol++;
            } else {
                if(k == 0) {
                    sol = 0;
                    continue;
                }
                if(flip >= k) {
                    for(int j = st; j < i; j++) {
                        int old = nums[j];
                        if(old == 0) {
                            st = j + 1;
                            sol--;
                            flip--;
                            break;
                        }
                        sol--;
                    }
                }
                if(flip <= k) {
                    flip++;
                    sol++;
                }
            }
            max = Math.max(max, sol);
        }
        return max;
    }
}