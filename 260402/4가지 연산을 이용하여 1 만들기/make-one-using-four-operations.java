import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        System.out.println(bfs(n));
    }
    
    private static int bfs(int n) {
        if (n == 1) return 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        
        q.add(n);
        visited.add(n);
        int steps = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            steps++;
            
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                
                int[] next = new int[4];
                next[0] = now - 1;                          
                next[1] = now + 1;                          
                next[2] = (now % 2 == 0) ? now / 2 : -1;    
                next[3] = (now % 3 == 0) ? now / 3 : -1;    
                
                for (int num : next) {
                    if (num < 1) continue;        
                    if (visited.contains(num)) continue;  
                    
                    if (num == 1) return steps;   
                    
                    visited.add(num);
                    q.add(num);
                }
            }
        }
        
        return -1;
    }
}