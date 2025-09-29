import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Queue<Integer> q = new LinkedList<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(bf.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String order = st.nextToken();
            if(order.equals("push")) {
                int tmp = Integer.parseInt(st.nextToken());
                q.add((Integer)tmp);
                continue;
            } else if(order.equals("front")){
                System.out.println(q.peek());
                continue;
            } else if(order.equals("size")) {
                System.out.println(q.size());
                continue;
            } else if(order.equals("empty")) {
                int res = q.isEmpty()?1:0;
                System.out.println(res);
                continue;
            } else if(order.equals("pop")) {
                System.out.println(q.poll());
                continue;
            }
        }
    }
}