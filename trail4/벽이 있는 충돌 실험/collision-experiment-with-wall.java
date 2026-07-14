import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int t, n, m;
    private static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static Set<Bead> beads;

    public static void main(String[] args) throws IOException{
        t = Integer.parseInt(bf.readLine());
        for(int i=0;i<t;i++) {
            initialSetting();
            solve();
        }
    }

    private static void initialSetting() throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        beads = new HashSet<>();        
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            int dir = 0;
            if("U".equals(d)) dir=0; 
            else if("R".equals(d)) dir=1; 
            else if("D".equals(d)) dir=2;
            else dir=3;

            beads.add(new Bead(x, y, dir));
        }
    }

    private static void solve() {
        for(int i=0;i<2*n;i++) {
            if(beads.isEmpty()) break;
            Map<Bead, Integer> hm = new HashMap<>();

            for(Bead bead : beads) {
                int nx = bead.x+deltas[bead.dir][0];
                int ny = bead.y+deltas[bead.dir][1];
                int newDir = bead.dir;

                if(!inRange(nx, ny)) {
                    newDir = (bead.dir+2)%4;
                    nx = bead.x;
                    ny = bead.y;
                }
            
                Bead newBead = new Bead(nx, ny, newDir);
                hm.put(newBead, hm.getOrDefault(newBead, 0)+1);
            }

            Set<Bead> nextBeads = new HashSet<>();
            for(Bead bead : hm.keySet()) {
                if (hm.get(bead)==1) {
                    nextBeads.add(bead);
                }
            }

            beads = nextBeads;
            hm.clear();
        }
        System.out.println(beads.size());
    }

    private static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }

    static class Bead {
        int x;
        int y;
        int dir;

        public Bead(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        @Override
        public boolean equals(Object o) {
            if(o==this) return true;
            if(o==null || getClass() != o.getClass()) return false;
            Bead b = (Bead) o;
            return b.x==x && b.y==y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}