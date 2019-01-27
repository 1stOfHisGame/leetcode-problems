# 970. Powerful Integers
[Solve it on leetcode](https://leetcode.com/problems/powerful-integers/)

Given two non-negative integers x and y, an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.

Return a list of all powerful integers that have value less than or equal to bound.

You may return the answer in any order.  In your answer, each value should occur at most once.

### Example 1:
Input: x = 2, y = 3, bound = 10<br>
Output: [2,3,4,5,7,9,10]<br>
Explanation: <br>
2 = 2^0 + 3^0<br>
3 = 2^1 + 3^0<br>
4 = 2^0 + 3^1<br>
5 = 2^1 + 3^1<br>
7 = 2^2 + 3^1<br>
9 = 2^3 + 3^0<br>
10 = 2^0 + 3^2

### Example 2:
Input: x = 3, y = 5, bound = 15<br>
Output: [2,4,6,8,10,14]
 

### Note:
1 <= x <= 100<br>
1 <= y <= 100<br>
0 <= bound <= 10^6
