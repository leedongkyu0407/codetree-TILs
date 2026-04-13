import java.io.*;
import java.util.*;

public class Main {
    private static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++) {
            dp[i] = (dp[i-1]+dp[i-2])%10007;
        }  

        System.out.println(dp[n]);
    }
}