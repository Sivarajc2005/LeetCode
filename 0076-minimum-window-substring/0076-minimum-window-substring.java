class Solution {
    static HashMap<Character , Integer> fc;
    static HashMap<Character , Integer> pc;

    public String minWindow(String s, String t) {
        fc = new HashMap<>();
        pc = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        sb.append(s);

        for(int i = 0 ; i < t.length() ; i++){
            char ch = t.charAt(i);
            fc.put(ch , fc.getOrDefault(ch , 0) + 1);
        }

        int st = 0 , en = 0 ;
        while(en < s.length()){

            char ch = s.charAt(en);
            if(fc.containsKey(ch)){
                // System.out.println("i am enteres at : " + ch);

                pc.put(ch , pc.getOrDefault(ch, 0) + 1);
                boolean che = false;
                if(fc.get(ch) < pc.get(ch)){
                    st = startpoint(s , st , en);
                    che =true;
                }
                if(match()){
                    if(!che){
                        st = startpoint(s , st , en);
                    }
                    
                    int len = (en - st )+ 1;
                    if(len < sb.length()){
                        sb.setLength(0);
                        sb.append(s.substring(st , en+1) );
                    }
                }
                
            }
            en++;
        }
        if(match()){

            return sb.toString();
        }
        return "";
        

    }

    static boolean match(){
        // System.out.println(fc+" --> "+pc);
        if(fc.size() > pc.size()){
            return false;
        }

        for(char ch : fc.keySet()){
            if(fc.get(ch) > pc.get(ch)){
                return false;
            }
        }
        return true;
    }

    static int startpoint(String s , int st ,int en ){

        for( ; st <= en ; st++){
            char ch  = s.charAt(st);
            if(fc.containsKey(ch)){
                if(fc.get(ch) > pc.get(ch) -1 ){
                    return st;
                }
                else{
                    pc.put(ch , pc.get(ch) -1 );
                }
            }

        }

        return st;
    }
}