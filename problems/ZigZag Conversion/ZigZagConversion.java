class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        
        int fin = numRows+1;
        String res = new String();
        for(int i = 0; i < numRows; i++){
            
            if(i == numRows-1)
                fin = numRows;
            else fin--;
            int fout = (fin-2)*2 + 2;
            int foutBT = (i+1-2)*2 + 2;
            if(i == numRows-1)
                foutBT = 0;
            int j = i;
            while(j < s.length()){
                res = res + Character.toString(s.charAt(j));
                if(j + fout < s.length() && foutBT != 0)
                    res = res + Character.toString(s.charAt(j+fout));
                if(foutBT == 0)
                    j = j + fout;
                else j = j + fout + foutBT;
            }
        }
        return res;
    }
}
