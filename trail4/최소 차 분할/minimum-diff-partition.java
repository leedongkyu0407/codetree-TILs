import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, sumA;
    private static int[] nums;
    private static boolean[] dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        nums = new int[n+1];
        sumA = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sumA += nums[i];
        }
        dp = new boolean[sumA+1];
        dp[0] = true;
        System.out.println(solve());
    }

    private static int solve() {
        for(int i=1;i<=n;i++) {
            for(int j=sumA;j>=nums[i];j--) {
                if (!dp[j-nums[i]]) continue;
                dp[j] = true;
            }
        }

        int answer = 100000;

        for(int i=1;i<=sumA;i++) {
            if (dp[i])
                answer = Math.min(answer, Math.abs(sumA-i-i));
        }
        return answer;
    }
}