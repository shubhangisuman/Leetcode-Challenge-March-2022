/*Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.*/

/*Idea: 
1 2 3 4 5 6 7 8
1 1 2 1 2 2 3 1 

odd   ---- LSB is set 
even  ----- LSB is not set
n=7 111
n/2=3 011 -----Right shift will lose one set bit

n=8 1000
n=4 0100 -------Right shift will maintain same number of set bits as in n/2
*/

class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        for(int i=1;i<=num;i++){
            if(i%2==0)
                dp[i]=dp[i/2];          
            else
                dp[i]=dp[i/2]+1;
        }
        return dp;
    }
}
