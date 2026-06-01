import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, idx1, idx2;
    private static int[][] cards;
    private static int[][] dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        cards = new int[2][n];

        for(int i=0;i<2;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n+1][n+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }
        
        dp[0][0] = 0;
        solve();
    }

    private static void solve() {
        int answer = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (dp[i][j] == -1) continue;
                // case2. 둘 다 버리기
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]);

                // case1. 대결
                if (cards[0][i] < cards[1][j]) {
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
                } else if (cards[0][i] > cards[1][j]) {
                    dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j]+cards[1][j]);
                } else {
                    dp[i+1][j+1] = dp[i][j];
                }
            }
        }

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.println(answer);
    }
}