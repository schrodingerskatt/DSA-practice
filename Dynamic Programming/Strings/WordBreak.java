import java.util.*;

public class WordBreak{

    public static boolean WordBreakSolution(String scentence, HashSet<String>dictionary){

        int[] dp = new int[scentence.length()];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                String Word_To_Check = scentence.substring(j,i+1);
                if(dictionary.contains(Word_To_Check)){
                    dp[i]+=dp[j];
                }
            }
        }
    }

    public static void main(String[] args)throws Exception{

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String>dictionary = new HashSet<String>();
        for(int i = 0; i < n; i++){
            dictionary.add(sc.next());
        }
        String scentence = sc.next();
        System.out.println(WordBreakSolution(scentence, dictionary));
    }
}