class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int st = 0;
        int n = nums.length;
        int end = n-1;
        int[] sol = new int[n];
        int stind = 0;
        int endind = n -1;

        while(st < n && end > -1) {
            int first = nums[st];
            int last = nums[end];

            if(first < pivot) {
                sol[stind] = first;
                stind++;
            }

            if (last > pivot) {
                sol[endind] = last;
                endind--;
            }
            st++;
            end--;
        }

        for(int i = stind; i <= endind; i++) {
            sol[i] = pivot;
        }
        return sol;
    }
}