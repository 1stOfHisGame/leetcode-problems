package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RandomPickWithBlacklist {

	// using a hashtable to save different continuous subsequence of
	// numbers without any blacklist number in it
	HashMap<Integer, List<Integer>> hashtable = new HashMap<Integer, List<Integer>>();

	// If there are N blacklist numbers, then we create N hashtable entries
	// each hashtable entry has a lower bound and upper bound which we use to generate random numbers
	public RandomPickWithBlacklist(int N, int[] blacklist) {
		
		// important to sort the blacklist before segregating our hashtable sequences
		Arrays.sort(blacklist);
		
		if (blacklist.length == 0) {
			fillHashTable(0, 0, N - 1, -1);
			return;
		}
		int lastStart = 0;
		int hashCounter = 0;
		for (int i = 0; i < blacklist.length; i++) {
			if (blacklist[i] >= N) {
				hashCounter = fillHashTable(hashCounter, lastStart, N - 1, blacklist[i]);
				break;
			}
			if (i == blacklist.length - 1) {
				hashCounter = fillHashTable(hashCounter, lastStart,
						blacklist[i] - 1 < lastStart ? lastStart : blacklist[i] - 1, blacklist[i]);
				lastStart = blacklist[i] + 1;
				if (lastStart < N)
					hashCounter = fillHashTable(hashCounter, lastStart, N - 1, blacklist[i]);
				break;
			}
			hashCounter = fillHashTable(hashCounter, lastStart,
					blacklist[i] - 1 < lastStart ? lastStart : blacklist[i] - 1, blacklist[i]);
			lastStart = blacklist[i] + 1;
		}
	}

	// method to fill hashtable entry; lower bound and upper bound represent all the numbers that this sequence contains
	public int fillHashTable(int hashCounter, int lowerBound, int upperBound, int blacklistNumber) {
		if ((blacklistNumber == lowerBound || blacklistNumber == upperBound) || lowerBound > upperBound)
			return hashCounter;
		hashtable.put(hashCounter, new ArrayList<Integer>());
		hashtable.get(hashCounter).add(lowerBound);
		hashtable.get(hashCounter).add(upperBound);
		return ++hashCounter;
	}

	public int getRandomBetween(int min, int max) {
		int range = (max - min) + 1;
		int random = (int) (Math.random() * range + min);
		return random;
	}

	public int pick() {
		if (hashtable.size() == 0)
			return 0;
		int hashCounter = getRandomBetween(0, hashtable.size() - 1);
		return getRandomBetween(hashtable.get(hashCounter).get(0), hashtable.get(hashCounter).get(1));
	}

	/**
	 * Your Solution object will be instantiated and called as such: Solution obj =
	 * new Solution(N, blacklist); int param_1 = obj.pick();
	 */

	public static void main(String[] args) {
		int[] a = { 0, 8 };
		RandomPickWithBlacklist obj = new RandomPickWithBlacklist(10, a);
		int param_1 = obj.pick();
		int param_2 = obj.pick();
		int param_3 = obj.pick();
		int param_4 = obj.pick();
		System.out.println(param_1);
		System.out.println(param_2);
		System.out.println(param_3);
		System.out.println(param_4);
	}
}
