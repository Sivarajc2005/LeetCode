class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;

        for(int i = 0; i < n; i++) {
            int curr = asteroids[i];
            
            // stack emp we just add it on stack
            if(stack.isEmpty()) {
                stack.push(curr);
                continue;
            }

            int peek = stack.peek();
            if(sameDir(curr, peek)) {
                // System.out.println("same: "+ curr);
                stack.push(curr);
            } else if(peek < 0 && curr >= 0) {
                //  System.out.println("less: "+ curr);
                stack.push(curr);
            } else {
                while(!sameDir(peek, curr)) {
                    //  System.out.println("entering not eql: "+ curr+ " peek: "+ peek);
                    if(peek < 0 && curr >= 0) {
                        // System.out.println("less2: "+ curr);
                        stack.push(curr);
                        break;
                    }

                    if(peek == Math.abs(curr)) {
                        // System.out.println("curr: "+ curr);
                        stack.pop();
                        break;
                    }

                    if(Math.abs(curr) > peek) {
                        stack.pop();
                    } else {
                        break;
                    }

                    if(!stack.isEmpty()) {
                        peek = stack.peek();
                    }

                    if(peek < curr || stack.isEmpty() || sameDir(curr, peek)) {
                        //  System.out.println("last: "+ curr);
                        stack.push(curr);
                        break;
                    }
                }
            }
        }

        int len = stack.size();

        int[] sol = new int[len];

        for(int i = len - 1; i >= 0; i--) {
            sol[i] = stack.pop();
        }

        return sol;
    }

    public boolean sameDir(int one, int two) {
        if(one < 0 && two < 0) {
            return true;
        } else if(one >= 0 && two >= 0) {
            return true;
        }
        return false;
    }
}