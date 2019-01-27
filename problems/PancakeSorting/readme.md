# 969. Pancake Sorting
[Solve it on leetcode](https://leetcode.com/problems/pancake-sorting/)

Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A. <br>We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.<br>
Return the k-values corresponding to a sequence of pancake flips that sort A. <br>Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.

 

### Example 1:
Input: [3,2,4,1]<br>
Output: [4,2,4,3]<br>
Explanation: <br>
We perform 4 pancake flips, with k values 4, 2, 4, and 3.<br>
Starting state: A = [3, 2, 4, 1]<br>
After 1st flip (k=4): A = [1, 4, 2, 3]<br>
After 2nd flip (k=2): A = [4, 1, 2, 3]<br>
After 3rd flip (k=4): A = [3, 2, 1, 4]<br>
After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted. <br>

### Example 2:
Input: [1,2,3]<br>
Output: []<br>
Explanation: The input is already sorted, so there is no need to flip anything.<br>
Note that other answers, such as [3, 3], would also be accepted.<br>
 

### Note:
1 <= A.length <= 100<br>
A[i] is a permutation of [1, 2, ..., A.length]
