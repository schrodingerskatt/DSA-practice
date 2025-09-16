import java.util.*;

public class RussianDollEnvelope{

    public static int maxEnvelopes(int[][] envelopes){

        // Step 1: Sort Envelopes
        Arrays.sort(envelopes, (a,b)->{

            if(a[0] == b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });

        // Step 2: Extract heights
        int[] heights = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            heights[i] = envelopes[i][1];
        }

        // Step 3: Find LIS in heights using binary search
        int[] lis = new int[height.length];
        int size = 0;
        for(int h : heights){
            int idx = binarySearch(lis, 0, size, h);
            lis[idx] = h;
            if(idx == size) size++;
        }
        return size;

    }

    // Manual binary search
    // Find the index where h should be placed in lis[0..size)

    private static int binarySearch(int[] lis, int left, int right, int target){

        while(left < right){
            int mid = left+(right-left)/2;
            if(lis[mid] < target){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args){

        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(envelopes));

    }
}