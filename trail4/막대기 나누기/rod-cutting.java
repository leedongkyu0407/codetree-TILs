import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] sticks, dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        sticks = new int[n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++) {
            sticks[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1];
        for(int i=1;i<=n;i++) {
            dp[i] = sticks[i];
        }
        System.out.println(solve());
    }

    private static int solve() {
        for(int i=1;i<=n;i++) {
            for(int j=0;j<i;j++) {
                dp[i] = Math.max(dp[i], dp[i-j]+sticks[j]);
            }
        }

        int answer = 0;
        for(int i=1;i<=n;i++) {
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}