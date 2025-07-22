class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n+1];
        int[][] rang = new int[n+1][2];

        for(int i=0 ; i < ranges.length ; i++){
            int st = i - ranges[i];
            int en = i + ranges[i];
            rang[i][0] = st;
            rang[i][1] = en;
        }

        Arrays.sort(rang , (a,b)-> Integer.compare(a[0],b[0]));
        // for(int[] ar : rang){
        //     System.out.print(Arrays.toString(ar)+" ");
        // }
        
        int rs = 0;
        int re = 0;
        int c = 0; 
        while(rs < n){
            // System.out.println(" loop start with rs -> "+rs);
            for(int i = 0 ; i < n+1 ; i++){
                if(rs >= rang[i][0]){
                    // System.out.println(rang[i][0] + " -> " + rang[i][1]);
                    re = Math.max(rang[i][1] , re);
                }
            }
            if(re == rs){ //if new update not happen then some area is not filled
                return -1;
            }
            rs = re;
            c++;

            // System.out.println("end val rs => " + rs);
        }

        return c;
    }
}