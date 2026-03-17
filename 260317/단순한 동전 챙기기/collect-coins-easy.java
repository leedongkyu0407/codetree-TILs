import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, ans, startX, startY, endX, endY;
    private static int[][] pos;
    private static Map<Integer, int[]> nums = new HashMap<>();
    private static List<int[]> al = new ArrayList<>();
    private static int coins = 0;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        pos = new int[n][2];

        for (int i = 0; i < n; i++) {
            String input = bf.readLine();
            for (int j=0;j<n;j++) {
                char c = input.charAt(j);
                if (c != '.') {
                    if (c == 'S') {
                        startX = i;
                        startY = j;
                    } else if (c == 'E') {
                        endX = i;
                        endY = j;
                    } else {
                        int tmp = c - '0';
                        nums.put(tmp, new int[]{i, j});
                        coins++;
                    }
                }
            }                
        }

        ans = Integer.MAX_VALUE;
        if (coins >= 3) {
            comb(0, 0);
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);
    }

    private static void comb(int depth, int cnt) {
        if (depth == coins) {
            if (cnt == 3) {
                int distance = 0;
                int x = startX;
                int y = startY;

                for (int i=0;i<al.size();i++) {
                    int[] next = al.get(i);
                    distance += calcDist(x, y, next[0], next[1]);
                    x = al.get(i)[0];
                    y = al.get(i)[1]; 
                }
                distance += calcDist(endX, endY, x, y); 
                ans = Math.min(ans, distance);
            }
            return;
        }

        if (3-cnt > coins-depth) {
            return;
        }

        int[] now = nums.get(depth+1);
        // System.out.println(now);
        al.add(now);
        comb(depth+1, cnt+1);
        al.remove(al.size()-1);

        comb(depth+1, cnt);
    }

    private static int calcDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }
}