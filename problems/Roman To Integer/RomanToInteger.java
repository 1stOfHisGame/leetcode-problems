class Solution {
    public int romanToInt(String s) {
		
		// creating a dictionary to save integers against all possible letters we can face
		HashMap<String, Integer> chart = new HashMap<String, Integer>();

		chart.put("M", 1000);
		chart.put("CM", 900);
		chart.put("D", 500);
		chart.put("CD", 400);
		chart.put("C", 100);
		chart.put("XC", 90);
		chart.put("L", 50);
		chart.put("XL", 40);
		chart.put("X", 10);
		chart.put("IX", 9);
		chart.put("V", 5);
		chart.put("IV", 4);
		chart.put("I", 1);

		int integer = 0;
		int i = 0;
		
		// iterate over all the characters in string except the last one...
		while (i < s.length() - 1) {

			//...because we'll first see if the pair of characters is present in our dictionary;
			// in this case looping until the last position would give us an error here, hence skipping last position
			Integer number = chart.get(s.substring(i, i + 2));
			
			// if the pair of characters found in dictionary...
			if (number != null) {
				integer += number; //...add it to our integer and...
				i += 2; //...move 2 positions ahead
			} else {
				integer += chart.get(s.substring(i, i + 1)); //...otherwise there's definitely going to be at least the one character in dictionary 
				i++; //...move 1 position ahead
			}
		}
		
		// since we skipped iterating over last postion...
		if(i == s.length()-1) //...check if we're at the last postion; this means, we have one more character to convert
			integer += chart.get(s.substring(i, i + 1)); //...add that remaining integer
		
		return integer;
	}
}
