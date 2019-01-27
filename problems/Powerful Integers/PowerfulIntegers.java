class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> res = new ArrayList<Integer>();
        int i=0,j=-1;
        Boolean flag = false;
        while(true){
            Double sumA = Math.pow(x,i);
            if(sumA > bound || i > bound)
                break;
            while(true){
                j++;
                Double sumB = Math.pow(y,j);
                if(sumA+sumB > bound || j > bound){
                    flag = true;
                    break;
                } else {
                    //System.out.println("i:"+i+" J"+j);
                    if(!res.contains((int)(sumA + sumB)))
                        res.add((int)(sumA + sumB));
                }
            }
        if(flag){
            i++;
            j = -1;
        }
        }
        return res;
    }
}
