/*
Question Link -https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/ 
*/
/*
Idea - 
// for 3 - 
// _p1_p2_d1_d2_ == available space where we can put p3d3
// p3(1st space) = d3 (5)
// p3(2nd space) = d3 (4)
// p3(3rd space) = d3 (3)
// p3(4th space) = d3 (3)
// p3(5th space) = d3 (1)
// total combinations = 5+4+3+2+1 = 15

// p1p2d1d2 can arrange in 6 ways
// Therefore, dp[3] = 15*6 = 90

*/

class Solution {
    public int countOrders(int n) {
        if(n==1)
            return 1;
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 6;
        int mod = (int) Math.pow(10,9)+7;
        for(int i=3;i<=n;i++){
            int val = (i*2)-1;
            int sum = (val*(val+1))/2;
            dp[i] = (dp[i-1]*sum)%mod;
        }
        return (int) dp[n];
    }
}



