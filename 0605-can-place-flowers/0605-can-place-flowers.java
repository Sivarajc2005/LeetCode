class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for(int i = 0 ; i < len; i++) {
            // System.out.println("curr: "+ flowerbed[i]);
            if(n == 0) {
                return true;
            }
            if(len == 1) {
                if(n == 1 && flowerbed[0] == 0) {
                    return true;
                }
                return false;
            }
            if(i == 0) {
                if(flowerbed[i+1] == 0 && flowerbed[i] != 1) {
                    // System.out.println("sub on 1");
                    n--;
                    flowerbed[i] = 1;
                }
            } else if( i == len-1) {
                if(flowerbed[i-1] == 0 && flowerbed[i] == 0) {
                    // System.out.println("sub on 2");
                    n--;
                    flowerbed[i] = 1;
                }
            } else if (flowerbed[i] == 0) {
                if(flowerbed[i-1] == 0 &&  flowerbed[i+1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
                // System.out.println("sub on 3 i-1: "+ flowerbed[i-1] + " i+1: "+  flowerbed[i+1]);
                
            }
        }
        System.out.println(n);
        System.out.println(Arrays.toString(flowerbed));
        if(n > 0) {
            return false;
        }
        
        return true;
    }
}