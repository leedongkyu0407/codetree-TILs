import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] dp = new int[1001];

        dp[1] = 2;
        dp[2] = 7;
        for(int i=3;i<=n;i++) {
            dp[i] = ((dp[i-2]*3) + (dp[i-1]*2) + 2)%1000000007;
        } 

        System.out.println(dp[n]);
    }
}