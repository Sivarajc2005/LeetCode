class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int sol = 0;
        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            int need = k - curr;
            
            if(map.containsKey(need)) {
                if(map.get(need) != 0) {
                    map.put(need, map.get(need) - 1);
                    map.put(curr, map.getOrDefault(curr, 0) - 1);
                    sol++;
                }
            }

            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return sol;
    }
}