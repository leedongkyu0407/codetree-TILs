import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bf.readLine());
        for (int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String o = st.nextToken();
            if (o.equals("push")) {
                s.push(Integer.parseInt(st.nextToken()));
                continue;
            } else if (o.equals("size")){
                System.out.println(s.size());
                continue;
            } else if (o.equals("empty")) {
                int e = (s.isEmpty())?1:0;
                System.out.println(e);
                continue;
            } else if (o.equals("pop")) {
                System.out.println(s.pop());
                continue;
            } else if (o.equals("top")) {
                System.out.println(s.peek());
                continue;
            }
        }    
    }
}