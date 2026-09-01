import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        final long NEG = Long.MIN_VALUE / 2;

        long[][][] dp = new long[n + 1][m + 1][2];

        for (long[][] row : dp) {
            for (long[] cell : row) {
                Arrays.fill(cell, NEG);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1]);

                long best = NEG;

                if (dp[i - 1][j][1] > NEG / 2) {
                    best = Math.max(best, dp[i - 1][j][1] + a[i]);
                }

                if (j >= 1 && dp[i - 1][j - 1][0] > NEG / 2) {
                    best = Math.max(best, dp[i - 1][j - 1][0] + a[i]);
                }

                dp[i][j][1] = best;
            }
        }

        long ans = Math.max(dp[n][m][0], dp[n][m][1]);
        System.out.println(ans);
    }
}