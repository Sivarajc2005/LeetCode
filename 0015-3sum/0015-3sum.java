class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        int n = nums.length;

        // sort numbers 
        Arrays.sort(nums);

        for(int i = 0; i < n - 2; i++) {
            // current value 
            int curr = nums[i];

            // next ele and last ele
            int iplus = i+1;
            int lastind = n-1;

            int next = nums[iplus];

            // while(next == curr && iplus < n) {
            //     next = nums[iplus];
            //     iplus++;
            // }

            while(iplus < lastind) {
                next = nums[iplus];
                int last = nums[lastind];

                int sum = curr + next + last;

                if(sum > 0) {
                    lastind--;
                    while(lastind > i && nums[lastind] == nums[lastind + 1]) {
                        lastind--;
                    }
                } else if (sum < 0) {
                    iplus++;
                    while(iplus < n && nums[iplus] == nums[iplus - 1]) {
                        iplus++;
                    }
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(curr);
                    temp.add(next);
                    temp.add(last);
                    sol.add(temp);

                    iplus++;
                    while(iplus < n && nums[iplus] == nums[iplus - 1]) {
                        iplus++;
                    }
                }
            }

            while( i < n - 1 && nums[i] == nums[i+1]) {
                i++;
            }
            
        }

        return sol;
    }
}