class Solution { 
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] != 0 ? prefix[i-1] * nums[i] : nums[i];
            int last = n - 1 - i;
            // System.out.println("i: "+ i + " last: "+ last);
            suffix[last] = suffix[last + 1] != 0 ? suffix[last + 1] * nums[last] : nums[last];
            // System.out.println("suffix: "+ suffix[last + 1] * nums[i]);
        }

        // print(prefix);
        // print(suffix);

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            int tempMax = Math.max(prefix[i], Math.max(suffix[i], curr));
            max = Math.max(tempMax, max);
        }

        return max;
    }

    public void print(int[] arr) {
        for(int ele : arr) {
            System.out.print(ele + " -> ");
        }
        System.out.println("End");
    }
}