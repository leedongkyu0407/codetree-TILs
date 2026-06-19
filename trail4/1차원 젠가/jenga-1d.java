import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, s1, e1, s2, e2;
    private static int[] blocks;
    private static List<Integer> al = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        blocks = new int[n+1];

        for(int i=1;i<=n;i++) {
            blocks[i] = Integer.parseInt(bf.readLine());
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        s1 = Integer.parseInt(st.nextToken());
        e1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        s2 = Integer.parseInt(st.nextToken());
        e2 = Integer.parseInt(st.nextToken());
        solve();
    }

    private static void solve() {
        int[] temp = new int[n+1];
        int idx = 1;
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=n;i++) {
            if(i>=s1 && i<=e1) continue;
            temp[idx++] = blocks[i];
        }

        for(int i=1;i<=n;i++) {
            if (i>=s2 && i<=e2) continue;
            if (temp[i]==0) continue;
            al.add(temp[i]);
        }

        sb.append(al.size()).append("\n");
        for(int i=0;i<al.size();i++) {
            sb.append(al.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
}