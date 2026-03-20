import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> picked = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        perm(0, 0);
        System.out.println(sb.toString());
    }

    private static void perm(int depth, int flag) {
        if (depth == n) {
            for(int i=0;i<picked.size();i++) {
                sb.append(picked.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=n;i>0;i--) {
            if ((flag & (1<<i))!=0) continue;
            picked.add(i);
            perm(depth+1, flag|1<<i);
            picked.remove(picked.size()-1);
        }
    }
}