import java.io.*;
import java.util.*;

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
        dp = new boolean[n+1][sumA+1];
        dp[0][0] = true;
        System.out.println(solve2());
    }

    private static int solve2() {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=sumA;j++) {
                if (j >= nums[i] && dp[i-1][j-nums[i]])
                    dp[i][j] = true;
                
                if (dp[i-1][j])
                    dp[i][j] = true;
            }
        }

        int answer = 100000;

        for(int i=1;i<=sumA;i++) {
            if (dp[n][i])
                answer = Math.min(answer, Math.abs(sumA-i-i));
        }
        return answer;
    }

    // private static int solve() {
    //     for(int i=1;i<=n;i++) {
    //         for(int j=sumA;j>=nums[i];j--) {
    //             if (!dp[j-nums[i]]) continue;
    //             dp[j] = true;
    //         }
    //     }

    //     int answer = 100000;

    //     for(int i=1;i<=sumA;i++) {
    //         if (dp[i])
    //             answer = Math.min(answer, Math.abs(sumA-i-i));
    //     }
    //     return answer;
    // }
}