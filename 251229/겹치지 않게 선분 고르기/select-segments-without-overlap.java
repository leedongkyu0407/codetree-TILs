import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] segments;
    static ArrayList<int[]> al = new ArrayList();
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        segments = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            segments[i][0] = Integer.parseInt(st.nextToken());
            segments[i][1] = Integer.parseInt(st.nextToken());
        }
        perm(0);
        System.out.println(ans);
    }

    private static void perm(int cnt) {
        if(cnt==n) {
            if (possible())
                ans = Math.max(ans, al.size());
            return;
        }

        al.add(segments[cnt]);
        perm(cnt+1);
        al.remove(al.size()-1);
        perm(cnt+1);
    }

    private static boolean possible() {
        for(int i=0;i<al.size();i++) {
            for (int j=i+1;j<al.size();j++) {
                int[] seg1 = al.get(i);
                int[] seg2 = al.get(j);
                if ((seg1[1] >= seg2[0]) && (seg1[0] <= seg2[1])) return false;
            }
        }
        return true;
    }
}