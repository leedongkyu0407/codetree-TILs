import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] nums, dp;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        nums = new int[n+1];
        dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = nums[i];
        }
        System.out.println(solve());
    }

    private static int solve() {
        int answer = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) {
            dp[i] = Math.max(dp[i], dp[i-1]+nums[i]);
            answer = Math.max(dp[i], answer);
        }
        return answer;
    }
}