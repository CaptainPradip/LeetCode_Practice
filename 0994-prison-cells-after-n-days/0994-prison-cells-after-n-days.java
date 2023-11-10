class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        if(cells==null || cells.length ==0 || n<=0) return cells;
        boolean hasCycle = false;
        int cycle =0 ;
        HashSet<String> set = new HashSet<>();
        for(int i=0;i< n ;i++){
            int [] next = nextDay(cells);
            String key = Arrays.toString(next);
            if(!set.contains(key)){
                set.add(key);
                cycle++;
            }else{
                hasCycle= true;
                break;
            }
            cells = next;
        }
        if(hasCycle){
            n%=cycle; // as we got the cycle as per game of life it will repeat it self 
              for(int i=0;i<n ;i++){
                   cells = nextDay(cells);
              }
        }
        return cells; 
        
    }



    private int[] nextDay(int[] cells ){
        // If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
        // 1 : occupied
        // 0 : vacant
        int [] temp = new int [cells.length];
        for(int i=1; i<temp.length-1;i++ ){ // as last and 1st dont have neighbors 
            temp[i]= cells[i-1]==cells[i+1] ? 1:0;
        }
        return temp;
    }
}