class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int count  = 0;
        int sol = 0;
        int index = 0;
        char ch1 = chars[0];
        for(int i = 0; i < n; i ++) {
            char ch2 = chars[i];
            // System.out.println("ele: "+ ch2 + " count: "+ count);
            if (ch1 != ch2) {
                // System.out.println("----- completed --- ");
                if(count == 1 ) {
                    chars[index] = ch1;
                    sol += 1;
                } else {
                    chars[index] = ch1;
                    int numlen = intlen(count);
                    int temp = numlen;
                    sol ++; 
                    while(count > 0) {
                        int number = count % 10;
                        count /= 10;
                        char c = (char) ('0' + number);
                        chars[index + numlen] = c;
                        numlen--;
                        sol++;
                    }
                    index += temp; 
                }
                index++;
                ch1 = ch2;
                count = 1;
                // System.out.println(Arrays.toString(chars));
            } else {
                count++;
            }
        }
        if(count == 1 ) {
            chars[index] = ch1;
            sol += 1;
        } else {
            chars[index] = ch1;
            int numlen = intlen(count);
            sol++;
            while(count > 0) {
                int number = count % 10;
                count /= 10;
                char c = (char) ('0' + number);
                chars[index + numlen] = c;
                numlen--;
                sol++;
            }
            index += numlen; 
        }
        // System.out.println(sol);

        return sol;
    }

    public int intlen(int count) {
        int sol = 0;
        while(count > 0) {
            count /= 10;
            sol++;
        }
        // System.out.println(sol);
        return sol;
    }
}