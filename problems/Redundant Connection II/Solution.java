class Solution {
    
    public int find(int[] parent, int x){
        if(parent[x] == 0) return x;
        else return find(parent, parent[x]);
    }
    
    public void union(int[] parent, int findx, int findy){
        parent[findx] = findy;
    }
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int parent[] = new int[edges.length + 1];
        int set[] = new int[edges.length + 1];
        
        // initialize two candidates for edges that could be in violation
        int[] cand1 = new int[]{-1,-1};
        int[] cand2 = new int[]{-1,-1};
        
        // fill the two candidate edges if they're present
        for(int i=0; i<edges.length; i++){
            if(set[edges[i][1]] != 0){
                cand1[0] = set[edges[i][1]];
                cand1[1] = edges[i][1];
                cand2[0] = edges[i][0];
                cand2[1] = edges[i][1];
                break; // because there can't be more than one such pair of violating edges
            } else set[edges[i][1]] = edges[i][0];
        }
        
        // union find the edges to check for cycle
        for(int i=0; i<edges.length; i++){
            // but exclude candidate 2
            if(!(edges[i][0]==cand2[0] && edges[i][1]==cand2[1])){
                int findx = find(parent, edges[i][0]);
                int findy = find(parent, edges[i][1]);
                // cycle found
                if(findx==findy){
                    // if candidate node is empty then just return this edge
                    if(cand2[0]==-1 && cand2[1]==-1)
                        return edges[i];
                    // else candidate 2 was existing in tree, but candidate 1 was added last
                    return cand1;
                }
                else {
                    union(parent, findx, findy);
                }
            }
        }
        // if no cycle with candidate 1, it means candidate 2 was added last
        return cand2;
    }
}
