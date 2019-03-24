// brute force 
/*class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int score = 0;
        for(int i=0; i<A.length-1; i++){
            for(int j=i+1; j<A.length; j++){
                // comparing every possible pair
                score = Math.max(score, A[i]+A[j]+i-j);
            }
        }
        return score;
    }
}*/

// memoization
class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int score = 0;
        int[] jScore = new int[A.length-1];
        // creating an array jScore to keep track of max (A[j] - j) from right side
        for(int i=A.length-1; i>0; i--){
            jScore[i-1] = A[i] - i;
            if(i!=A.length-1 && jScore[i] > jScore[i-1])
                jScore[i-1] = jScore[i];
        }
        // the best j'th element for any i'th element in right side is looked up in O(1) from jScore
        for(int i=0; i<A.length-1; i++){
            score = Math.max(jScore[i] + A[i] + i, score);
        }
        return score;
    }
}
