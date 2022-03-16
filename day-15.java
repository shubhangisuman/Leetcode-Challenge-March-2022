//Question Link - https://leetcode.com/problems/validate-stack-sequences/submissions/
//Approach 1 -  Time - O(N), Space - O(N)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        boolean[] vis = new boolean[1001];
        Stack<Integer> st = new Stack<>();
        int i=0,j=0;
        while(i<n){
            if(!vis[popped[i]]){
                while(j<n && !vis[popped[i]]){
                    st.push(pushed[j]);
                    vis[pushed[j]]=true;
                    j++;
                }
                if(!st.isEmpty())
                    st.pop();
                i++;
            }
            else{
                if(st.peek()!=popped[i])
                    return false;
                i++;
                if(!st.isEmpty())
                    st.pop();
            }
        }
        return true;
    }
}

//Approach 2 -  Time - O(N), Space - O(1)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int j = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(pushed[i]);
            while(j<n && !st.isEmpty() && st.peek()==popped[j]){
                st.pop();
                j++;
            }
        }
        return j==n;
    }
}
