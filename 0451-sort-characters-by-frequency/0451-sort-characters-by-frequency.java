class Solution {
    public String frequencySort(String s) {
        int[][] map = new int[128][2];
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int temp = map[ch][1];
            map[ch][0] = ch;
            map[ch][1] = temp+1;
        }
        Arrays.sort(map, (a,b) -> {
            if(a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        StringBuilder sol = new StringBuilder();
        for(int i = map.length - 1; i > 0; i--) {
            if(map[i][0] == 0) {
                return sol.toString();
            }
            char temp = (char) map[i][0];
            for(int j = 0; j < map[i][1]; j++) {
                sol.append(temp);
            }
        }
        return sol.toString();
    }
}