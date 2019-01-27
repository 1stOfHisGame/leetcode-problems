class Solution {
    public int repeatedNTimes(int[] A) {
        int size = A.length;
        int[] copy = new int[10001];
        for(int i=0; i<size; i++){
            copy[A[i]] += 1;
            if(copy[A[i]] > 1)
                return A[i];
        }
        return 0;
    }
}
