//Question link I- https://leetcode.com/problems/remove-duplicate-letters/
//Question link II - https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

//Idea - Keep track of last occurence position to skip the charcter and position it in smallest lexicographical order

class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i),i);
        Stack<Character> st = new Stack<>();
        boolean[] vis = new boolean[26];
        for(int i=0;i<s.length();i++){
            if(vis[s.charAt(i)-'a'])
                continue;
            while(!st.isEmpty() && (map.get(st.peek())>i && st.peek()>s.charAt(i)))
                vis[st.pop()-'a']=false;
            vis[s.charAt(i)-'a']=true;
            st.push(s.charAt(i));
        }
        String res = "";
        while(!st.isEmpty()){
            res=st.peek()+res;
            st.pop();
        }
        return res;
    }
}
