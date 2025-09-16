import java.util.*;

class LongestValidObstacleCourse {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {

        int n = obstacles.length;
        int[] ans = new int[n];
        int[] upper_bound = new int[n];

        int size = 0;
        for(int i = 0; i < n; i++){

            int ele = obstacles[i];
            int low = 0;
            int high = size;

            while(low < high){
                int mid = low+(high-low)/2;
                if(upper_bound[mid] <= ele){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }
            ans[i] = low+1;
            upper_bound[low] = ele;
            if(low == size) size++;
        }
    return ans;    
    }
}