class Solution {
    public int minBitFlips(int st, int go) {
        if(st == go){
            return 0;
        }

        int c = 0;
        // int i = 0;
        if( (st & 1) != (go & 1) ){
            c++;
        }
        while(st >= 1 || go >= 1){
            if( ( (st >> 1) & 1 ) != ( (go >> 1) & 1 ) ){
                c++;
            }
            // System.out.println(st+" -> " + Integer.toBinaryString(st));
            // System.out.println(go+" -> " + Integer.toBinaryString(go));
            // System.out.println("count : -> " + c +"\n");
            
            // i++;
            
            st = st >> 1;
            go = go >> 1;
        }
        return c;
    }
}