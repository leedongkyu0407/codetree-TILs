import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[][] grid;
    static int n, m;
    static int ans = -2001;

    public static void main(String[] args) throws IOException{
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

        for (int x=0;x<n;x++) {
            for (int y=0;y<m;y++) {
                for (int x1=x;x1<n;x1++) {
                    for (int y1=y;y1<m;y1++) {
                        for (int x2=0;x2<n;x2++) {
                            for (int y2=0;y2<m;y2++) {
                                for (int x3=x2;x3<n;x3++) {
                                    for (int y3=y2;y3<m;y3++) {
                                        if (!isOverlap(x, y, x1, y1, x2, y2, x3, y3))
                                            ans = Math.max(ans, calcArea(x, y, x1, y1)+calcArea(x2, y2, x3, y3));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
    
    private static boolean isOverlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        return x2 >= x3 && y2 >= y3;
    }

    private static int calcArea(int x, int y, int x2, int y2) {
        int area = 0;
        for (int i=x;i<=x2;i++) {
            for (int j=y;j<=y2;j++) {
                area += grid[i][j];
            }
        }
        return area;
    }

}