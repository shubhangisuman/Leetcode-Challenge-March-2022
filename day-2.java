/*Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing 
the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Input: s = "abc", t = "ahbgdc"
Output: true

Input: s = "axc", t = "ahbgdc"
Output: false

*/

/*------------1st Approach----------------*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;
        if(t.length()==0)
            return s.length()==0;
        if(s.charAt(0)==t.charAt(0))
            return isSubsequence(s.substring(1),t.substring(1));
        else
            return isSubsequence(s,t.substring(1));
    }
}

/*------------2nd Approach----------------*/
public boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;
        int c=0;
        for(int i=0;i<t.length();i++){
            if(s.charAt(c)==t.charAt(i)){
                c++;
                if(c==s.length())
                    return true;
            }
        }
        return false;
    }
