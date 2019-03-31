### 1020. Number of Enclaves

Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)

A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.

Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.

#### Example 1:
Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]<br>
Output: 3<br>
Explanation:<br> 
There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.

#### Example 2:
Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]<br>
Output: 0<br>
Explanation: <br>
All 1s are either on the boundary or can reach the boundary.
 
#### Note:
1 <= A.length <= 500<br>
1 <= A[i].length <= 500<br>
0 <= A[i][j] <= 1<br>
All rows have the same size.
