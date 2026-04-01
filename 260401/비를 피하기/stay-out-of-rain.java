import java.util.*;
import java.io.*;

public class Main {
    
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, h, m;
    private static int[][] board, result;
    private static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        result = new int[n][n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(sb.toString()); 
    }

    private static void solve() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (board[i][j]==2) {
                    result[i][j] = findRoute(i, j);
                }
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }

    private static int findRoute(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            if (board[now[0]][now[1]]==3) {
                return now[2];
            }

            for(int[] delta: deltas) {
                int nx = now[0]+delta[0];
                int ny = now[1]+delta[1];
                if (!inRange(nx, ny) || visited[nx][ny]) continue;
                if (board[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, now[2]+1});
            }
        }
        return -1;
    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}