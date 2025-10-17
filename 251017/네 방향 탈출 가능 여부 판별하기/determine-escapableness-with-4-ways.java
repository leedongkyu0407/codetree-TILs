import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<int[]> q = new ArrayDeque<>();
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j]==0) visited[i][j] = true;
            }
        
        q.add(new int[]{0,0});
        visited[0][0] = true;
        System.out.println(bfs());
    }

    private static int bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0]==n-1&&now[1]==m-1) return 1;
            for(int[] delta: deltas) {
                int nx = now[0]+delta[0];
                int ny = now[1]+delta[1];
                if(nx<0 || nx >= n || ny<0 || ny >= m || visited[nx][ny]) continue;
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

        return 0;
    }
}