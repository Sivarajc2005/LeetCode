class Solution {

    // it's a graph problem 
    public int findCircleNum(int[][] cities) {
        // what can we do. iterate on one by one
        // solve using the BFS
        // we travel and mark the please we visit if any unvisited places available then we add on sol.

        // hear we got the number of cities
        int nCity = cities.length;

        // travel marker
        boolean[] marker = new boolean[nCity];
        int sol = 0;
        //we start travel.
        for(int i = 0; i < nCity; i++) {
            if(marker[i] == true) {
                continue;
            }
            marker = visitor(cities, marker, i, nCity);
            if(!check(marker)) {
                sol++;
            }
        }

        return sol + 1;
    }

    public boolean check(boolean[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(!arr[i]) {
                // System.out.println("room not visited: "+ i);
                return false;
            }
        }
        return true;
    }

    public boolean[] visitor(int[][] cities, boolean[] map, int currCity, int totalCity) {
        if(map[currCity]) {
            return map;
        }
        // print("Current City Viited: "+ currCity);
        map[currCity] = true;
        for(int i = 0; i < totalCity; i++) {
            if( !map[i] && cities[currCity][i] == 1) {
                // print("We Start Travelling: "+ i);
                // map[i] = true;
                visitor(cities, map, i, totalCity);
            }
        }

        return map;
    } 

    public void print(String str) {
        System.out.println(str);
    }
}