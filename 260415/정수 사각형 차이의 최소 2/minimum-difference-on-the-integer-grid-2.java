import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static int[][] deltas = {{1, 0}, {0, 1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        grid = new int[n][n];
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                minVal = Math.min(minVal, grid[i][j]);
                maxVal = Math.max(maxVal, grid[i][j]);
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int min = minVal; min <= maxVal; min++) {
            if (grid[0][0] < min) continue;
            
            int result = findMinDiff(min, maxVal);
            if (result != -1) {
                answer = Math.min(answer, result);
            }
        }
        
        System.out.println(answer);
    }
    
    static int findMinDiff(int minLimit, int maxLimit) {
        int left = 0;
        int right = maxLimit - minLimit;
        int result = -1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int maxAllowed = minLimit + mid;
            
            if (canReach(minLimit, maxAllowed)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    static boolean canReach(int minVal, int maxVal) {
        if (grid[0][0] < minVal || grid[0][0] > maxVal) return false;
        if (grid[n-1][n-1] < minVal || grid[n-1][n-1] > maxVal) return false;
        
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            if (x == n - 1 && y == n - 1) {
                return true;
            }
            
            for (int[] delta : deltas) {
                int nx = x + delta[0];
                int ny = y + delta[1];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] < minVal || grid[nx][ny] > maxVal) continue;
                
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        
        return false;
    }
}