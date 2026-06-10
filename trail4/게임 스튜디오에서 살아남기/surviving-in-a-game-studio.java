import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][][] dp;
    private static final int DIV = 1000000007;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        dp = new int[n+1][3][3];
        dp[0][0][0] = 1;
        System.out.println(solve());
    }

    private static long solve() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<=2;j++) {
                for(int k=0;k<=2;k++) {
                    if(dp[i][j][k]==0) continue;
                    // g 1추가
                    dp[i+1][0][k] = (dp[i+1][0][k]+dp[i][j][k])%DIV;                    
                    
                    // b 1 추가
                    if(j<2) {
                        dp[i+1][j+1][k] = (dp[i+1][j+1][k]+dp[i][j][k])%DIV;
                    }
                        
                    // t 1 추가
                    if(k<2) {
                        dp[i+1][0][k+1] = (dp[i+1][0][k+1]+dp[i][j][k])%DIV;                        
                    }
                }
            }
        }

        long answer = 0;
        for(int i=0;i<=2;i++) {
            for(int j=0;j<=2;j++) {
                answer = (answer+dp[n][i][j])%DIV;
            }
        }
        return answer;
    }
}