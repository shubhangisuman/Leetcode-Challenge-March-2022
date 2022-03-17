
//Question - https://leetcode.com/problems/score-of-parentheses/
//Idea - Find the depth of the inner most () and 2^depth will be the score. Keep adding all the score to get answer.
class Solution {
    public int scoreOfParentheses(String s) {
        int depth = 0;
        int res = 0;
        char prev = ' ';
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                depth++;
            else{
                depth--;
                if(prev=='('){
                    res+=Math.pow(2,depth);
                }
            }
            prev = s.charAt(i);
        }
        return res;
    }
}
