class Solution {

    // from input we saw they are not sorted 
    public int[][] merge(int[][] intervals) {
        //sort the input with respect to 1'st and 2'nd need to be smaller
        // we get get [1,6][1,2] into [1,2][1,6] like proper way to follow similar rule 

        // sorting 
        Arrays.sort(intervals, Comparator.comparingInt((int[] row) -> row[0]).thenComparingInt(row -> row[1]));

        int n = intervals.length;

        if(n <= 1) {
            return intervals;
        }
        // for(int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(intervals[i]));
        // }

        // new do our work 

        List<int[]> sol = new ArrayList<>();
        int i = 0;
        while( i < n - 1) {
            int[] curr = intervals[i];
            int next = i + 1;
            while(next < n && curr[1] >= intervals[next][0]) {
                curr[1] = Math.max(intervals[next][1], curr[1]);
                next++;
            }
            i = next;
            sol.add(curr);

            if(i == n - 1) {
                sol.add(intervals[n-1]);
            }

            // print("after process we have "+ curr[0] + ", "+ curr[1] + " i: "+ i );
        }

        int sollen = sol.size();

        int[][] ans = new int[sollen][2];

        for(int j = 0; j < sollen; j++) {
            ans[j] = sol.get(j);
        }

        return ans;
    }

    public void print(String str) {
        System.out.println(str);
    }
}