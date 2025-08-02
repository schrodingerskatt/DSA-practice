/* You are given a number 'n' which represents length of road.
   the road has 'n' plots on it's each side
   The road is to be so planned that there should not be consecutive buildings on either side
   of the road.
   You are required to find and print the number of ways in which the buildings can be built on both sides
   of the road */

import java.util.*;

public class ArrangeBuildings{

    public static void main(string[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int oldspace = 1;
        int oldbuilding = 1;
        for(int i = 2; i <= n; i++){
            int newbuilding = oldspace;
            int newspace = oldbuilding+oldspace;

            oldspace = newspace;
            oldbuilding = newbuilding;
        }
        int count = oldbuilding+oldspace;
        System.out.println(count*count);
        
    }
}