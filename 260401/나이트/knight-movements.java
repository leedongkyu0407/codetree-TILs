import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, ans;
    private static int[][] board;
    private static int[][] deltas = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    private static boolean[][] visited;
    private static int[] start = new int[2];
    private static int[] end = new int[2];
    private static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        board = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        end[0] = Integer.parseInt(st.nextToken());
        end[1] = Integer.parseInt(st.nextToken());
        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        ans = -1;
        move();
        System.out.println(ans);
    }

    private static void move() {
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0]==end[0] && now[1]==end[1]) {
                ans = now[2];
                return;
            }
            
            for(int[] delta: deltas) {
                int nx = now[0]+delta[0];
                int ny = now[1]+delta[1];
                if (!inRange(nx, ny) || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, now[2]+1});
            }
        }
        return;
    }

    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }
    
}