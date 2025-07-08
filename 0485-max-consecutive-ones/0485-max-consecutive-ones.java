class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // boolean che = false;
        int c = 0;
        int tem = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 1){
                // che = true;
                tem++;
            }
            else{
                if(c < tem){
                    c = tem;
                }
                tem = 0;
            }
        }

        if(tem > c){
            return tem;
        }
        return c;
    }
}