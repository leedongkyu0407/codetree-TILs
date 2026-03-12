import java.util.*;
import java.io.*;

public class Main {
    private static int[][] maps, maxValue;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, c;
    private static int ans = 0;
    private static List<Position> positions = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());    
        maps = new int[n][n];
        maxValue = new int[n][n];

        for (int i = 0; i < n; i++){
            StringTokenizer inputs = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++){
                maps[i][j] = Integer.parseInt(inputs.nextToken());
            }
        }

        calcMaxValues();
        findMaxTotalValue();
        System.out.println(ans);
    }

    private static void calcMaxValues() {
        for(int r=0;r<n;r++) {
            for (int c=0;c<n-m+1;c++) {
                int[] items = new int[m];
                for(int i=0;i<m;i++) {
                    items[i] = maps[r][c+i];
                }
                maxValue[r][c] = getMaxValue(items);
            }
        }
    }

    private static int getMaxValue(int[] items) {
        int max = 0;
        for (int i=0;i<1<<m;i++) {
            int weightSum = 0;
            int valueSum = 0;
            for (int j=0;j<m;j++) {
                if ((i&1<<j) != 0) {
                    weightSum += items[j];
                    valueSum += (items[j]*items[j]);
                }
            }

            if (weightSum <= c) {
                max = Math.max(max, valueSum);
            }
        }
        return max;
    }

    private static class Position {
        int row, col, value;

        Position(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
    
    private static boolean isOverlap(Position p1, Position p2) {
        if (p1.row != p2.row) {
            return false;
        }

        int end1 = p1.col+m-1;
        int end2 = p2.col+m-1;
        return !((end1 < p2.col) || (end2 < p1.col));
    }

    private static void findMaxTotalValue() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n-m+1;j++) {
                positions.add(new Position(i, j, maxValue[i][j]));
            }
        }

        // 두 위치 선택
        for (int i=0;i<positions.size();i++) {
            for (int j=i;j<positions.size();j++) {
                Position p1 = positions.get(i);
                Position p2 = positions.get(j);

                if(!isOverlap(p1, p2)) {
                    ans = Math.max(ans, p1.value+p2.value);
                }
            }
        }
    }

}