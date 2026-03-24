import java.util.*;
import java.io.*;

public class Main {
    
    private static int n, m, nowNum, blockCnt, blockSize, maxSize;
    private static int[][] board;
    private static boolean[][] visited;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }

    private static void initialSetting() throws IOException {
        n = Integer.parseInt(bf.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];
        nowNum = 0;
        maxSize = 0;
        blockCnt = 0;

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solve() {
        for (int x=0;x<n;x++) {
            for(int y=0;y<n;y++) {
                if (visited[x][y]) continue;
                nowNum = board[x][y];
                blockSize = 1;
                visited[x][y] = true;
                dfs(x, y);
                if (blockSize>=4) blockCnt++;
                maxSize = Math.max(maxSize, blockSize);
            }
        }
    }

    private static void dfs(int x, int y) {
        for(int[] delta : deltas) {
            int nx = x+delta[0];
            int ny = y+delta[1];
            if (!inRange(nx, ny)) continue;
            if (visited[nx][ny]) continue;
            if (board[nx][ny]!=nowNum) continue;
            visited[nx][ny] = true;
            blockSize++;
            dfs(nx, ny);
        }
    }
    
    private static void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(blockCnt).append(" ").append(maxSize);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        initialSetting();
        solve();
        print();
    }
}