class Solution {
    public int numberOfBeams(String[] bank) {
        int beam = 0;
        int last = 0;

        for(int i = 0 ; i < bank.length ; i++){
            char[] strArray = bank[i].toCharArray();
            int temp = 0;
            for(int j = 0 ; j < strArray.length ; j++){
                if(strArray[j] == '1' ){
                    if(last == 0){
                        temp++;
                    }
                    else{
                        beam += last;
                        temp++;
                    }
                }
            }
          //store at last..
            if(temp != 0)
                last = temp;
            // System.out.println("last: "+last+" beam :"+beam);
        }
        return beam;
    }
}