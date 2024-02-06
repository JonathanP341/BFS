import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
        int homes = input.nextInt();
        int roads = input.nextInt();
        int houseA = input.nextInt();
        int houseB = input.nextInt();
        
        //Matrix to keep track of what is positive
        boolean[][] adjMatrix = new boolean[homes+1][homes+1];
        
        //Adding the rooms
        for (int i = 0; i < roads; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            adjMatrix[x][y] = true;
            adjMatrix[y][x] = true;        
        }
        
        boolean[] visited = new boolean[homes+1];
        Queue<Integer> queue = new LinkedList<Integer>();
        
        visited[houseA] = true;
        queue.add(houseA);
        
        while (!queue.isEmpty() && !visited[houseB]) {
            int source = queue.poll();
            
            for (int i = 1; i <= homes; i++) {
                if (adjMatrix[source][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        
        if (visited[houseB]) {
            System.out.println("GO SHAHIR!");
        }
        else {
            System.out.println("NO SHAHIR!");
        }
  }
}
