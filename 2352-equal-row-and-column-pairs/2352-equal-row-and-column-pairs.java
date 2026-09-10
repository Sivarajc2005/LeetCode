class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = grid.length;
        int sol = 0;
        for(int i = 0; i < n; i++) {
            int curr = grid[0][i];
            List<Integer> lis = new ArrayList<>();
            if(map.containsKey(curr)) {
                lis = map.get(curr);
            }
            lis.add(i);
            map.put(curr, lis);
        }
        System.out.println(map);
        for(int i = 0; i < n; i++) {
            int curr = grid[i][0];
            if(map.containsKey(curr)) {
                // System.out.println("fount match: "+ curr);
                List<Integer> lis = map.get(curr);
               
                for(int pos: lis) {
                    boolean check = true;
                    // System.out.println("  running matches places: "+ pos);
                    for(int k = 0; k < n; k++) {
                        int hor = grid[k][pos];
                        int ver = grid[i][k];
                        if(hor != ver) {
                            // System.out.prinltn()
                            check = false;
                            break;
                        }
                    }
                    if(check) {
                        sol++;
                    }
                }
            }
        }

        return sol;
    }
}