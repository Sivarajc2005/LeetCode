class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        HashSet<Integer> set = new HashSet<>();
        for(int i= 0 ; i < fronts.length ; i++){
            if(fronts[i] == backs[i])
                set.add(fronts[i]);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < fronts.length ; i++){
            if(min > fronts[i] && !set.contains(fronts[i])){
                min = fronts[i];
            }
            if(min > backs[i] && !set.contains(backs[i])){
                min = backs[i];
            }
        }

        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}