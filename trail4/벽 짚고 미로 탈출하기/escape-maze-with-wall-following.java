import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, x, y;
    private static int[][] board;   // 우, 상, 좌, 하
    private static int[][] deltas = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        x = Integer.parseInt(st.nextToken())-1;
        y = Integer.parseInt(st.nextToken())-1;

        board = new int[n][n];
        for(int i=0;i<n;i++) {
            String s = bf.readLine();
            for(int j=0;j<n;j++) {
                if(s.charAt(j)=='.') {
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }
        // System.out.println(Arrays.deepToString(board));
        visited = new boolean[n][n][4];
        System.out.println(solve());
        // for(int i=0;i<n;i++) {
        //     System.out.println(i+": "+Arrays.deepToString(visited[i]));
        // }
    }

    private static int solve() {
        int t = 0;
        int dir = 0;

        while(true) { 
            if (visited[x][y][dir]) {
                return -1;
            }
            visited[x][y][dir] = true;

            int nx = x+deltas[dir][0];
            int ny = y+deltas[dir][1];

            if (!inRange(nx, ny)) return ++t;
            
            if (board[nx][ny]==1) {
                dir = (dir+1)%4;
                visited[nx][ny][dir] = true;
                continue;
            } 
            
            if (rightWall(nx, ny, dir)) {    
                t++;
            } else {
                visited[nx][ny][dir] = true;
                dir = (dir+3)%4;
                nx = nx+deltas[dir][0];
                ny = ny+deltas[dir][1];
                t+=2;
            }
            x=nx;
            y=ny;
        }
    }

    private static boolean rightWall(int nx, int ny, int dir) {
        int rightNx = nx+deltas[(dir+3)%4][0];
        int rightNy = ny+deltas[(dir+3)%4][1];
        if(board[rightNx][rightNy]==1) return true;
        return false;
    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}