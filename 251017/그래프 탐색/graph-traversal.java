import java.util.*;
public class Main {
    static ArrayList<Integer>[] graph;    
    static int n, m; 
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList[n + 1];  
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[n+1];
        int a=0, b=0;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            graph[a].add(b);  
            graph[b].add(a);
        }

        visited[1] = true;
        int ans = dfs(1);

        System.out.println(ans);
    }

    private static int dfs(int cur) {
        int count = 0;
        for (int next : graph[cur]) {  
            if (!visited[next]) {
                visited[next] = true;
                count++;
                count += dfs(next);
            }
        }
        return count;
    }
}