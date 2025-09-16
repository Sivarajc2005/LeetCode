class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();

        if(nums.length == 1){
            ans.add(nums[0]);
            return ans;
        }

        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        boolean che = false;
        int ind = 2;

        stack.push(nums[0]);
        stack.push(nums[1]);

        while(true){  // outer loop

            if(stack.size() <= 1 || che){  //make sure the need element exist ? 
                if(ind >= n){
                    break;
                }
                stack.push(nums[ind++]);
            }

            che = false;


            int a = stack.pop();
            int b = stack.pop();

            if(gcd(a,b) > 1 ){
                stack.push(lcm(a,b));
                
            }
            else{
                stack.push(b);
                stack.push(a);
                che = true;
            }
        }

        while(!stack.isEmpty()){
            ans.add(0 , stack.pop());
        } 

        return ans;

    }

    static int gcd(int a , int b){
        if(b==0){
            return a;
        }
        return gcd( b , a%b);
    }

    static int lcm(int a , int b){
        return ((a/gcd(a,b)) * b);
    }
}