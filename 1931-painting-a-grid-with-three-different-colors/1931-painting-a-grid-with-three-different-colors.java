class Solution {
    public int colorTheGrid(int m, int n) {
        //each permutation will be encoded as Long where every color will be packed into 0xFF byte 
        //for example RGB combination will be represented as 0x010204
        //while BGRGB combination will be 0x0402010204
        final long R = 1;
        final long G = 2;
        final long B = 4;
        final int MOD =1000000007;
        
        //compute overall number of possible permutations for a single column
        int COUNT = 3;
        for(int i=0;i<m-1;i++)
            COUNT*=2;
        
        long[] perms = new long[COUNT];
        Queue<Long> q = new LinkedList<>();
                
        q.add(R);
        q.add(G);
        q.add(B);
        
        //fill in all possible permuatations using Queue
        int ind = COUNT;
        while(!q.isEmpty()){
            Long l  = q.poll();
            if( l >=  1L << 8*(m-1) ) //m-length permutation
                perms[--ind] = l;
            else{
                if( (l & R) != 0 ){
                    q.add( (l<<8) + G);
                    q.add( (l<<8) + B);
                }else if( (l & B) != 0 ){
                    q.add( (l<<8) + R);
                    q.add( (l<<8) + G);
                }else{
                    q.add( (l<<8) + R);
                    q.add( (l<<8) + B);
                }
            }
        }
        
        
        
        int[] prev = new int[COUNT];
        int[] curr = new int[COUNT];
        Arrays.fill(prev, 1);
        
        //iterate by columns from left to right, 
        //memorizing score count for every permutation in previous column
        for(int iter=0;iter<n-1;iter++){
            for(int i=0;i<COUNT;i++){
                for(int j=0;j<COUNT;j++){
                    if((perms[i] & perms[j]) == 0) // both are OK to each other 
                        curr[j] = (curr[j]+prev[i])%MOD;

                }
            }
            //swap buffers and erase
            int[] t = prev;
            prev = curr;
            curr = t;
            Arrays.fill(curr,0);
        }
        
        //accumulate all scores for permuttions as per last collumn 
        int result = 0;
        for(int i=0;i<COUNT;i++)
            result = (result + prev[i])%MOD;
        
        return result;    
    }
}