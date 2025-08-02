/*
No. of Binary Strings of length 'n' which have no consecutive 0's
*/


import java.util.*;

public class Main{

    public static void main(string[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int old_zero_count = 1;
        int old_one_count = 1;

        for(int i = 2; i <= n; i++){
            int new_zero_count = old_one_count;
            int new_one_count = old_one_count+old_zero_count;

            old_one_count = new_one_count;
            old_zero_count = new_zero_count;
        }
        System.out.println(old_one_count+old_zero_count);


    }
}