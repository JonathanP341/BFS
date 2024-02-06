package graphs.bfs;

import java.util.*;
public class GraphsBFS {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Could use for loop, but this is easier
        int homes = input.nextInt();
        int roads = input.nextInt();
        int houseA = input.nextInt();
        int houseB = input.nextInt();
        
        //Setting up linked list
        LinkedList<Integer> adjacencyList[];
        adjacencyList = new LinkedList[homes+1];
        
        //Setting up a linked list at every index
        for (int i = 1; i <= homes; i++) {
            adjacencyList[i] = new LinkedList();
        }
        
        //For loop to add the edges
        int node;
        int connectedNode;
        for (int i = 0; i < roads; i++) {
            node = input.nextInt();
            connectedNode = input.nextInt();
            adjacencyList[node].add(connectedNode);  
        }
        
        boolean visited[] = new boolean[homes+1];//Array to track what has been visited
        Queue<Integer> queue = new LinkedList<Integer>();
        
        //Setting the guys house to visited and adding it to the queue
        visited[houseA] = true;
        queue.add(houseA);
        int source;
        
        while (!queue.isEmpty() && !visited[houseB]) {
            source = queue.poll();
            
            //Looking at the nodes connected to the source node using gamer for loop       
            for (int i: adjacencyList[source]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i); 
                }    
            }
        }
        
        if (visited[houseB])
            System.out.println("GO SHAHIR!");
        else 
            System.out.println("NO SHAHIR!");
        
    }
    
}
