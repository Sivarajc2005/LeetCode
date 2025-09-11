class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> list = new ArrayList<>();

        String vol = "AEIOUaeiou";
        for(int i = 0 ; i < s.length() ; i++){
            if(vol.indexOf(s.charAt(i)) != -1)
                list.add(s.charAt(i));
        }

        Collections.sort(list);
        int ind = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(vol.indexOf(ch) != -1){
                sb.setCharAt(i , list.get(ind++));
            }
        }

        return sb.toString();
    }
}