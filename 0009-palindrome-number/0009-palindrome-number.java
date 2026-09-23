class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        } else if( x < 10) {
            return true;
        }

        int bef = x;
        int aft = 0;

        boolean isFirst = true;
        boolean isZeroAval = false;

        while(x != 0) {
            // extract last ele
            int temp = x % 10;

            if(isFirst && temp == 0) {
                isZeroAval = true;
            }

            // without last ele
            bef = x / 10;

            if(bef == 0) {
                return false;
            }

            // used for odd one we leav the mid one and check
            print("bef: "+ bef + " aft: "+ aft+ " temp: "+ temp);
            if(bef == aft) {
                if(isZeroAval) {
                    return false;
                }
                print("sol on odd");
                return true;
            }

            aft = (aft * 10 ) + temp;

            
            if(bef == aft) {
                if(isZeroAval) {
                    return false;
                }
                print("bef: "+ bef + " aft: "+ aft+ " temp: "+ temp);
                print("sol on odd");
                return true;
            }

            // red x
            x /= 10;

            if(bef < aft) {
                return false;
            }

            isFirst = false;
        }

        return false;
    }

    public void print(String str) {
        System.out.println(str);
    }
}