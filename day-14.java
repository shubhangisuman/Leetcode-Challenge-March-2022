//Question link - https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
//Idea - Find the positions that needs to be deleted

//Approach-1
class Solution {
    public String minRemoveToMakeValid(String s) {
        int i = 0;
        int n = s.length();
        String res = "";
        Stack<String> st = new Stack<>();
        while(i<n){
            if((s.charAt(i)>='a' && s.charAt(i)<='z') || s.charAt(i)=='('){
                st.push(s.charAt(i)+"");    
            }
            else{
                String temp = "";
                Boolean found = false;
                while(!st.isEmpty()){
                    if((st.peek()).equals("(")){
                        st.pop();
                        found = true;
                        break;
                    }
                    temp = st.peek()+temp;
                    st.pop();
                }
                if(found)
                    temp="("+temp+")";
                st.push(temp);
            }
            i++;
        }
        while(!st.isEmpty()){
            // System.out.println(st.peek());
            if(!(st.peek()).equals("(") || !(st.peek()).equals("("))
                res = st.peek()+res;
            st.pop();
        }
        // System.out.println();
        return res;
    }
}
//Approach-2
class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        int i = 0;
        Stack<Integer> st = new Stack<>();
        while(i<n){
            if(s.charAt(i)=='(')
                st.push(i);
            else if(s.charAt(i)==')'){
                if(!st.isEmpty() && s.charAt(st.peek())=='(')
                    st.pop();
                else
                    st.push(i);
            }
            i++;
        }
        StringBuilder res = new StringBuilder(s);
        while(!st.isEmpty()){
            res.deleteCharAt(st.peek());
            st.pop();
        }
        return res.toString();
    }
}
