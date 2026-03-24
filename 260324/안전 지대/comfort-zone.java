import java.util.*;
import java.io.*;

public class Main {

    private static int n, m, maxK, cnt, ansCnt, ansK;
    private static int[][] board;
    private static boolean[][] visited;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static void solve() {
        for(int k=1;k<maxK;k++) {
            cnt = 0;
            visited = new boolean[n][m];
            for (int x=0;x<n;x++) {
                for (int y=0;y<m;y++) {
                    if (visited[x][y]) continue;
                    if (board[x][y]<=k) continue;
                    cnt++;
                    visited[x][y] = true;
                    dfs(x, y, k);
                }
            }
            if (ansCnt<cnt) {
                ansCnt = cnt;
                ansK = k;
            }
        }
    }

    private static void dfs(int x, int y, int k) {
        for (int[] delta: deltas) {
            int nx = x+delta[0];
            int ny = y+delta[1];
            if (!inRange(nx, ny)) continue;
            if (visited[nx][ny]) continue;
            if (board[nx][ny]<=k) continue;
            visited[nx][ny] = true;
            dfs(nx, ny, k);
        }
    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<m;
    }

    private static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        maxK = 0;
        cnt = 0;
        ansCnt = 0;
        ansK = 0;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxK = Math.max(maxK, board[i][j]);
            }
        }
    }
    
    private static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(ansK).append(" ").append(ansCnt);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        input();
        solve();
        print();
    }

}