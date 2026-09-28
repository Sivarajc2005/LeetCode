class Solution {
    public int minReorder(int n, int[][] connections) {
        // int n = connections.length;
        boolean[] visit = new boolean[n];
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        map = rec(connections.length, connections);
        // for(int key: map.keySet()) {
        //     List<int[]> list = map.get(key);
        //     for(int[] sol: list) {
        //         System.out.print(Arrays.toString(sol) + " -> ");
        //     }
        //     System.out.println("Key: "+ key);
        // }
        // System.out.println(Arrays.toString(visit));
        int sol = 0;
        Queue<Integer> queue = new LinkedList<>();
        visit[0] = true;

        for(int[] val: map.get(0)) {
            int[] curr = val;
            queue.offer(curr[0]);
            if(curr[1] == 1) {
                sol++;
            }
        }

        while(!queue.isEmpty()) {
            // take a ele
            int curr = queue.poll();

            // check is visited, them move next
            if(visit[curr]) {
                continue;
            }

            visit[curr] = true;
            // not visited add its childs to que
            for(int[] val: map.get(curr)) {
                // System.out.println("curr: "+ val[0]);
                if(!visit[val[0]]) {
                    queue.offer(val[0]);
                    if(val[1] == 1) {
                        sol++;
                    }
                }
            }
        }
        return sol;
    }

    // convert to clear map.
    public HashMap<Integer, List<int[]>> rec(int n, int[][] connections) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int[] curr = connections[i];
            int from = curr[0];
            int to = curr[1];

            // save exixting data's
            List<int[]> fromStore = new ArrayList<>();
            if(map.containsKey(from)) {
                fromStore = map.get(from);
            } 

            List<int[]> toStore = new ArrayList<>();
            if(map.containsKey(to)) {
                toStore = map.get(to);
            }


            // prepare new one
            int[] fromData = { to, 1 };
            int[] toData =  { from, 0};

            fromStore.add(fromData);
            toStore.add(toData);

            // update map
            map.put(from, fromStore);
            map.put(to, toStore);
        }

        return map;
    }
}