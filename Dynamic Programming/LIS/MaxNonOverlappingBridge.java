import java.util.*;

public class MaxNonOverlappingBridge{

     static List<Integer> LISwithPath(int[] arr) {

        int n = arr.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxlen = 1;
        int lastIndex = 0;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    parent[i] = j;
                }
            }
            if(dp[i] > maxlen){
                maxlen = dp[i];
                lastIndex = i;
            }
        }
        LinkedList<Integer>path = new LinkedList<>();
        int idx = lastIndex;
        while(idx != -1){
            path.addFirst(idx);
            idx = parent[idx];
        }
        return path;
     }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] bridges = new int[n][2];

        for(int i = 0; i < n; i++){
            bridges[i][0] = sc.nextInt();
            bridges[i][1] = sc.nextInt();
        }

        Arrays.sort(bridges, (a,b) ->{
             if(a[0] == b[0]) return a[1]-b[1];
             return a[0]-b[0];
        });

        int[] south = new int[n];
        for(int i = 0; i < n; i++){
            south[i] = bridges[i][1];
        }

        List<Integer>lisIndices = LISwithPath(south);
        System.out.println("Maximum number of non-overlapping bridges: " + lisIndices.size());
        System.out.println("Bridges selected:");
        for (int idx : lisIndices) {
            System.out.println("(" + bridges[idx][0] + "," + bridges[idx][1] + ")");
        }
    }
}