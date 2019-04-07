class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<Boolean>();
        String capPattern = "";
        
        for(Character c: pattern.toCharArray()){
            if(Character.isUpperCase(c)) capPattern+=c;
        }
        for(String s: queries){
            // check for capital letters in query
            String onlyCapS = "";
            for(Character c: s.toCharArray()){
                if(Character.isUpperCase(c)) onlyCapS+=c;
            }
            
            if(onlyCapS.equals(capPattern) == false){
                res.add(false);
                continue;
            }
            else {
                int start = 0;
                int end = s.length();
                int patStart = 0;
                while(patStart<pattern.length()){
                    if(start<end){
                        int index = s.indexOf(pattern.charAt(patStart), start);
                        if(index < 0) break;
                        start = index+1;
                        patStart++;
                    }
                }
                if(patStart != pattern.length()) res.add(false);
                else res.add(true);
            }
        }
        return res;
    }
}
