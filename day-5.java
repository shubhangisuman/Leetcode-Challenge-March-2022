/*
Problem link - https://leetcode.com/problems/delete-and-earn/
Reference - House and Robber problem (cannot select any element next to it)
*/

/*
Idea - 
1. Calculate the points if that number is choosen
nums = [5, 5, 5, 6, 6, 6, 6, 7, 7]
If we take all the 5, we get 5 * 3 = 15 points.
If we take all the 6, we get 6 * 4 = 24 points.
If we take all the 7, we get 7 * 2 = 14 points.

Answer = 29

Make a choice for number: take, or don't take.

*/

class Solution {
    public int maxPoints(int[] points, int num){
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = points[1];
        for(int i=2;i<=num;i++){
            dp[i] = Math.max(points[i]+dp[i-2],dp[i-1]); //cannot select any element next to it
        }
        // System.out.println(Arrays.toString(dp));
        return dp[num];
    }
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        int[] points = new int[max+1];
        for(int i=0;i<n;i++)
            points[nums[i]]+=nums[i];
        
        return maxPoints(points,max);
    }
}
