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
        sol();
        System.out.println(sb.toString());
    }

    private static void sol() {
        for(int i=0;i<(1<<n);i++) {
            if (Integer.bitCount(i) == m) {                
                for (int j=0;j<n;j++) {
                    if ((i & (1<<j)) != 0) {
                        sb.append(j+1).append(" ");
                    }
                }
                sb.append("\n");
            }
        }
    }
}