class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
                st.push(s.charAt(i));
            else{
                if(st.isEmpty())
                    return false;
                if(s.charAt(i)==')' && st.peek()=='(')
                    st.pop();
                else if(s.charAt(i)==']' && st.peek()=='[')
                    st.pop();
                else if(s.charAt(i)=='}' && st.peek()=='{')
                    st.pop();
                else 
                    c++;
            }
        }
        if(st.isEmpty() && c==0)
            return true;
        else
            return false;
    }
}
