class Solution {
    static HashMap<String , Integer> dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new HashMap<>();
        return rec(0,0,triangle);
    }
    static int rec(int pos , int i , List<List<Integer>> list){
        int n = list.size();
        int nc = -1;
        
        if(pos < n)
            nc = list.get(pos).size();

        if(pos >= n || i >= nc){
            return 0;
        }

        String key = "pos:"+pos+"i:"+i;
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        if(n == pos){
            return Math.min( list.get(pos).get(i) , list.get(pos).get(i+1) );
        }

        int left =  list.get(pos).get(i) + rec(pos+1 , i , list);
        int right = list.get(pos).get(i) + rec(pos+1 , i + 1 , list);

        int ans =  Math.min(left , right);
        dp.put(key , ans);
        return ans;

    }
}