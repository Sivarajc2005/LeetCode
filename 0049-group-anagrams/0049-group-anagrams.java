class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String , List<String>> map = new HashMap<>();
        int n = strs.length;
        for(int i = 0 ; i < n ; i++){
            String str = sortString(strs[i]);

            if(map.containsKey(str)){
                List<String> temlist = map.get(str);
                temlist.add(strs[i]);
                map.put(str , temlist);
            }
            else{
                List<String> templist = new ArrayList<>();
                templist.add(strs[i]);
                map.put(str , templist );
            }
        }

        List<List<String>> list = new ArrayList<>();

        for(String key : map.keySet()){
            list.add(map.get(key));
        }

        return list;
    }

    static String sortString(String str){
        char[] carr =str.toCharArray();
        Arrays.sort(carr);
        return String.valueOf(carr);
    }
}