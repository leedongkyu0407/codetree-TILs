import java.util.*;
import java.io.*;

public class Main {

    private static int n, k, cnt;
    private static int[][] board, startPoint;
    private static boolean[][] visited;
    private static Queue<int[]> q = new ArrayDeque<>();
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n+1][n+1];
        startPoint = new int[k][2];
        visited = new boolean[n+1][n+1];

        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<k;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<2;j++) {
                startPoint[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 0;
        for(int i=0;i<k;i++) {
            int startX = startPoint[i][0];
            int startY = startPoint[i][1];
            if (board[startX][startY]==1 || visited[startX][startY]) continue;
            visited[startX][startY] = true;
            q.add(new int[]{startX, startY});
            bfs();
        }

        System.out.println(cnt);
    }

    private static void bfs() {
        while(!q.isEmpty()) {
            int[] now = q.poll();
            cnt++;
            for(int[] delta: deltas) {
                int nx = now[0]+delta[0];
                int ny = now[1]+delta[1];
                if (!inRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny]==1) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }
}