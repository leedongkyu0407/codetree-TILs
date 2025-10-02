import java.util.*;
import java.io.*;

public class Main {
    static int N, startX, startY, endX, endY, ans;
    static int[][] map;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer inputs = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(inputs.nextToken());
            }
        }

        ans = 0;
        for(int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                startX = i;
                startY = j;
                endX = i+2;
                endY = j+2;
                if (inRange(startX, startY)==false || inRange(endX, endY)==false) {
                    continue;
                }
                int tmp = 0;
                for (int x=startX;x<=endX;x++) {
                    for(int y=startY;y<=endY;y++) {
                        if (map[x][y]==1) {
                            tmp++;
                        }
                    }
                }
                ans = Math.max(ans, tmp);
            }
        }
        System.out.println(ans);
    }

    private static boolean inRange(int x, int y) {
        return (x>=0 && y>=0 && x<N && y<N);
    }
}