import java.util.*;
import java.io.*;

public class Main {
    static int[][] grid;
    static int n, m;
    static int ans = 0;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];

        for (int i=0;i<n;i++) {
            StringTokenizer inputs = new StringTokenizer(bf.readLine());
            for (int j=0;j<m;j++) {
                grid[i][j] = Integer.parseInt(inputs.nextToken());
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                for (int k=i;k<n;k++) {
                    for (int l=j;l<m;l++) {
                        int area = isPositive(i, j, k, l);
                        ans = Math.max(ans, area);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static int isPositive(int x, int y, int x2, int y2) {
        for(int i=x;i<=x2;i++) {
            for (int j=y;j<=y2;j++) {
                if (grid[i][j]<0) {
                    return -1;
                }
            }
        }
        return (x2-x+1)*(y2-y+1);
    }
}