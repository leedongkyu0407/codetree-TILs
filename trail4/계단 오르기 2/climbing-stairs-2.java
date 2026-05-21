import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] coins;
    private static final int TRY = 3;
    private static int[][] dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        coins = new int[n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1][TRY+1];
        for(int i=0;i<=n;i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;

        System.out.println(solve());
    }

    private static int solve() {
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=TRY;j++) {
                if (j>=1 && dp[i-1][j-1] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+coins[i]);
                }

                if (i>=2 && dp[i-2][j] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-2][j]+coins[i]);
                }
            }
        }

        int answer = 0;
        for(int i=0;i<=TRY;i++) {
            if(dp[n][i]!=-1){
                answer = Math.max(answer, dp[n][i]);
            }
        }
        return answer;
    }
}