class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, candies[i]);
        }
        List<Boolean> sol = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int val = candies[i] + extraCandies;
            sol.add(val >= max);
        }
        return sol;
    }
}