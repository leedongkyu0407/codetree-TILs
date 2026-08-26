import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, t;
    private static List<Bead> beads = new ArrayList<>();
    private static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            int d = 0;

            if(dir.equals("U")) {
                d = 0;
            } else if (dir.equals("R")) {
                d = 1;
            } else if (dir.equals("D")) {
                d = 2;
            } else {
                d = 3;
            }
            int w = Integer.parseInt(st.nextToken());
            beads.add(new Bead(r, c, d, w, i));
        }
        solve();
    }

    private static void solve() {
        for(int i=0;i<t;i++) {
            simulate();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(beads.size()).append(" ");
        int ans = 0;
        for(Bead b : beads) {
            if(b.w > ans) {
                ans = b.w;
            } 
        }
        sb.append(ans);
        System.out.println(sb.toString());
    }

    private static void simulate() {
        Map<String, Bead> hm = new HashMap<>();
        List<Bead> tmp = new ArrayList<>();

        for(Bead b : beads) {

            int nx = b.r+deltas[b.d][0];
            int ny = b.c+deltas[b.d][1];
            if(!inRange(nx, ny)) {
                b.d = (b.d+2)%4;
                nx = b.r;
                ny = b.c;
            }

            String key = nx+","+ny;
            int d = b.d;
            int w = b.w;
            int num = b.num;

            if(hm.containsKey(key)) {
                Bead prevBead = hm.get(key);
                w += prevBead.w;

                if(b.num > prevBead.num) {
                    tmp.add(prevBead);
                } else {
                    d = prevBead.d;
                    num = prevBead.num;
                    tmp.add(b);
                }
            }
            hm.put(key, new Bead(nx, ny, d, w, num)); 
        }
        beads = new ArrayList<>(hm.values());
    }

    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }

    static class Bead {
        int r;
        int c;
        int d;
        int w;
        int num;

        public Bead(int r, int c, int d, int w, int num) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.w = w;
            this.num = num;
        }
    }
}