package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VowelSpellchecker {

	public String getLowerCaseHash(String word) {
		return word.toLowerCase();
	}
	
	public String getVowelHash(String word) {
		char specialChar = '^'; // this character indicates place of a vowel in word
		return word.replace('a', specialChar)
				   .replace('e', specialChar)
				   .replace('i', specialChar)
				   .replace('o', specialChar)
				   .replace('u', specialChar);
	}
	
	public String[] spellChecker(String[] wordlist, String[] queries) {
		String result[] = new String[queries.length];
		
		HashMap<String, List<String>> dictionary = new HashMap<String, List<String>>();
		for(int i=0;i<wordlist.length;i++) {
			
			String lowerCaseHash = getLowerCaseHash(wordlist[i]);
			if(dictionary.containsKey(lowerCaseHash)) {
				if(!dictionary.get(lowerCaseHash).contains(wordlist[i]))
					dictionary.get(lowerCaseHash).add(wordlist[i]);
			}
			else {
				dictionary.put(lowerCaseHash, new ArrayList<String>());
				dictionary.get(lowerCaseHash).add(wordlist[i]);
			}
			
			String vowelHash = getVowelHash(lowerCaseHash);
			if (!vowelHash.equalsIgnoreCase(wordlist[i])) {
				if (dictionary.containsKey(vowelHash)) {
					if (!dictionary.get(vowelHash).contains(wordlist[i]))
						dictionary.get(vowelHash).add(wordlist[i]);
				} else {
					dictionary.put(vowelHash, new ArrayList<String>());
					dictionary.get(vowelHash).add(wordlist[i]);
				}
			}
		}
		
		for(int i=0;i<queries.length;i++) {
			String lowerCaseHash = getLowerCaseHash(queries[i]); 
			if(dictionary.containsKey(lowerCaseHash)) {
				if(dictionary.get(lowerCaseHash).contains(queries[i])) {
					result[i] = queries[i];
				}
				else {
					result[i] = dictionary.get(lowerCaseHash).get(0);
				}
				continue;
			}

			String vowelHash = getVowelHash(lowerCaseHash);
			if (dictionary.containsKey(vowelHash)) {
				result[i] = dictionary.get(vowelHash).get(0);
				continue;
			}

			result[i] = "";
		}
		
		/* Uncomment following snippet to see the dictionary we've saved*/
		//System.out.println("Dict: "+dictionary);
		
		return result;
		
	}
	
	public static void main(String[] args) {
		String[] wordlist = {"KiTe","kite","hare","Hare"};
		String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
		String[] result = new VowelSpellchecker().spellChecker(wordlist,queries);
		System.out.print("Result: ");
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+", ");
	}

}
