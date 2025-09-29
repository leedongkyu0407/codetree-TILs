import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bf.readLine());
        for (int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String order = st.nextToken();
            if(order.equals("push_back")) {
                int tmp = Integer.parseInt(st.nextToken());
                dq.addLast(tmp);
                continue;
            } else if(order.equals("push_front")) {
                int tmp = Integer.parseInt(st.nextToken());
                dq.addFirst(tmp);
                continue;
            } else if(order.equals("pop_front")) {
                System.out.println(dq.pollFirst());
                continue;
            } else if(order.equals("pop_back")) {
                System.out.println(dq.pollLast());
                continue;
            } else if(order.equals("size")) {
                System.out.println(dq.size());
                continue;
            } else if(order.equals("empty")) {
                int res = dq.isEmpty()?1:0;
                System.out.println(res);
                continue;
            } else if(order.equals("front")){
                System.out.println(dq.peekFirst());
                continue;
            } else if(order.equals("back")) {
                System.out.println(dq.peekLast());
                continue;
            }
        }
    }
}