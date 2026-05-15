import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] arr;
    private static int[][] dp;
    private static final int OFFSET = 100000;
    private static final int MAX_SUM = 200000;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        arr = new int[n + 1];
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1][MAX_SUM+1];
        for(int i=0;i<=n;i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][OFFSET] = 0;
        solve();    
    }

// 가능한 경우의 수 
// 이전 차이 j에서 A에 추가 -> j+arr[i];
// 이전 차이 j에서 B에 추가 -> j-arr[i];
// 이전 차이 j에서 C에 추가 -> j;
    private static void solve() {
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=MAX_SUM;j++) {
                if(dp[i-1][j] == -1) continue;

                // case 1. C에 추가
                int realDiff = j-OFFSET;
                int sumA = dp[i-1][j];
                dp[i][j] = Math.max(dp[i][j], sumA);

                // case2. A에 추가
                int newDiff = realDiff+arr[i];
                if (Math.abs(newDiff) <= OFFSET) {
                    int idx = newDiff+OFFSET;
                    dp[i][idx] = Math.max(dp[i][idx], sumA+arr[i]);
                }

                // case3. B에 추가
                int newDiff2 = realDiff-arr[i];
                if (Math.abs(newDiff2) <= OFFSET) {
                    int idx = newDiff2+OFFSET;
                    dp[i][idx] = Math.max(dp[i][idx], sumA);
                }
            }
        }

        System.out.println(Math.max(0, dp[n][OFFSET]));
    }
}