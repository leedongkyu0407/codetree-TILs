import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        dp = new int[n+1];
        dp[2] = 1;
        for(int i=3;i<=n;i++) {
            if (i==3) {
                dp[i] = 1;
                continue;
            }
            dp[i] = dp[i-2]+dp[i-3];
        }
        System.out.println(dp[n]%10007);
    }
}