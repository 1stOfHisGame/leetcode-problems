package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PancakeSort {

	// for flipping, this method takes an array as input, an order index and result list
	public int[] pancakeFlip(int[] A, int order, List<Integer> res) {
		// iterate over the array until the half of order index...
		for (int i = 0; i <= order / 2; i++) {
			//...and swap the i'th element with the element at mirror position; mirror is placed at index order/2
			int temp = A[i];
			A[i] = A[order - i];
			A[order - i] = temp;
		}
		
		//save this order index in result list
		res.add(order+1); // +1 because of 0 indexing
		
		/* Uncomment following snippet for debugging each flip */
		/* 
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
		System.out.println(res);
		*/
		
		// return flipped array
		return A;
	}
	
	public List<Integer> pancakeRecipe(int[] A, List<Integer> res) {
		int localMaxIndex = A.length-1;
		
		// finding local maxima; i.e. the first element that does not breaks the ascending order or array
		for(int i=0; i<A.length-1;i++) {
			if(A[i] > A[i+1]) {
				localMaxIndex = i; //save index of local maxima
				break;
			}
		}
		
		// if local maxima is last element in array, then it means the array is sorted
		// *TERMINATING condition for recursion
		if(localMaxIndex == A.length-1)
			return res; //so return the result

		// otherwise we have some flipping to do
		else { 
			int i;
			//iterate over the array from last index, down to the local maxima's index
			for (i = A.length - 1; i > localMaxIndex; i--) {
				// if our local maxima is greater than the i'th element in array...
				if (A[localMaxIndex] > A[i]) {
					// ...and in case local maxima is NOT the first element in array...
					if (localMaxIndex != 0)
						// ...then flip until local maxima; to make local maxima the first element
						A = pancakeFlip(A, localMaxIndex, res);

					// ...then flip until the i'th element; so that we have the max element at its correct postion
					A = pancakeFlip(A, i, res);
					break;
				}
			}
		}
		// now send this array through same function and let recursion handle the rest
		return pancakeRecipe(A,res);
	}

	public List<Integer> pancakeSort(int[] A) {
		List<Integer> res = new ArrayList<Integer>(); //result list to save indexes where we flipped
		return pancakeRecipe(A,res);
	}

	public static void main(String[] args) {
		int[] a = {3,2,4,1};
		List<Integer> result = new PancakeSort().pancakeSort(a);
		System.out.println(result);
	}

}
