import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        dp = new int[46];
        dp[1] = 1;
        
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-2]+dp[i-1];
        }

        System.out.println(dp[n]);
    }
}