# 953. Verifying an Alien Dictionary
[Solve it on leetcode](https://leetcode.com/problems/verifying-an-alien-dictionary/)

In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

### Example 1:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"<br>
Output: true<br>
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

### Example 2:
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"<br>
Output: false<br>
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

### Example 3:
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"<br>
Output: false<br>
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).

### Note:

1 <= words.length <= 100<br>
1 <= words[i].length <= 20<br>
order.length == 26<br>
All characters in words[i] and order are english lowercase letters.
