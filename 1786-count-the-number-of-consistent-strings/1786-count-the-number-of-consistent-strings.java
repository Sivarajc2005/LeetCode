class Solution {
    public int countConsistentStrings(String allow, String[] words) {
        HashSet<Character> set = new HashSet<>();

        for(int i = 0 ; i < allow.length() ; i++){
            set.add(allow.charAt(i));
        }
        int ans = 0;
        for(String str : words){
            boolean che = false;
            for(int i = 0 ; i < str.length() ; i++){
                if(!set.contains(str.charAt(i))){
                    che  = true;
                    break;
                }
            }
            if(!che){
                ans++;
            }
        }

        return ans;
    }
}