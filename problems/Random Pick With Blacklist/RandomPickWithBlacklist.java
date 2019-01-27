public class Solution {

    // using a two layer hashtable to save different continuous subsequence of numbers without any blacklist number in it;
    // *but this isn't giving better time, should've used just one layer
	HashMap<Integer,HashMap<Integer,List<Integer>>> hashtable = new HashMap<Integer,HashMap<Integer,List<Integer>>>(); 		
	    public Solution(int N, int[] blacklist) {
	        Arrays.sort(blacklist);
	        if(blacklist.length==0) {
	        	fillHashTable(0, 0, N-1, -1);
	        	return;
	        }
	        int lastStart = 0;
	        int hash1counter = 0;
	        for(int i=0;i<blacklist.length;i++) {
	        	if(blacklist[i] >= N) {
	        		hash1counter = fillHashTable(hash1counter, lastStart, N-1, blacklist[i]);
	        		break;
	        	}
	        	if(i==blacklist.length-1) {
	        		hash1counter = fillHashTable(hash1counter, lastStart, blacklist[i]-1 < lastStart ? lastStart : blacklist[i]-1, blacklist[i]);
	        		lastStart = blacklist[i] + 1;
	        		if(lastStart < N)
	        			hash1counter = fillHashTable(hash1counter, lastStart, N-1, blacklist[i]);
	        		break;
	        	}
	        	hash1counter = fillHashTable(hash1counter, lastStart, blacklist[i]-1 < lastStart ? lastStart : blacklist[i]-1, blacklist[i]);
	        	lastStart = blacklist[i]+1;
	        }
	    }
	    
	    public int fillHashTable(int hash1counter, int lowerBound, int upperBound, int blacklistNumber) {
	    	if((blacklistNumber == lowerBound || blacklistNumber == upperBound) || lowerBound > upperBound)
	    		return hash1counter;
	    	hashtable.put(hash1counter, new HashMap<Integer,List<Integer>>());
        	int hash2counter = hashtable.get(hash1counter).size();
        	hashtable.get(hash1counter).put(hash2counter, new ArrayList<Integer>());
        	hashtable.get(hash1counter).get(hash2counter).add(lowerBound);
        	hashtable.get(hash1counter).get(hash2counter).add(upperBound);
        	return ++hash1counter;
	    }
	    
	    public int getRandomBetween(int min, int max) {
	    	int range = (max-min) + 1;
	        int random = (int)(Math.random()*range + min);
	        return random;
	    }
	    
	    public int pick() {
	        if(hashtable.size() == 0)
	        	return 0;
	        int hash1counter = getRandomBetween(0,hashtable.size()-1);
	        int hash2counter = getRandomBetween(0,hashtable.get(hash1counter).size()-1);
	        return getRandomBetween(hashtable.get(hash1counter).get(hash2counter).get(0),hashtable.get(hash1counter).get(hash2counter).get(1));
	    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */
