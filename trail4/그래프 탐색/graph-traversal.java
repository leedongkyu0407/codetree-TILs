import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, ans;
    private static List<List<Integer>> al = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0;i<=n;i++) {
            al.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            al.get(a).add(b);
            al.get(b).add(a);
        }

        ans = 0;
        dfs();
        System.out.println(ans);
    }

    private static void dfs() {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i=0;i<al.get(now).size();i++) {
                if(visited[al.get(now).get(i)]) continue;
                visited[al.get(now).get(i)] = true;
                q.add(al.get(now).get(i));
                ans++;
            }
        }
    }

}