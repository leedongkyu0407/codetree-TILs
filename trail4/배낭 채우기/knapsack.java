import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[][] dp;
    private static int[] w, v;

    public static void main(String[] args) throws IOException{
        initialSetting();
        System.out.println(solve());
    }

    private static void initialSetting() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        w = new int[n+1];
        v = new int[n+1];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1][m+1];
    }

    private static int solve() {
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                dp[i][j] = dp[i-1][j];
                if(w[i] <= j){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]]+v[i]);
                }
            }
        }

        return dp[n][m];
    }
}