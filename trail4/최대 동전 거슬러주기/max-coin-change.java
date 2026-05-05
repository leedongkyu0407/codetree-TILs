import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[] coins, dp;

    private static void initialSetting() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        coins = new int[n];
        dp = new int[m+1];
        
        Arrays.fill(dp, -1);
        dp[0] = 0;
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int solve() {
        for(int i=1;i<=m;i++) {
            for(int j=0;j<n;j++) {
                if (i-coins[j]<0) continue;
                if (dp[i-coins[j]]==-1)continue;
                dp[i] = Math.max(dp[i], dp[i-coins[j]]+1);
            }
        }
        return dp[m];
    }
    
    public static void main(String[] args) throws IOException{
        initialSetting();
        System.out.println(solve());
    }
}