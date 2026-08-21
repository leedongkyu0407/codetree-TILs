import java.util.*;
import java.io.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int t, n, lastTime, time;
    // udrl
    private static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static List<Bead> beads;

    public static void main(String[] args) throws IOException{
        t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();   
        
        for(int i=0;i<t;i++) {
            n = Integer.parseInt(bf.readLine());
            beads = new ArrayList<>();
            
            for(int j=0;j<n;j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                String dir = st.nextToken();
                int d = 0;
                if("U".equals(dir)) {
                    d = 0;
                } else if ("D".equals(dir)) {
                    d = 1;
                } else if ("R".equals(dir)) {
                    d = 2;
                } else {
                    d = 3;
                }

                beads.add(new Bead(x*2, y*2, w, d, j));
            }

            lastTime = -1;
            time = 0;

            while(!beads.isEmpty()) {
                solve();
            }
            sb.append(lastTime).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void solve() {
        Map<String, Bead> hm = new HashMap<>();
        time++;
        for(Bead bead : beads) {
            int nx = bead.x+deltas[bead.d][0];
            int ny = bead.y+deltas[bead.d][1];
            if (!inRange(nx, ny)) continue;
            bead.x = nx;
            bead.y = ny;

            String key = bead.x+","+bead.y;
            if(hm.containsKey(key)) {
                lastTime = time;
                Bead tmp = hm.get(key);
                if(tmp.w < bead.w || (tmp.w==bead.w && tmp.n < bead.n)) {
                    hm.replace(key, bead);
                }
            } else {
                hm.put(key, bead);
            }
        }

        beads = new ArrayList<>(hm.values());
    }

    private static boolean inRange(int x, int y) {
        return x>=-2000 && x<=2000 && y>=-2000 && y<=2000; 
    }
    
    static class Bead {
        int x;
        int y;
        int w;
        int d;
        int n;

        public Bead(int x, int y, int w, int d, int n) {
            this.x=x;
            this.y=y;
            this.w=w;
            this.d=d;
            this.n=n;
        }
    }
}