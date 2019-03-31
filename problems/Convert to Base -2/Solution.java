class Solution {
    public String baseNeg2(int N) {
        if(N == 0) return "0";
        String bin = "";
        int count = 0;
        while(N != 0){
            bin = (N % 2) + bin;
            if(count % 2 == 0)
                N = (int) Math.floor(N / 2.0);
            else N = (int) Math.ceil(N / 2.0);
            count++;
        }
        return bin;
    }
}
