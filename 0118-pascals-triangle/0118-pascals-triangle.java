class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1 ; i <= numRows ; i++){
            list.add(generator(i));
        }
        return list;
    }

    static List<Integer> generator(int n){
        int ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(ans);
        for(int i = 1 ; i < n ; i++){
            ans *= (n-i);
            ans /= i;
            list.add(ans);
        }
        return list;
    }
}