class Solution {
    
    public boolean dp(int start, int end, String s, List<String> wordD,HashMap<String,Boolean> memoi){
        String dpKey = new String(start+""+end);
        if(memoi.containsKey(dpKey))
            return memoi.get(dpKey);
        boolean result = false;
        String comparisonString = start == end ? Character.toString(s.charAt(start)) : s.substring(start,end+1);
        int start1 = start, start2 = start;
        int end1 = end, end2 = end;
        if(wordD.contains(comparisonString)){
            end1++;
            start1 = end1;
            if(end1 >= s.length())
                result = true;
            else result = dp(start1,end1,s,wordD,memoi);
        }
        if(result == false) {
            end2++;
            if(end2 >= s.length())
                result = false;
            else result = dp(start2,end2,s,wordD,memoi);
        }
        memoi.put(dpKey,result);
        return result;
    }
    
    public boolean wordBreak(String s, List<String> wordD) {
        HashMap<String, Boolean> memoi = new HashMap<String, Boolean>(); 
        return dp(0,0,s,wordD,memoi);
    }
}
