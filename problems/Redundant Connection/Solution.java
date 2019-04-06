class Solution {
    int parent[];
    public int find(int x){
            if(parent[x] == 0)
                return x;
            else return find(parent[x]);
        }
    
    public void union(int findx, int findy){
            parent[findx] = findy;
        }
    
    public int[] findRedundantConnection(int[][] edges) {
        //parent = new int[edges.length*(edges.length-1)/2+1];
        //parent = new int[edges.length+1];
        parent = new int[1001];
        
        for(int i=0; i<edges.length; i++){
            int findx = find(edges[i][0]);
            int findy = find(edges[i][1]);
            if(findx == findy)
                return edges[i];
            else {
                union(findx, findy);
            }
        }
        return new int[]{0,0};
    }
}
