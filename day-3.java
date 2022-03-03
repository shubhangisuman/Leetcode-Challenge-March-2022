/*
An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.
*/

/*
Idea - 
12345
123 - 1
1234 - 2 (123 will grow, and 1234)
12345 - 3 (123 will grow, 1234 will grow, and 12345)
total = 6
*/

/*************Using Dp***************/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3)
            return 0;
        int[] dp =new int[nums.length];
        int ans = 0;
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
               dp[i]=dp[i-1]+1;                    //Number of arithmetic sequences till now
                ans+=dp[i];
            }
        }
        return ans;
    }
}


/************O(N) Solution********/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3)
            return 0;
        int cur = 0,total=0;
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                cur++;
                total+=cur;
            }
            else
                cur=0;
        }
        return total;
    }
}

/*********Recursive - Brute Force******/
class Solution {
    public int countArithmeticSlices(int[] nums, int start, ArrayList<Integer> list,int diff){
        if(start>=nums.length || nums[start]-list.get(list.size()-1)!=diff){
            return 0;
        }
        list.add(nums[start]);
        if(list.size()>=3)
            return 1+countArithmeticSlices(nums,start+1,list,diff);
        else
            return countArithmeticSlices(nums,start+1,list,diff);
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length,res=0;
        for(int i=1;i<=n-2;i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[i-1]);
            res+=countArithmeticSlices(nums,i,list,nums[i]-nums[i-1]);
        }
        return res;
    }
}
