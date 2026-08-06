import java.io.*;
import java.util.*;

public class Main {

    private static int n, m, t, k;
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] deltas = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    private static List<Bead> beads = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            int d = 0;
            if(dir.equals("D")) {
                d = 1;
            } else if(dir.equals("R")) {
                d = 2;
            } else if (dir.equals("U")) {
                d = 3;
            }

            int v = Integer.parseInt(st.nextToken());

            Bead b = new Bead(r, c, d, v, i);
            beads.add(b);
        }
        solve();
    }

    private static void solve() {
        for(int i=0;i<t;i++) {
            
            for(Bead bead : beads) {
                move(bead);
            }

            checkCollision();
        }
        System.out.println(beads.size());
    }

    private static void checkCollision() {
        Map<String, List<Bead>> hm = new HashMap<>();

        for(Bead bead : beads) {
            String key = bead.x + "," + bead.y;
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(bead);
        }

        List<Bead> toRemove = new ArrayList<>();

        for(List<Bead> group : hm.values()) {
            if(group.size() < k) continue;

            group.sort((a, b) -> {
                if(a.v == b.v) {
                    return Integer.compare(a.o, b.o);
                }
                
                return Integer.compare(a.v, b.v);
            });

            for(int i=0;i<group.size()-k;i++) {
                toRemove.add(group.get(i));
            }
        }

        beads.removeAll(toRemove);
    }

    private static void move(Bead bead) {    
        for(int i=0;i<bead.v;i++) {
            int nx = bead.x+deltas[bead.d][0];
            int ny = bead.y+deltas[bead.d][1];

            if(!inRange(nx, ny)) {
                bead.d = (bead.d+2)%4;
                nx = bead.x+deltas[bead.d][0];
                ny = bead.y+deltas[bead.d][1];
            }

            bead.x=nx;
            bead.y=ny;
        }
    }

    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }

    static class Bead {
        int x;
        int y;
        int d;
        int v;
        int o;

        public Bead(int x, int y, int d, int v, int o) {
            this.x=x;
            this.y=y;
            this.d=d;
            this.v=v;
            this.o=o;
        }
    }
}