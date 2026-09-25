import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        String value;
        Node prev, next;
        Node(String value) { this.value = value; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String sInit = bf.readLine();
        int n = Integer.parseInt(bf.readLine().trim());

        Node cur = new Node(sInit);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int op = Integer.parseInt(st.nextToken());

            if (op == 1) {
                String value = st.nextToken();
                Node newNode = new Node(value);

                Node before = cur.prev;
                newNode.prev = before;
                newNode.next = cur;
                if (before != null) before.next = newNode;
                cur.prev = newNode;

            } else if (op == 2) {
                String value = st.nextToken();
                Node newNode = new Node(value);

                Node after = cur.next;
                newNode.prev = cur;
                newNode.next = after;
                if (after != null) after.prev = newNode;
                cur.next = newNode;

            } else if (op == 3) {
                if (cur.prev != null) cur = cur.prev;

            } else if (op == 4) {
                if (cur.next != null) cur = cur.next;
            }

            String prevStr = (cur.prev != null) ? cur.prev.value : "(Null)";
            String nextStr = (cur.next != null) ? cur.next.value : "(Null)";
            sb.append(prevStr).append(" ").append(cur.value).append(" ").append(nextStr).append("\n");
        }

        System.out.print(sb);
    }
}