import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, ans;
    private static int[][] board;
    private static boolean[][] visited;
    private static int[][] deltas = {{1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        ans = 0;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(ans);
    }

    private static void dfs(int x, int y) {
        if (x==n-1 && y==m-1) {
            ans = 1;
        }

        for (int[] delta : deltas) {
            int nx = x+delta[0];
            int ny = y+delta[1];

            if(!(inRange(nx, ny) && isPossible(nx, ny))) continue;
            if (visited[nx][ny]) continue;
            
            visited[nx][ny] = true;
            dfs(nx, ny);
        }

    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<m;
    }

    private static boolean isPossible(int x, int y) {
        return board[x][y]==1;
    }
}