import java.util.*;
import java.io.*;

public class Main {
    private static int[][] deltas = {{0, 0}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    private static int[][] map, directions;
    private static int n, r, c;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int ans = 0;
    private static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        map = new int[n+1][n+1];
        directions = new int[n+1][n+1];

        for(int i=1;i<=n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                directions[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
  
        q.add(new int[]{r, c});   
        perm(0);     
        System.out.println(ans);
    }

    private static void perm(int depth) {
      ans = Math.max(ans, depth);

      for(int i=0;i<q.size();i++) {
            int[] now = q.poll();
            int dir = directions[now[0]][now[1]];

            for(int j=1;j<n;j++) {
                int nx = now[0] + deltas[dir][0]*j;
                int ny = now[1] + deltas[dir][1]*j;
                if (!inRange(nx, ny)) continue;

                if(!isBig(nx, ny, now[0], now[1])) continue;
                q.add(new int[]{nx, ny});
                perm(depth+1);
                q.poll();
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x>=1 && x<=n && y>=1 && y<=n;
    }

    private static boolean isBig(int x1, int y1, int x2, int y2) {
        return map[x1][y1] > map[x2][y2];
    }
}