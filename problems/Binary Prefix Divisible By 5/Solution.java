import java.math.BigInteger; 
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<Boolean>();
        int value = 0;
        for(int i: A){
            value = (value*2 + i)%5;
            if(value == 0)
                res.add(true);
            else res.add(false);
        }
        return res;
    }
}
