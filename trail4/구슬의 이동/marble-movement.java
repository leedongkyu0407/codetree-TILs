import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, t, k;
    
    private static List<Bead> beads = new ArrayList<>();
    private static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException{
        initializing();
        solve();
        System.out.println(beads.size());
    }

    private static void solve() {
        for(int time = 0; time < t; time++) {
            
            for(Bead bead : beads) {
                move(bead);
            }
            
            checkCollision();
        }
    }

    private static void move(Bead bead) {
        for(int step = 0; step < bead.v; step++) {
            int nx = bead.x + deltas[bead.d][0];
            int ny = bead.y + deltas[bead.d][1];
            
            if(!inRange(nx, ny)) {
                bead.d = (bead.d + 2) % 4;  // 반대 방향
                nx = bead.x + deltas[bead.d][0];
                ny = bead.y + deltas[bead.d][1];
            }
            
            bead.x = nx;
            bead.y = ny;
        }
    }

    private static void checkCollision() {
        
        Map<String, List<Bead>> posMap = new HashMap<>();
        
        for(Bead bead : beads) {
            String key = bead.x + "," + bead.y;
            posMap.putIfAbsent(key, new ArrayList<>());
            posMap.get(key).add(bead);
        }
        
        List<Bead> toRemove = new ArrayList<>();
        
        for(List<Bead> group : posMap.values()) {
            if(group.size() > k) {

                group.sort((b1, b2) -> {
                    if(b1.v != b2.v) {
                        return Integer.compare(b2.v, b1.v); 
                    }
                    return Integer.compare(b2.o, b1.o); 
                });
                
                for(int i = k; i < group.size(); i++) {
                    toRemove.add(group.get(i));
                }
            }
        }
        
        beads.removeAll(toRemove);
    }

    private static boolean inRange(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }

    private static void initializing() throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = -1;
            String dir = st.nextToken();
            
            if(dir.equals("U")) d = 0;
            else if(dir.equals("R")) d = 1;
            else if(dir.equals("D")) d = 2;
            else d = 3;
            
            int v = Integer.parseInt(st.nextToken());
            
            Bead bead = new Bead(r, c, d, v, i);
            beads.add(bead);
        }
    }

    static class Bead {
        int x, y, d, v, o;

        public Bead(int x, int y, int d, int v, int o) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.v = v;
            this.o = o;
        }
    }
}