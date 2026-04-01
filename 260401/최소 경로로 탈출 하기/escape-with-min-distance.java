import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, ans;
    private static int[][] board;
    private static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = -1;
        escape();
        System.out.println(ans);
    }

    private static void escape() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[n][m];
        int dist = 0;
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0]==n-1 && now[1]==m-1) {
                ans = now[2];
                return;
            }
            for(int[] delta: deltas) {
                int nx = now[0]+delta[0];
                int ny = now[1]+delta[1];
                if (!inRange(nx, ny)) continue;
                if (board[nx][ny]==0) {
                    visited[nx][ny] = true;
                    continue;
                }
                q.add(new int[]{nx, ny, now[2]+1});
                visited[nx][ny] = true;
            }
        }

        return;
    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<m; 
    }
}