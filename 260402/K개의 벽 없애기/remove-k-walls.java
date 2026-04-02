import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k, ans;
    private static int[][] board;
    private static int[][] startEnd = new int[2][2];
    private static List<int[]> walls = new ArrayList<>();
    private static boolean[][] removed;
    private static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j]==1)
                    walls.add(new int[]{i, j});
            }
        }

        for(int i=0;i<2;i++) {
            st = new StringTokenizer(bf.readLine());
            startEnd[i][0] = Integer.parseInt(st.nextToken());
            startEnd[i][1] = Integer.parseInt(st.nextToken());
        }
        ans = Integer.MAX_VALUE;
        pick(0, 0, new boolean[walls.size()]);
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);
    }

    private static void pick(int depth, int start, boolean[] visited) {
        if (depth == k) {
            setRemoved(visited);
            bfs();
            return;
        }

        for(int i=start;i<walls.size();i++) {
            if(visited[i]) continue;
            visited[i] = true;
            pick(depth+1, i+1, visited);
            visited[i] = false;
        }
    }

    private static void setRemoved(boolean[] visited) {
        removed = new boolean[n+1][n+1];
        for(int i=0;i<walls.size();i++) {
            if(visited[i]) {
                int x = walls.get(i)[0];
                int y = walls.get(i)[1];
                removed[x][y] = true;
            }
        }
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n+1][n+1];

        int x = startEnd[0][0];
        int y = startEnd[0][1];
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0]==startEnd[1][0] && now[1]==startEnd[1][1]) {
                ans = Math.min(ans, now[2]);
            }
            for(int[] delta: deltas) {
                int nx = now[0]+delta[0];
                int ny = now[1]+delta[1];
                if (!inRange(nx, ny) || visited[nx][ny]) continue;
                if (board[nx][ny]==1 && !removed[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, now[2]+1});
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }
}