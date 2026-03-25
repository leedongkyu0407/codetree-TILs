import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k, m, ans;
    private static int[][] board;
    private static int[][] deltas = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    private static List<int[]> rocks = new ArrayList<>();
    private static List<int[]> startPoints = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        initialSetting();
        comb(0, 0, 0);
        System.out.println(ans);
    }

    private static void initialSetting() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];

        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j]==1) rocks.add(new int[]{i, j});
            }
        }

        for(int i=0;i<k;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            startPoints.add(new int[]{x, y});
        }

        ans = 0;
    }

    private static void comb(int depth, int start, int flag) {
        if (depth == m) {
            int count = solve(flag);
            ans = Math.max(ans, count);
            return;
        }

        for(int i=start;i<rocks.size();i++) {
            comb(depth+1, i+1, flag|1<<i);
        }
    }

    private static int solve(int flag) {
        boolean[][] visited = new boolean[n+1][n+1];
        int total = 0;

        for(int[] start:startPoints) {
            int x = start[0];
            int y = start[1];
            if (visited[x][y]) continue;

            total += bfs(x, y, visited, flag);
        }

        return total;
    }

    private static int bfs(int x, int y, boolean[][] visited, int flag) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        int count = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int[] delta: deltas) {
                int nx = now[0]+delta[0];
                int ny = now[1]+delta[1];
                if (!inRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;

                boolean canMove = false;

                if(board[nx][ny] == 0) {
                    canMove = true;
                } else {
                    for (int i=0;i<rocks.size();i++) {
                        if ((flag&(1<<i))!=0) {
                            int[] rock = rocks.get(i);
                            if ((rock[0]==nx) && (rock[1]==ny)) {
                                canMove = true;
                                break;
                            }
                        }
                    }
                }

                if (canMove) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }
}