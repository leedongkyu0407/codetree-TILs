import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] dp;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        dp = new int[n+1][10];
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;
        
        for(int i=2;i<=n;i++) {
            for(int j=0;j<10;j++) {
                if(j==9){
                    dp[i][j] = dp[i-1][j-1];
                } else if(j==0) {
                    dp[i][j] = dp[i-1][j+1];
                }else {
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%MOD;
                }
            }
        }

        int ans = 0;
        for(int i=0;i<10;i++) {
            ans = (ans+dp[n][i])%MOD;
        }
        System.out.println(ans);
    }
}
