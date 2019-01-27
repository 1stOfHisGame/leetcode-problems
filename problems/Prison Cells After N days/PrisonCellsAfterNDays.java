package leetcode;

import java.util.HashMap;

public class PrisonCellsAfterNDays {

	// method to compare two cell sequences
	public Boolean compare(int[] a, int[] b) {
		if (a.length != b.length)
			return false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false; // return false at first instance of mismatch
		}
		return true;
	}

	public int[] prisonAfterNDays(int[] cells, int N) {

		// hashmap for saving learned sequences; key will be day count and value will be cell sequence
		HashMap<Integer, int[]> prisonHash = new HashMap<Integer, int[]>();

		// counter for days, also serves as key for hashmap
		int counter = 0;

		while (true) {
			// putting the prison cells sequence in hashmap
			// this way we can remember the no. of days before which this pattern occurs again
			prisonHash.put(counter, cells.clone()); // cloning the cells to avoid sharing references

			/* Uncomment the following snippet to debug each iteration */

			/*
			 * System.out.print("counter: "+counter+"\t"); for(int i=0;i<cells.length;i++)
			 * System.out.print(cells[i]+" "); System.out.println();
			 */

			// iterate over all cells; we exclude first and last
			for (int i = 1; i < cells.length - 1; i++) {
				// exor-ing the left and right cells to get status of cell for a new day
				cells[i] = (prisonHash.get(counter)[i - 1] ^ prisonHash.get(counter)[i + 1]) == 0 ? 1 : 0;
			}

			// since cells length is fixed at 8 and the first and last cell won't ever turn into 1
			cells[0] = cells[7] = 0;

			// increasing day count
			counter++;

			// if day count full...
			if (counter == N)
				return cells; // ...return last cell sequence as final sequence

			// if the new sequence has started repeating the first learned sequence...
			if (counter != 1 && compare(cells, prisonHash.get(1))) {
				break; // ...then stop remembering more sequences
			}
		}

		// If the no. of days hasn't already arrived in the above loop for learning sequences,
		// then it means for the asked N'th day, one of our learned sequences will be repeated.
		// To find that we will find the sequence that will repeat on N'th day by
		// calculating modulus with our hashmap size.
		int repeatingCellOrder = N % (prisonHash.size() - 1);

		// return the sequence once we know which day's sequence will be repeated.
		// Exception being the 1st sequence, i.e. 0'th sequence in our hashmap, for that
		// we return the last sequence because the 0th sequence won't
		// ever appear again as it has 1 on both ends of sequence
		return prisonHash.get(repeatingCellOrder == 0 ? (prisonHash.size() - 1) : repeatingCellOrder);
	}

	public static void main(String[] args) {
		int[] cells = { 0, 1, 0, 1, 1, 0, 0, 1 };
		int N = 7;
		int[] result = new PrisonCellsAfterNDays().prisonAfterNDays(cells, N);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");

	}

}
