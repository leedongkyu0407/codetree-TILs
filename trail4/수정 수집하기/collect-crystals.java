import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k;
    private static String crystals;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        crystals = bf.readLine();
        
        dp = new int[n+1][2][k+1];
        
        for(int i=0;i<=n;i++) {
            for(int j=0;j<2;j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        dp[0][0][0] = 0;
        solve();
    }

    private static void solve() {
        for(int i=1;i<=n;i++) {
            char crystal = crystals.charAt(i-1);
            int target = (crystal=='L') ? 0 : 1;
            for(int j=0;j<2;j++) {
                for(int c=0;c<=k;c++) {

                    // 보석 안먹음
                    if(dp[i-1][j][c]!=-1) {
                        dp[i][j][c] = Math.max(dp[i-1][j][c], dp[i][j][c]);
                    }

                    // 보석 먹음
                    for(int prev=0;prev<2;prev++) {
                        int moveCost = (prev==target) ? 0 : 1;

                        if(c-moveCost>=0 && dp[i-1][prev][c-moveCost]!=-1) {
                            dp[i][target][c] = Math.max(dp[i][target][c], dp[i-1][prev][c-moveCost]+1);
                        }   
                    }
                }
            }
        }

        int ans = 0;
        for(int i=0;i<=n;i++) {
            for(int j=0;j<2;j++) {
                for(int c=0;c<=k;c++) {
                    ans = Math.max(dp[i][j][c], ans);
                }
            }
        }
        System.out.println(ans);
    }
}