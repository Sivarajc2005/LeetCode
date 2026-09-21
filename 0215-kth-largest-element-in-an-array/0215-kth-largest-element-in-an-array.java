class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            queue.add(ele);
        }

        int lastele = 0;

        if(k == 1) {
            return queue.poll();
        }

        while(k != 1) {
            // if(lastele != queue.peek()) {
            //     k--;
            //     lastele = queue.peek();
            //     System.out.println("k: "+ k+ " lastele: "+ lastele);
            // }
            k--;
            queue.poll();
        }

        return queue.peek();
    }
}