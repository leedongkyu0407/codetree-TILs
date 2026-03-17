import java.util.*;
import java.io.*;

public class Main {
    
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static List<Integer> al = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        comb(0, 1);
        System.out.println(sb.toString());
    }

    private static void comb(int depth, int start) {
        if (depth == m) {
            for (int num : al) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<=n;i++) {
            al.add(i);
            comb(depth+1, i+1);
            al.remove(al.size()-1);
        }
    }
}