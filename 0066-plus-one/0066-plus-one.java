class Solution {
    public int[] plusOne(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int c = 1;

        for(int i = arr.length - 1 ; i >= 0 ; i--){
            int val = arr[i] + c;
            if(val < 10){
                list.add(0 ,val);
                c = 0;
            }
            else{
                list.add(0 , val % 10);
                c = 1;
            }          
        }
        if(c == 1){
            list.add(0 , 1);
        }
        int[] newarr = new int[list.size()];
        for(int i= 0 ; i < list.size() ; i++){
            newarr[i] = list.get(i);
        }

        return newarr;
    }
}