import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, sumA;
    private static int[] nums;
    private static boolean[][] dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        nums = new int[n+1];
        sumA = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sumA += nums[i];
        }

        String answer = "";
        if (sumA%2==1) {
            answer = "No";
        } else {
            sumA /= 2;
            dp = new boolean[n+1][sumA+1];
            dp[0][0] = true;
            answer = solve();
        }

        System.out.println(answer);
    }

    private static String solve() {
        for (int i=1;i<=n;i++) {
            for(int j=0;j<=sumA;j++) {
                if(nums[i] <= j && dp[i-1][j-nums[i]]) {
                    dp[i][j] = true;
                }

                if(dp[i-1][j]) {
                    dp[i][j] = true;
                }
            }
        }

        if (dp[n][sumA]) {
            return "Yes";
        }

        return "No";
    }
}