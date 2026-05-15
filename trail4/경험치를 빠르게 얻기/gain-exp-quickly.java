import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, sumE, sumT;
    private static int[] exp, times;
    private static int[][] dp;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        exp = new int[n+1];
        times = new int[n+1];

        sumE = 0;
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            exp[i] = Integer.parseInt(st.nextToken());
            times[i] = Integer.parseInt(st.nextToken());
            sumE += exp[i];
            sumT += times[i];
        }

        dp = new int[n+1][sumT+1];
        for(int i=0;i<=n;i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        System.out.println(solve2());
    }

// 구해야 하는 것 : 걸리는 총 시간의 최솟값
// i : 현재 고려하는 퀘스트
// j : 도달할 수 있는 시간
// dp[i][j] -> i번째 퀘스트까지 고려했을 때, j시간에 얻을 수 있는 최대 경험치
// case 1: i번째 퀘스트를 수행해서 시간이 j가 되는 경우
// case 2: i번째 퀘스트를 수행하지 않고 시간이 j가 되는 경우
    private static int solve2() {
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=sumT;j++) {
                // case 1
                if(times[i] <= j && dp[i-1][j-times[i]]!=-1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-times[i]]+exp[i]);
                }

                // case 2
                if (dp[i-1][j] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
            }
        }

        for(int i=1;i<=sumT;i++) {
            if (dp[n][i] >= m) {
                return i;
            }
        }

        return -1;
    }

// 구해야 하는 것 : 걸리는 총 시간의 최솟값 -> dp[i][j];
// i : 현재 고려하는 퀘스트
// j : 얻을 수 있는 경험치
// case 1: i번째 퀘스트를 수행해서 경험치가 j가 되는 경우
// case 2: i번째 퀘스트를 수행하지 않고 경험치가 j가 되는 경우
// 메모리 초과 
    private static int solve() {
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=sumE;j++) {
                // case 1
                if (exp[i] <= j && dp[i-1][j-exp[i]]!=Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-exp[i]]+times[i]);
                }

                // case 2
                if (dp[i-1][j] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=m;i<=sumE;i++) {
            if (dp[n][i]==-1) continue;
            answer = Math.min(answer, dp[n][i]);
        }
        if (answer == Integer.MAX_VALUE) {
            return -1;
        } 

        return answer;
    }
}