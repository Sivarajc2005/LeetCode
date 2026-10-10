class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> sol = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            // sort the string 
            String sortStr = sortString(str);
            List<String> data = map.getOrDefault(sortStr, new ArrayList<>());
            data.add(str);
            map.put(sortStr, data);
        }

        for(String str : map.keySet()) {
            sol.add(map.get(str));
        }

        return sol;
    }

    public String sortString(String str) {
        int n = str.length();
        char[] cha = new char[n];
        cha = str.toCharArray();
        Arrays.sort(cha);
        StringBuilder sb = new StringBuilder();
        for(char ch: cha) {
            sb.append(ch);
        }
        return sb.toString();
    }
}