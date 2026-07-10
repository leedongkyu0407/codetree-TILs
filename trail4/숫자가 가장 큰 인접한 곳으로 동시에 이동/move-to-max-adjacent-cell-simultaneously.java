import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, t;
    private static int[][] board, visited;
    private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static List<int[]> startPos;
    private static List<int[]> toMove;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        startPos = new ArrayList<>();
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            startPos.add(new int[]{a, b});
        }
        solve();
    }

    private static void solve() {
        for(int i=0;i<t;i++) {           
            visited = new int[n+1][n+1];
            toMove = new ArrayList<>();
            for(int j=0;j<startPos.size();j++) {
                find(startPos.get(j));
            }
            startPos = new ArrayList<>();
            for(int k=0;k<toMove.size();k++) {
                int[] a = toMove.get(k);
                if(visited[a[0]][a[1]]==1) {
                    startPos.add(new int[]{a[0], a[1]});
                }
            }
        }
        System.out.println(startPos.size());
    }

    private static void find(int[] pos) {
        int ax = 0;
        int ay = 0;
        int temp = 0;

        for(int[] delta: deltas) {
            int nx = pos[0]+delta[0];
            int ny = pos[1]+delta[1];
            if (!inRange(nx, ny)) continue;
            if(temp < board[nx][ny]) {
                ax = nx;
                ay = ny;
                temp = board[nx][ny];
            };
        }
        visited[ax][ay]+=1;
        toMove.add(new int[]{ax, ay});
    }

    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }
}