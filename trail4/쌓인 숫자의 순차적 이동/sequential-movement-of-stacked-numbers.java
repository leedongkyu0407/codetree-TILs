import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static Map<Pos, List<Integer>> hm = new HashMap<>();
    private static Map<Integer, Pos> posMap = new HashMap<>();
    
    private static int[] orders;
    private static int[][] deltas = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, 1}, {1, -1}, {1, 1}, {-1, -1}};

    public static void main(String[] args) throws IOException{
        initializing();
        solve();
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                Pos p = new Pos(i, j);
                List<Integer> al = hm.get(p);
                if(al.isEmpty()) {
                    sb.append("None");
                } else {
                    for(int k=al.size()-1;k>=0;k--) {
                        sb.append(al.get(k)).append(" ");
                    }
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static void solve() {
        for(int i=0;i<m;i++) {
            Pos nowPos = posMap.get(orders[i]);
            Pos nextPos = findMax(orders[i]);
            if(nextPos!=null) {
                move(nowPos, nextPos, orders[i]);
            }
        }
    }

    private static void move(Pos p, Pos nextP, int num) {
        List<Integer> currentList = hm.get(p);
        int idx = currentList.indexOf(num);
        List<Integer> toMoveList = new ArrayList<>(currentList.subList(idx, currentList.size()));

        hm.get(p).removeAll(toMoveList);
        hm.get(nextP).addAll(toMoveList);

        for(Integer n : toMoveList) {
            posMap.put(n, nextP);
        }
    }

    private static Pos findMax(int num) {
        Pos nowP = posMap.get(num);
        Pos maxP = null;
        int maxNum = 0;

        for(int[] delta: deltas) {
            int nx = nowP.x+delta[0];
            int ny = nowP.y+delta[1];
            if(!inRange(nx, ny)) continue;
            
            Pos nextP = new Pos(nx, ny);
            if (!hm.containsKey(nextP)) continue;
            for(Integer n : hm.get(nextP)) {
                if(n > maxNum) {
                    maxNum = n;
                    maxP = nextP;
                }
            }
        }

        return maxP;
    } 

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }

    private static void initializing() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                int num = Integer.parseInt(st.nextToken());
                Pos p = new Pos(i, j);
                posMap.put(num, p);
                hm.put(p, new ArrayList<>());
                hm.get(p).add(num);
            }
        }

        orders = new int[m];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<m;i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if(o==this) return true;
            if(o==null || getClass() != o.getClass()) return false;
            Pos p = (Pos) o;
            return x==p.x && y==p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}