//Question link -https://leetcode.com/problems/simplify-path/


class Solution {
    public String simplifyPath(String path) {
        String s = path;
        String[] arr = s.split("/");
        int last = -1;
        Stack<String> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("..")){
                if(!st.isEmpty())
                    st.pop();
            }
            else if(arr[i]!="" && !arr[i].equals(".")){
                st.push(arr[i]);
            }
        }
        String res = "";
        if(st.isEmpty())
            return "/";
        while(!st.isEmpty()){
            res = st.pop()+"/"+res;
        }
        res="/"+res;
        return res.substring(0, res.length()-1);
    }
}

//Approach-2 
class Solution {
    private static final String EMPTY = "";
    private static final String DOT = ".";
    private static final String DOT_DOT = "..";
    private static final String SLASH = "/";
    
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for(String s : path.split("/")) {
            switch (s) {
                case EMPTY:
                case DOT:
                    continue;
                case DOT_DOT:
                    if(!stack.isEmpty())
                        stack.pop();
                    break;
                default:
                    stack.push(s);
                    break;
            }
        }
        return SLASH + String.join("/", stack.toArray(new String[0]));
    }
}
