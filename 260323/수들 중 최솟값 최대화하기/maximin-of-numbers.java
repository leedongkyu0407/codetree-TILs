import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, ans;
    private static int[][] board;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        board = new int[n][n];
        visited = new boolean[n];
        ans = 0;

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, Integer.MAX_VALUE);
        System.out.println(ans);
    }

    private static void dfs(int depth, int nowNum) {
        if (depth == n) {
            ans = Math.max(ans, nowNum);
            return;
        }

        for(int i=0;i<n;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(depth+1, Math.min(nowNum, board[depth][i]));
            visited[i] = false;
        }
    }
}