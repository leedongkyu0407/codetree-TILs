import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][] lines;
    private static int[] dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        lines = new int[n][2];
        dp = new int[n];

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<2;j++) {
                lines[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(lines, (o1, o2) ->  {
            return o1[0]-o2[0];
        });

        Arrays.fill(dp, 1);
        
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if (lines[i][0] <= lines[j][1]) continue;
                dp[i] = Math.max(dp[j]+1, dp[i]);
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++) {
            ans = Math.max(dp[i], ans);
        }

        System.out.println(ans);
    }
}