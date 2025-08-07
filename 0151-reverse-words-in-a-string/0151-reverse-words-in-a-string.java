class Solution {
    public String reverseWords(String s) {
        
        String[] str = s.split(" ");

        StringBuilder sb = new StringBuilder();
        String[] arr = rev(str);

        System.out.println(Arrays.toString(arr));

        for(String st : arr){
            if(st.equals(" ")||st.equals("")){
                continue;
            }
            sb.append(st.trim());
            sb.append(" ");
        }

        return sb.toString().trim();
    }


    static String[] rev(String[] str){
        int st = 0;
        int en = str.length -1;
        // StringBuilder sb = new StringBuilder();
        while(st <= en){
            String temp = str[st];
            str[st] = str[en];
            str[en] = temp;
            st++;
            en--;
        }

        return str;

    }
}