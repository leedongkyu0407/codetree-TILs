import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][] floors;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        
        floors = new int[n][3];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<3;j++) {
                floors[i][j] = Integer.parseInt(st.nextToken());                
            }
        }

        dp = new int[n][3][3];
        for(int i=0;i<3;i++) {
            dp[0][i][i] = floors[0][i];
        }

        solve();
    }

    private static void solve() {
        
        for(int i=1;i<n;i++) {
            for(int j=0;j<3;j++) {
                for(int prev=0;prev<3;prev++) {
                    for(int first=0;first<3;first++) {
                        if(j==prev) continue;

                        if(i==n-1 && first==j) continue;

                        dp[i][j][first] = Math.max(dp[i-1][prev][first]+floors[i][j], dp[i][j][first]);
                    }
                }
            }
        }

        int ans = 0;
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                ans = Math.max(dp[n-1][i][j], ans);
            }
        }
        System.out.println(ans);
    }
}