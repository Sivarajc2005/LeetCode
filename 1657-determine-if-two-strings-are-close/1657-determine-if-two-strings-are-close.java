class Solution {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < word1.length(); i++) {
            char ch = word1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        for(int i  = 0; i < word2.length(); i++) {
            char ch = word2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        List<Integer> lis1 = new ArrayList<>();
        List<Integer> lis2 = new ArrayList<>();

        for(char i : map1.keySet()) {
            lis1.add(map1.get(i));
        }

        for(char i : map2.keySet()) {
            lis2.add(map2.get(i));
            if(!map1.containsKey(i)) {
                return false;
            }
        } 

        if(lis1.size() != lis2.size()) {
            // System.out.println(lis1);
            // System.out.println(lis2);
            return false;
        }

        Collections.sort(lis1);
        Collections.sort(lis2);

        System.out.println(lis1);
        System.out.println(lis2);

        // for(int i = 0; i < lis1.size(); i++) {
        //     if(lis1.get(i) != lis2.get(i)) {
        //         return false;
        //     }
        // }
        
        return lis1.equals(lis2);
    }
}