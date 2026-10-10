class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n <= 1) {
            return n == 1 ? 1 : 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            heap.offer(nums[i]);
        }
        int last = heap.poll();
        int sol = 1;
        int max = 1;
        while(!heap.isEmpty()) {
            int curr = heap.poll();
            if(last + 1 == curr) {
                sol++;
            } else if(last != curr){
                sol = 1;
            }
            last = curr;
            max = Math.max(max, sol);
        }

        return max;
    }
}