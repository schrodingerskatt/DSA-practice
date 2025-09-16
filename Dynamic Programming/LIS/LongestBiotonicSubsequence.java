import java.util.*;

public class LongestBiotonicSubsequence{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int[] lis = new int[n];
        lis[0] = 1;

        for(int i = 0; i < n; i++){
            int maxlen = 0;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    maxlen = Math.max(maxlen, lis[j]);
                }
            }
            lis[i] = maxlen+1;
        }

        int[] lds = new int[n];
        lds[n-1] = 1;
        for(int i = n-1; i >=0; i--){
            int maxlen = 0;
            for(int j = n-1; j > i; j--){
                if(arr[j] > arr[i]){
                    maxlen = Math.max(maxlen, lds[j]);
                }
            }
            lds[i] = maxlen+1;
        }

        int ans = 1;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, lis[i]+lds[i]-1);
        }

        System.out.println(ans);
    }
}