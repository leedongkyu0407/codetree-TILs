import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> l = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bf.readLine());
        for(int i=0;i<N;i++) {
            StringTokenizer input = new StringTokenizer(bf.readLine());
            setting(input);
        }
    }

    static void setting(StringTokenizer input) {
        String order = input.nextToken();
        if (order.equals("push_back")) {
            int tempNum = Integer.parseInt(input.nextToken());
            l.add(tempNum);
            return;
        } else if (order.equals("size")) {
            System.out.println(l.size());
            return;
        } else if (order.equals("get")) {
            int idx = Integer.parseInt(input.nextToken());
            System.out.println(l.get(idx-1));
            return;
        } else if (order.equals("pop_back")) {
            l.remove(l.size()-1);
            return;
        }
    }
}