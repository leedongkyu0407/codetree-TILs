import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] map;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int ans = Integer.MAX_VALUE;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        visited = new boolean[n];

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        dfs(1, 0, 0);
        System.out.println(ans);
    }

    private static void dfs(int depth, int now, int sum) {
        if (depth == n) {
            if (map[now][0] != 0) {
                ans = Math.min(ans, sum+map[now][0]);
            }
            return;
        }

        for(int i=0;i<n;i++) {
            if (visited[i]) continue;
            if (map[now][i]==0) continue;
            visited[i] = true;
            dfs(depth+1, i, sum+map[now][i]);
            visited[i] = false;
        }
    }

}