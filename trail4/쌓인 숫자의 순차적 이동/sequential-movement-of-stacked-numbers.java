import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    
    private static Map<Pos, Stack<Integer>> grid = new HashMap<>();
    
    private static Map<Integer, Pos> numPos = new HashMap<>();
    
    private static int[] orders;
    private static int[][] deltas = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, 1}, {1, -1}, {1, 1}, {-1, -1}};

    public static void main(String[] args) throws IOException{
        initializing();
        solve();
        print();
    }

    private static void solve() {
        for(int i=0; i<m; i++) {
            int nowNum = orders[i];
            
            Pos currentPos = numPos.get(nowNum);
            
            if(currentPos == null) continue;
            
            Pos nextPos = findMaxPos(currentPos);
            
            if(nextPos == null) continue;
            
            Stack<Integer> currentStack = grid.get(currentPos);
            Stack<Integer> temp = new Stack<>();
            
            while(!currentStack.isEmpty()) {
                int num = currentStack.pop();
                temp.push(num);
                if(num == nowNum) break;
            }
            
            if(!grid.containsKey(nextPos)) {
                grid.put(nextPos, new Stack<>());
            }
            
            Stack<Integer> nextStack = grid.get(nextPos);
            
            while(!temp.isEmpty()) {
                int num = temp.pop();
                nextStack.push(num);
                numPos.put(num, nextPos);
            }
        }
    }

    private static Pos findMaxPos(Pos p) {
        int x = p.x;
        int y = p.y;
        
        Pos maxPos = null;
        int maxNum = 0;
        
        for(int[] delta: deltas) {
            int nx = x + delta[0];
            int ny = y + delta[1];
            
            if(!inRange(nx, ny)) continue;
            
            Pos checkPos = new Pos(nx, ny);
            if(!grid.containsKey(checkPos)) continue;
            
            Stack<Integer> stack = grid.get(checkPos);
            if(stack.isEmpty()) continue;
            
            int maxInStack = 0;
            for(Integer num : stack) {
                maxInStack = Math.max(maxInStack, num);
            }
            
            if(maxInStack > maxNum) {
                maxNum = maxInStack;
                maxPos = checkPos;
            }
        }
        
        return maxPos;
    }

    private static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }

    private static void initializing() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<n; j++) {
                int num = Integer.parseInt(st.nextToken());
                
                Pos p = new Pos(i, j);
                if(!grid.containsKey(p)) {
                    grid.put(p, new Stack<>());
                }
                
                grid.get(p).push(num);
                numPos.put(num, p);
            }
        } 

        orders = new int[m];
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<m; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }  
    }

    private static void print() {
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                Pos p = new Pos(i, j);
                
                if(!grid.containsKey(p) || grid.get(p).isEmpty()) {
                    System.out.println("None");
                } else {
                    Stack<Integer> stack = grid.get(p);
                    StringBuilder sb = new StringBuilder();
                    
                    Object[] arr = stack.toArray();
                    for(int k=arr.length-1; k>=0; k--) {
                        if(k < arr.length-1) sb.append(" ");
                        sb.append(arr[k]);
                    }
                    
                    System.out.println(sb.toString());
                }
            }
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
            if(o==null || o.getClass() != getClass()) return false;
            Pos p = (Pos) o;
            return p.x==x && p.y==y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}