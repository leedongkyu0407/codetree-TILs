import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static int[] weights, values, dp;
    
    public static void main(String[] args) throws IOException{
        init();
        System.out.println(solve());
    }

    private static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        weights = new int[n+1];
        values = new int[n+1];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[m+1];
    }

    private static int solve() {
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if (i-weights[j] < 0) continue;                
                dp[i] = Math.max(dp[i], dp[i-weights[j]]+values[j]);
            }
        }

        int answer = 0;
        for(int i=1;i<=m;i++) {
            answer = Math.max(dp[i], answer);
        }
        return answer;
    }
}