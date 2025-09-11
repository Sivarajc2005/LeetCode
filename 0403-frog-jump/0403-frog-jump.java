class Solution { 
    static HashMap<String , Boolean> dp ;
    static HashMap<Integer , Integer> map; // to store the stones
    public boolean canCross(int[] stones) {
        map = new HashMap<>();
        for(int i = 0 ; i < stones.length; i++){
            map.put( stones[i] , i);
        }
        dp = new HashMap<>();
 
        return rec(1 , stones , 1 , 1 ); 
    } 
    static boolean rec(int pos , int[] stones , int curr , int step){
        if(pos >= stones.length){
            return true; 
        } 
        if(stones[pos] <= curr){ 
            if(map.containsKey(curr)){
                pos = map.get(curr);
            }
            else{
                return false;
            }
        } else if(stones[pos] > curr){ 
            return false; 
        } 

        if(dp.containsKey("pos"+pos+"steps"+step)){
            return dp.get("pos"+pos+"steps"+step);
        }
        
        int[] vis = {-1 , 0 , 1}; 
        boolean che = false; 

        for(int i = 0 ; i < vis.length ; i++){ 
            int move = step + vis[i]; 
            che = che || rec( pos + 1 , stones , curr + move , move ); 
        } 
        // arr[pos] = che == true ? 1 : 0;
        String key = "pos"+pos+"steps"+step; 
        dp.put(key , che);
        return che; 
        } 
    }