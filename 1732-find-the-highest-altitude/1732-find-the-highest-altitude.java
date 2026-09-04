class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int n = gain.length;
        int cal = 0;
        for(int i = 0; i < n; i++) {
            int curr = gain[i];
            cal += curr;
            // System.out.println("curr: "+ curr+ " total: "+ cal);
            max = Math.max(max, cal);
        }
        return max;
    }
}