class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        List<Integer> lis1 = new ArrayList<>();
        List<Integer> lis2 = new ArrayList<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i = 0; i < nums2.length; i++) {
            int curr = nums2[i];
            if(!set.contains(curr) && !set2.contains(curr)) {
                lis2.add(curr);
                set2.add(curr);
            }
        }

        set.clear();
        for(int i = 0; i < nums2.length; i++) {
            int curr = nums2[i];
            set.add(curr);
        }
        
        set2.clear();
        for(int i = 0; i < nums1.length; i++) {
            int curr = nums1[i];
            if(!set.contains(curr) && !set2.contains(curr)) {
                lis1.add(curr);
                set2.add(curr);
            }
        }
        List<List<Integer>> sol = new ArrayList<>();
        sol.add(lis1);
        sol.add(lis2);
        return sol;
    }
}