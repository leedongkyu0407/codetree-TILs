import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[] dp = new long[1001];

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;
        long sum = 1;

        for(int i=3;i<=n;i++) {
            dp[i] = ((dp[i-2]*3) + (dp[i-1]*2) + 2*sum)%1000000007;
            sum=(sum+dp[i-2])%1000000007;
        } 

        System.out.println(dp[n]);
    }
}