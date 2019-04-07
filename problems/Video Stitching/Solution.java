class Solution {
    public int videoStitching(int[][] clips, int T) {
        if(T == 0) return 0;
        int clipCount = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<clips.length; i++){
            if(map.containsKey(clips[i][0])){
                if(map.get(clips[i][0]) < clips[i][1]){
                    map.replace(clips[i][0], clips[i][1]);
                }
            } else map.put(clips[i][0], clips[i][1]);
        }
        
        int rem = 0, i = 1;
            if(map.containsKey(0) && map.get(0)>rem){
                clipCount++;
                rem = map.get(0);
                map.remove(0);
                while(rem < T && i<T && map.size()>0){
                    int maxrem = rem;
                    while(i <= rem && map.size()>0){
                        if(map.containsKey(i)){
                            if(map.get(i)>maxrem){
                                maxrem = map.get(i);
                            }
                            map.remove(i);
                        }
                        i++;
                    }
                    if(maxrem > rem) {
                        clipCount++;
                        rem = maxrem;
                    } else i++;
                }
            }
        if(rem < T) return -1;
        return clipCount;
    }
}
