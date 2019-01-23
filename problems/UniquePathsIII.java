package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniquePathsIII {

	public Boolean isAlreadyWalked(int row, int col, HashMap<Integer, List<Integer>> memory) {
		if (memory.containsKey(row) == false)
			return false;
		else {
			if (memory.get(row).contains(col) == true)
				return true;
			else
				return false;
		}
	}

	public int explore(int row, int col, int tilesLeftToWalk, HashMap<Integer, List<Integer>> memory, int[][] grid) {
		int noOfWays = 0;

		// entering an obstacle
		if (grid[row][col] == -1)
			return 0;

		// entering exit...
		if (grid[row][col] == 2) {
			// ...with all tiles walked
			if (tilesLeftToWalk == 0) {
				return 1;
			}
			// ...with all tiles not walked
			else
				return 0;
		}

		// entering a walkable tile OR start tile; while having some tiles left to walk
		else {

			// since this is a legitimate walkable tile, remember this tile has been walked
			List<Integer> list = new ArrayList<Integer>();
			list.add(col);
			if (memory.containsKey(row)) {
				list.addAll(memory.get(row));
				memory.replace(row, list);
			} else
				memory.put(row, list);

			// decrement tiles left to walk if current tile is 0
			if (grid[row][col] == 0)
				tilesLeftToWalk--;

			// now check up, down, left and right to see if it's possible to move that
			// way...
			// if it is then move else don't

			// left
			if (col - 1 >= 0 && isAlreadyWalked(row, col - 1, (HashMap) memory.clone()) == false) {
				noOfWays += explore(row, col - 1, tilesLeftToWalk, (HashMap) memory.clone(), grid);
			}

			// right
			if (col + 1 < grid[0].length && isAlreadyWalked(row, col + 1, (HashMap) memory.clone()) == false) {
				noOfWays += explore(row, col + 1, tilesLeftToWalk, (HashMap) memory.clone(), grid);
			}

			// up
			if (row - 1 >= 0 && isAlreadyWalked(row - 1, col, (HashMap) memory.clone()) == false) {
				noOfWays += explore(row - 1, col, tilesLeftToWalk, (HashMap) memory.clone(), grid);
			}

			// down
			if (row + 1 < grid.length && isAlreadyWalked(row + 1, col, (HashMap) memory.clone()) == false) {
				noOfWays += explore(row + 1, col, tilesLeftToWalk, (HashMap) memory.clone(), grid);
			}

		}

		return noOfWays;
	}

	public int uniquePathsIII(int[][] grid) {
		int solutions = 0;
		HashMap<Integer, List<Integer>> memory = new HashMap<Integer, List<Integer>>();
		int totalWalkableTiles = 0;
		int startRow = -1, startCol = -1;
		int endRow = -1, endCol = -1;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0)
					totalWalkableTiles++;
				if (grid[i][j] == 1) {
					startRow = i;
					startCol = j;
				}
				if (grid[i][j] == 2) {
					endRow = i;
					endCol = j;
				}
			}
		}
		return explore(startRow, startCol, totalWalkableTiles, memory, grid);
	}

	public static void main(String args[]) {
		int[][] input = { new int[] { 1, 0, 0, 0 }, new int[] { 0, 0, 0, 0 }, new int[] { 0, 0, 2, -1 } };
		System.out.println(new UniquePathsIII().uniquePathsIII(input));
	}
}
