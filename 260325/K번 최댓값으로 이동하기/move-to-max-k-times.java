import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, k, startX, startY, nowNum;
    private static int[][] board;
    private static boolean[][] visited;
    private static int[][] deltas = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    private static Queue<int[]> q = new ArrayDeque<>();
    private static List<int[]> al;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n+1][n+1];

        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());

        for(int i=0;i<k;i++) {
            visited = new boolean[n+1][n+1];
            visited[startX][startY] = true;
            nowNum = board[startX][startY];
            q.add(new int[]{startX, startY});
            bfs();    
        }
        System.out.println(startX+" "+startY);
    }

    private static void bfs() {
        int bigger = 0;
        int r = Integer.MAX_VALUE, c = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int[] delta: deltas) {
                int nx = now[0]+delta[0];
                int ny = now[1]+delta[1];
                if(!inRange(nx, ny)) continue;
                if(visited[nx][ny]) continue;
                if (nowNum<=board[nx][ny]) continue;

                visited[nx][ny] = true;
                if(bigger < board[nx][ny]) {
                    bigger = board[nx][ny];
                    r = nx;
                    c = ny;
                } else if (bigger == board[nx][ny]){
                    if (nx<r) {
                        c = ny;
                        r = nx;
                    } else if (nx == r && ny < c) {
                        c = ny;
                        r = nx;
                    } 
                }
                q.add(new int[]{nx, ny});
            }
        }

        if(r!=Integer.MAX_VALUE){
            startX = r;
            startY = c;
        }
    }

    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }
}