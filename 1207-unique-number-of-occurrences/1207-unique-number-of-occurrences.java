class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int curr = arr[i];
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        
        HashSet<Integer> set = new HashSet<>();

        for(int key : map.keySet()) {
            if(set.contains(map.get(key))) {
                return false;
            }
            set.add(map.get(key));
        }
        return true;
    }
}