class Solution {
    public int scheduleCourse(int[][] courses) {
        // 1. Sort the arrray Based on end day
        // 2. Take the course having currentTime+ courseTime <= courseEndTime
        // 3. else find the course with large duartion course with current course;
        // 
        Arrays.sort(courses,(a,b)-> a[1]- b[1]);
        int time = 0;
        int count=0;
        for(int i =0; i< courses.length;i++){
            if(time+courses[i][0]<=courses[i][1]){
                time+=courses[i][0];
                count++;
            }else{
                int max_i = i;
                for(int j =0; j<i;j++){
                    if(courses[j][0]>courses[max_i][0]){
                        max_i=j;
                    }
                }
                if(courses[max_i][0]> courses[i][0]){
                    time+= courses[i][0] - courses[max_i][0];
                }
                courses[max_i][0] =-1;
            }
        }
        return count;
        
    }
}