class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb  = new StringBuilder();
        sb.append("a");

        while(sb.length() < k){
            StringBuilder temp = new StringBuilder();
            for(int i = 0 ;i < sb.length() ; i++){
                int achi = sb.charAt(i);
                char newch = (char) (achi+1);
                temp.append(newch);
            }
            sb.append(temp.toString());
        }

        return sb.charAt(k-1);
    }
}