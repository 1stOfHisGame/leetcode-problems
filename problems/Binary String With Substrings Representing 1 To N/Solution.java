class Solution {
    public boolean queryString(String S, int N) {
        for(int i=1; i<=N; i++){
            String bin = "";
            int j = i;
            while(j != 0){
                bin = (j&1) + bin;
                j>>=1;
            }
            if(S.indexOf(bin) < 0)
                return false;
        }
        return true;
    }
}
