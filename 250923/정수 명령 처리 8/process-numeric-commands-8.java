import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static LinkedList<Integer> al = new LinkedList<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer input = new StringTokenizer(bf.readLine());
            practice(input);
        }
    }

    static void practice(StringTokenizer input) {
        String order = input.nextToken();

        if (order.equals("push_back")) {
            Integer tempNum = Integer.parseInt(input.nextToken());
            al.addLast(tempNum);
            return;
        } else if (order.equals("push_front")){
            Integer tempNum = Integer.parseInt(input.nextToken());
            al.addFirst(tempNum);
            return;
        } else if (order.equals("pop_front")) {
            System.out.println(al.pollFirst());
            return;
        } else if (order.equals("front")) {
            System.out.println(al.peekFirst());
            return;
        } else if (order.equals("pop_back")) {
            System.out.println(al.pollLast());
            return;
        } else if (order.equals("back")) {
            System.out.println(al.peekLast());
            return;
        } else if (order.equals("size")) {
            System.out.println(al.size());
            return;
        } else if (order.equals("empty")) {
            System.out.println(al.isEmpty() ? 1 : 0);
            return;
        }
    }
}