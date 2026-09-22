class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        int no_rooms = rooms.size();
        if(no_rooms == 1) {
            return true;
        }   
        boolean[] visitor = new boolean[no_rooms];
        for(int i = 0; i < rooms.get(0).size(); i++) {
            int key = rooms.get(0).get(i);
            queue.offer(key);
        }
        visitor[0] = true;

        while(!queue.isEmpty()) {
            int roomKey = queue.poll();
            if(visitor[roomKey] == true) {
                continue;
            }
            for(int i = 0; i < rooms.get(roomKey).size(); i++) {
                int key = rooms.get(roomKey).get(i);
                queue.offer(key);
            }
            visitor[roomKey] = true;
        }

        for(int i = 0; i < no_rooms; i++) {
            if(visitor[i] == false) {
                return false;
            }
        } 

        return true;
    }
}