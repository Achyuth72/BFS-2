//TIme complexity:O(V+E)
//SpaceComplexity:O(v+E)

class Solution {
    public int orangesRotting(int[][] grid) {
        //edge
        if(grid==null || grid.length==0) return 0;
        int fresh=0;
        int m=grid.length; int n=grid[0].length;
        int time=0;
        Queue<int[]>q=new LinkedList<>();
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1) fresh++;
                
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j});
                }
            }
        }
        
        if(fresh==0) return 0;
        while(!q.isEmpty())
        {
            int size=q.size();
             for(int i=0;i<size;i++)
             {
            int[] curr=q.poll();
            int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
            
            for(int dirs[]:dir)
            {
                int r=curr[0]+dirs[0];
                int c=curr[1]+dirs[1];
                
                if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1)
                {
                    fresh--;
                    grid[r][c]=2;
                    q.add(new int[]{r,c});
                }
            }
               }
           
         time++;
        }
        if(fresh>0) return -1;
        return time-1;
    }
}
