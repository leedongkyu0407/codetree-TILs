import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static Map<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String order = st.nextToken();
            if(order.equals("add")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                add(a, b);
            } else if (order.equals("remove")){
                int k = Integer.parseInt(st.nextToken());
                hm.remove(k);
            } else if (order.equals("find")) {
                int k = Integer.parseInt(st.nextToken());
                System.out.println(hm.get(k)==null ? "None" : hm.get(k));
            }
        }
    }

    private static void add(int a, int b){
        hm.put(a, b);
    }
}