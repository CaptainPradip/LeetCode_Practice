class Solution {
public:
    int ans;
    int solve(vector<vector<int>>&g,int i,int j,int p,int cur,int x){
        if(i<0||j<0||i>=g.size()||j>=g[0].size()||(cur==0&&g[i][j]!=2)||(cur==2&&g[i][j]!=0))return 0;
        int op1=0;
        int op2=0;
        if(p==0){
            if(x==0)
            op1+=1+solve(g,i-1,j-1,1,g[i][j],1);
            op2=1+solve(g,i+1,j-1,p,g[i][j],x);
        }else if(p==1){
            if(x==0)
            op1+=1+solve(g,i-1,j+1,2,g[i][j],1);
            op2=1+solve(g,i-1,j-1,p,g[i][j],x);
        }else if(p==2){
            if(x==0)
            op1+=1+solve(g,i+1,j+1,3,g[i][j],1);
            op2=1+solve(g,i-1,j+1,p,g[i][j],x);
        }else if(p==3){
            if(x==0)
            op1+=1+solve(g,i+1,j-1,0,g[i][j],1);
            op2=1+solve(g,i+1,j+1,p,g[i][j],x);
        }
       
        return max(op1,op2);
    }
    int lenOfVDiagonal(vector<vector<int>>& grid) {
        ans=-1;
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[0].size();j++){
                if(grid[i][j]==1){
                    int a=0,b=0,c=0,d=0;
                    a=solve(grid,i+1,j-1,0,0,0);
                    b=solve(grid,i-1,j-1,1,0,0);
                    c=solve(grid,i-1,j+1,2,0,0);
                    d=solve(grid,i+1,j+1,3,0,0);
                    ans=max({ans,a,b,c,d});

                }
            }
        }
        return ans+1;
    }
};