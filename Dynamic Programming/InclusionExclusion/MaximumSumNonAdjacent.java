import java.util.*;

public class MaximumSumNonAdjacent{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int old_exclusion = 0;
        int old_inclusion = arr[0];
        for(int i = 1; i < n; i++){

            int new_inclusion = old_exclusion+arr[i];
            int new_exclusion = Math.max(old_exclusion, old_inclusion);

            old_exclusion = new_exclusion;
            old_inclusion = new_inclusion;

        }
        System.out.println(Math.max(old_exclusion, old_inclusion));
    }
}