class Solution {
    
    public static void explore(int i, int j, int[][] map, int[][] A){
        int row = map.length;
        int col = map[0].length;
        if(A[i][j] == 0 || map[i][j] == 1 || i == 0 || i == row-1 || j == 0 || j == col-1){
            return;
        }
        if(A[i][j] == 1){
            map[i][j] = 1;
            // left
            explore(i,j-1,map,A);
            // right
            explore(i,j+1,map,A);
            // top
            explore(i-1,j,map,A);
            // bottom
            explore(i+1,j,map,A);
        }
    }
    
    public int numEnclaves(int[][] A) {
        int landEnclosedBySea = 0;
        int row = A.length;
        int col = A[0].length;
        int[][] map = new int[row][col];
        
        // top and bottom row
        for(int i=0; i<row; i+=row-1){
            // include all squares in row
            for(int j=0; j<col; j++){
                if(A[i][j] == 1){
                    map[i][j] = 1; // this land area can fall off
                    explore(i==0?i+1:i-1,j,map,A);
                }
            }
        }
        
        // middle rows
        for(int i=1; i<row-1; i++){
            // include only edge squares
            for(int j=0; j<col; j+=col-1){
                if(A[i][j] == 1){
                    map[i][j] = 1;
                    explore(i,j==0?j+1:j-1,map,A);    
                }
            }
        }
        
        // now count the number of unvisited land squares to get answer
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(A[i][j] == 1 && map[i][j] == 0)
                    landEnclosedBySea++;
            }
        }
        
        return landEnclosedBySea;
    }
}
