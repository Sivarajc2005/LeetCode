class Solution {
    public int maxFrequencyElements(int[] arr) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        } 
        int count  = 0;
        int max = Integer.MIN_VALUE;
        for( int key : map.keySet()){
            if(map.get(key) > max){
                count = map.get(key);
                max = map.get(key);
            }
            else if(map.get(key) == max){
                count += map.get(key);
            }
        }
        return count;
    }
}