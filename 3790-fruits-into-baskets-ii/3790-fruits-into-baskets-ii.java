class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int sum = 0;

        for(int i = 0 ; i < fruits.length ; i++){
            boolean che = false;
            for(int j = 0 ; j < baskets.length ; j++){
                if(fruits[i] <= baskets[j]){
                    baskets[j]=0;
                    che = true;
                    break;
                }
            }
            if(!che){
                sum++;
            }
        }

        return sum;
    }
}