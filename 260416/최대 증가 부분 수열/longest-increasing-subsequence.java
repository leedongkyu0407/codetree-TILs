import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int[] ar, dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        ar = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if (ar[j] >= ar[i]) continue;
                dp[i] = Math.max(dp[j]+1, dp[i]);
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}