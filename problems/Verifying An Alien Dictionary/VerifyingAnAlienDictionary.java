class Solution {
    
    public static boolean compare(String a, String b,HashMap<String,Integer> letterOrder) {
		if(a.length() < b.length()) {
			for(int i=0;i<a.length();i++) {
                int avalue = letterOrder.get(Character.toString(a.charAt(i)));
                int bvalue = letterOrder.get(Character.toString(b.charAt(i)));
				if(avalue > bvalue) {
					return false;
				}
                else if(avalue < bvalue)
                    return true;
			}
			return true;
		}
			
		else {
			for(int i=0;i<b.length();i++) {
				int avalue = letterOrder.get(Character.toString(a.charAt(i)));
                int bvalue = letterOrder.get(Character.toString(b.charAt(i)));
				if(avalue > bvalue) {
					return false;
				}
                else if(avalue < bvalue)
                    return true;
			}
            if(a.length() == b.length()) {
				return true;
			}
			else return false;
		}
			
	}
    
    public boolean isAlienSorted(String[] words, String order) {
        	HashMap<String, Integer> letterOrder = new HashMap<String, Integer>();
		for(int i=0; i<order.length(); i++) {
			letterOrder.put(Character.toString(order.charAt(i)), i);
		}
		
		for(int i=0;i<words.length-1;i++) {
			if(!compare(words[i],words[i+1],letterOrder))
				return false;
		}
		return true;
    }
}
