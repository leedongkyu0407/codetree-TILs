import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[] coins, dp;
    
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        coins = new int[n+1];
        dp = new int[m+1];

        st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve());
    }

    private static int solve() {
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if (i < coins[j]) continue;
                dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
            }
        }

        if(dp[m]==10001) {
            return -1;
        } else {
            return dp[m];
        } 
    }
}