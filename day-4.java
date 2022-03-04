/*
Question Link - https://leetcode.com/problems/champagne-tower/
*/
/*
Reference Link - https://www.youtube.com/watch?v=BTndk4qhObQ
*/

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured==0)
            return 0;
        List<Double> list = new ArrayList<>();
        list.add(Double.valueOf(poured));
        while(query_row-->0){
            List<Double> temp = new ArrayList<>();
            temp.add(Math.max((list.get(0)-1)/2,0));
            for(int j=1;j<list.size();j++){
                temp.add(Math.max(((list.get(j)-1)/2),0)+Math.max(((list.get(j-1)-1)/2),0));
            }
            temp.add(Math.max((list.get(list.size()-1)-1)/2,0)); 
            list = new ArrayList<>(temp);
        }
        return Math.min(list.get(query_glass),1);
    }
}
