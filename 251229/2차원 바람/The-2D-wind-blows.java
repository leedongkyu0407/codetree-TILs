import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, q;
    static int[][] building, queries, copied;
    static int[][] deltas = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        building = new int[n][m];
        queries = new int[q][4];
        copied = new int[n][m];

        for (int i=0;i<n;i++) {
            StringTokenizer inputs = new StringTokenizer(bf.readLine());
            for (int j=0;j<m;j++) {
                building[i][j] = Integer.parseInt(inputs.nextToken());
                copied[i][j] = building[i][j];
            }
        }

        for (int i=0;i<q;i++) {
            StringTokenizer inputs = new StringTokenizer(bf.readLine());
            for (int j=0;j<4;j++) {
                queries[i][j] = Integer.parseInt(inputs.nextToken())-1;
            }
        }
        
        for (int i=0;i<q;i++) {
            simul(queries[i]);
        }
        print();
    }

    private static void print() {
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                sb.append(building[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void simul(int[] query) {
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        rotate(x1, y1, x2, y2);
        // System.out.println("rotate: "+Arrays.deepToString(building));
        copy();
        avg(x1, y1, x2, y2);
    }

    private static void copy() {
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                copied[i][j] = building[i][j];
            }
        }
    }

    private static void rotate(int x1, int y1, int x2, int y2) {
        right(x1, y1, y2);
        down(x1, x2, y2);
        left(x2, y1, y2);
        up(x1, x2, y1);
    }

    private static void right(int x1, int y1, int y2) {
        for(int i=y2;i>y1;i--) {
            building[x1][i] = copied[x1][i-1];
        }
        // System.out.println("right: "+Arrays.deepToString(building));
    }

    private static void left(int x, int y1, int y2) {
        for (int i=y1;i<y2;i++) {
            building[x][i] = copied[x][i+1];
        }
        // System.out.println("left: "+Arrays.deepToString(building));
    }

    private static void up(int x1, int x2, int y) {
        for (int i=x1;i<x2;i++) {
            building[i][y] = copied[i+1][y];
        }
        // System.out.println("up: "+Arrays.deepToString(building));
    }

    private static void down(int x1, int x2, int y) {
        for (int i=x2;i>x1;i--) {
            building[i][y] = copied[i-1][y];
        }
        // System.out.println("down: "+Arrays.deepToString(building));        
    }

    private static void avg(int x1, int y1, int x2, int y2) {
        for (int i=x1;i<=x2;i++) {
            for (int j=y1;j<=y2;j++) {
                int sum = building[i][j];
                int cnt = 1;
                for (int[] delta : deltas) {
                    int nx = i+delta[0];
                    int ny = j+delta[1];
                    if (nx<0 || ny<0 || nx>=n || ny>=m) continue;
                    sum += copied[nx][ny];
                    cnt++;
                }
                // System.out.println("sum: "+sum+" cnt: "+cnt);
                building[i][j] = sum/cnt;
            }
        }
        // System.out.println("avg: "+Arrays.deepToString(building));        
    }
}