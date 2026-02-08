class Solution {
    public double myPow(double x, int n) {
        long val = n;
        if(n < 0) {
            val = val * -1;
        }

        double res = rec(x, val, 1);
        // System.out.println(res);
        if(n < 0) {
            return 1 / res ;
        } else {
            return res;
        }
    }

    public double rec(double x, long n, double ans) {
        if(n == 0) {
            return ans;
        }
        if(n % 2 == 1) {
            n = n - 1;
            ans =  ans * x;
            // System.out.println("ans: "+ ans+ " x: "+ x+ " n: "+ n); 
        }
        else {
            n = n / 2;
            x = x * x;
        }
        // System.out.println("ans: "+ ans+ " x: "+ x+ " n: "+ n);
        return rec(x, n, ans);
    }
}