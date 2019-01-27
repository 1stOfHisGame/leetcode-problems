# 966. Vowel Spellchecker
[Solve it  on leetcode](https://leetcode.com/problems/vowel-spellchecker/)

Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.
For a given query word, the spell checker handles two categories of spelling mistakes:

Capitalization: If the query matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the case in the wordlist.<br>
Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"<br>
Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"<br>
Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"<br>
Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel individually, it matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the match in the wordlist.<br>
Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"<br>
Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)<br>
Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)<br>
In addition, the spell checker operates under the following precedence rules:<br>

When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.<br>
When the query matches a word up to capitlization, you should return the first such match in the wordlist.<br>
When the query matches a word up to vowel errors, you should return the first such match in the wordlist.<br>
If the query has no matches in the wordlist, you should return the empty string.<br>
Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].<br>

### Example 1:
Input: wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]<br>
Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]

### Note:
1 <= wordlist.length <= 5000<br>
1 <= queries.length <= 5000<br>
1 <= wordlist[i].length <= 7<br>
1 <= queries[i].length <= 7<br>
All strings in wordlist and queries consist only of english letters.
