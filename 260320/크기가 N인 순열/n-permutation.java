import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static StringBuilder sb = new StringBuilder();
    private static List<Integer> al = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(bf.readLine());
        perm(0, 0);
        System.out.println(sb.toString());
    }

    private static void perm(int depth, int flag) {
        if (depth==n) {
            for (int i=0;i<al.size();i++) {
                sb.append(al.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<n;i++) {
            if ((flag&(1<<i)) != 0) continue;
            al.add(i+1);
            
            perm(depth+1, flag|(1<<i));
            al.remove(al.size()-1);
        }
    }
}