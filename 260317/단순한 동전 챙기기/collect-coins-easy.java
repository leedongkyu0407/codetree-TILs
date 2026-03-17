import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, ans, startX, startY, endX, endY;
    private static Map<Integer, int[]> coinMaps = new HashMap<>();
    private static List<Integer> selected = new ArrayList<>();
    private static List<Integer> coinNums = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());

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
                        coinMaps.put(tmp, new int[]{i, j});
                        coinNums.add(tmp);
                    }
                }
            }                
        }

        Collections.sort(coinNums);

        ans = Integer.MAX_VALUE;
        if (coinNums.size() >= 3) {
            comb(0, 0);
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);
    }

    private static void comb(int depth, int cnt) {
        if (depth == coinNums.size()) {
            if (cnt == 3) {
                int distance = 0;
                int x = startX;
                int y = startY;

                for (int num : selected) {
                    int[] pos = coinMaps.get(num);
                    distance += calcDist(x, y, pos[0], pos[1]);
                    x = pos[0];
                    y = pos[1]; 
                }
                distance += calcDist(endX, endY, x, y); 
                ans = Math.min(ans, distance);
            }
            return;
        }

        if (3-cnt > coinNums.size()-depth) {
            return;
        }

        selected.add(coinNums.get(depth));
        comb(depth+1, cnt+1);
        selected.remove(selected.size()-1);

        comb(depth+1, cnt);
    }

    private static int calcDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x2-x1) + Math.abs(y2-y1);
    }
}