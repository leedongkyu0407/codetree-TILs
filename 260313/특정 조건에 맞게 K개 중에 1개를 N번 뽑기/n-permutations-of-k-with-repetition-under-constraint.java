import java.util.*;
import java.io.*;

public class Main {

    private static int k, n;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> res = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        comb(0);
    }

    private static void comb(int cnt) {
        if (cnt == n) {
            if (res.size() >= 3) {
                if (isSuccessive()) {
                    return;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<res.size()-1;i++) {
                sb.append(res.get(i)).append(" ");
            }
            sb.append(res.get(res.size()-1));
            System.out.println(sb);
            return;
        }

        for(int i=1;i<=k;i++) {
            res.add(i);
            comb(cnt+1);
            res.remove(res.size()-1);
        }
    }

    private static boolean isSuccessive() {
        for(int i=0;i<=res.size()-3;i++) {
            int a = res.get(i);
            int b = res.get(i+1);
            int c = res.get(i+2);

            if (a==b && b==c){
                return true;
            }
        }
        return false;
    }
}