import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int[] nums = new int[n];
        int[][] dp = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], 1);
        }
        
        // DP 계산
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) continue;
                
                if (nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                } else { // nums[i] < nums[j]
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i][0]);
            answer = Math.max(answer, dp[i][1]);
        }
        
        System.out.println(answer);
    }
}