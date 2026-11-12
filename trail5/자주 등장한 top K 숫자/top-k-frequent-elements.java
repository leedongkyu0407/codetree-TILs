import java.util.*;
import java.io.*;

public class Main {
    private static int n, k;
    private static Map<Integer, Integer> hm = new HashMap<>();
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {    
            int tmp = Integer.parseInt(st.nextToken());
            if(!hm.containsKey(tmp)) {
                hm.put(tmp, 1);
            } else {
                hm.put(tmp, hm.get(tmp)+1);
            }
        }

        solve();
        System.out.println(sb.toString());
    }

    private static void solve() {
        List<Map.Entry<Integer, Integer>> al = new ArrayList<>(hm.entrySet());

        al.sort((o1, o2) -> {
            if (!(o1.getValue()==o2.getValue())) {
                return o2.getValue()-o1.getValue();
            } else {
                return o2.getKey()-o1.getKey();
            }
        });

        for(int i=0;i<k;i++) {
            if(i>0) sb.append(" ");

            sb.append(al.get(i).getKey());
        }
    }
}