import java.util.*;
public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int n, m; 
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<Integer>());
        }

        visited = new boolean[n+1];
        int a=0, b=0;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited[1] = true;
        dfs(1);
        for(int i=2;i<=n;i++) {
            if (visited[i]) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int start) {
        for (int i=1;i<=graph.get(start).size();i++) {
            int tmp = graph.get(start).get(i-1);
            if(!visited[tmp]) {
                visited[tmp] = true;
                dfs(tmp);
            }
        }
    }
}