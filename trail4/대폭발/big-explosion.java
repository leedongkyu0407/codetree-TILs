import java.io.*;
import java.util.*;

public class Main {
    private static int n, m, r, c, t;
    private static boolean[][] bombs;
    private static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        bombs = new boolean[n+1][n+1];

        bombs[r][c] = true;
        q.add(new int[]{r, c, 1});
        m = (int)Math.pow(2, m);

        solve();
        int ans = 0;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(bombs[i][j]) ans++;
            }
        }
        System.out.println(ans);
    }

    private static void solve() {

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nd = now[2];
            if (nd == m) return;

            q.add(new int[]{now[0], now[1], now[2]*2});
            
            for(int[] delta: deltas) {  
                int nx = now[0]+(delta[0]*nd);
                int ny = now[1]+(delta[1]*nd);
                if(!inRange(nx, ny)) continue;
                if(bombs[nx][ny]) continue;
                
                bombs[nx][ny] = true;
                q.add(new int[]{nx, ny, nd*2});    
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }
}