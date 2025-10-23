import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, q;
    static int[][] grid;
    static String[] d = new String[]{"L", "R"};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for(int i=0;i<n;i++) {
            StringTokenizer inputs = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++){
                grid[i][j] = Integer.parseInt(inputs.nextToken());
            }
        }

        for(int i=0;i<q;i++) {
            StringTokenizer orders = new StringTokenizer(bf.readLine());
            int row = Integer.parseInt(orders.nextToken())-1;
            String dir = orders.nextToken();
            play(row, dir);
        }
        print();
    }

    private static void play(int row, String dir) {
        move(row, dir);

        int idx;
        if (dir.equals("L")) {
            idx = 0;
        } else {
            idx = 1;
        }

        for(int i=row;i>=1;i--) {
            if (spreadUp(i)==false) break;
            idx = (idx+1)%2;
            move(i-1, d[idx]);
        }

        if (dir.equals("L")) {
            idx = 0;
        } else {
            idx = 1;
        }

        for(int i=row;i<n-1;i++) {
            if (spreadDown(i)==false) break;
            idx = (idx+1)%2;
            move(i+1, d[idx]);
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void move(int row, String dir) {
        if ("L".equals(dir)) {
            moveLeft(row);
        } else if ("R".equals(dir)) {
            moveRight(row);
        }
    }

    private static void moveRight(int row) {
        int temp = grid[row][0];
        for(int i=0;i<m-1;i++) {
            grid[row][i] = grid[row][i+1];
        }
        grid[row][m-1] = temp;
    }

    private static void moveLeft(int row) {
        int temp = grid[row][m-1];
        for(int i=m-1;i>=1;i--) {
            grid[row][i] = grid[row][i-1];
        }
        grid[row][0] = temp;
    }

    private static boolean spreadUp(int row) {
        for(int i=0;i<m;i++) {
            if (grid[row-1][i] == grid[row][i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean spreadDown(int row) {
        for(int i=0;i<m;i++) {
            if (grid[row+1][i]==grid[row][i]) {
                return true;
            }
        }
        return false;
    }
}