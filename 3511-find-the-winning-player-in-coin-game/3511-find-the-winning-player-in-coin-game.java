class Solution {
    public String winningPlayer(int x, int y) {
        boolean alice  = true;
        while(x >= 1 && y >= 4){
            x -= 1;
            y -= 4;
            alice = !alice;
        }
        if(!alice){
            return "Alice";
        }
        return "Bob";
    }
}