class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length; //length of array
        int st=0,en=0; 
        for(int i = 0 ; i < n ;i++){
            for(int j = i+1 ; j < n ; j++){
                if(nums[i]+nums[j] == target){
                    // return new int[] {i,j};
                    st=i;
                    en=j;
                    break;
                }
            }
        }
        return new int[] {st,en};
    }
}