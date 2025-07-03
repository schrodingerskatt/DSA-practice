import java.util.*;

/* There are 'n' fences and 'k' colors, we have to paint 'n' fences using 'k' colors, such that no more than
2 fences should have same color*/

public class PaintFence{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long same = k*1;
        long diff = k*(k-1);
        long total = same+diff;

        for(int i = 3; i <=n; i++){
            same = diff*1;
            diff = total*(k-1);
            total = same+diff;
        }
        System.out.println(total);

    }
}