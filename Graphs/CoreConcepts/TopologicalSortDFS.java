/* Topological Sort DFS based

1. Perform DFS
2. After finishing all neighbors of a node, push it to a stack
3. At the end, popping the stack gives the topological ordering

Why this works

1. Consider an edge u → v.
2. DFS goes from u to v first.
3. We don’t push u onto the stack until v and all of v’s descendants are pushed.
4. Therefore, v will be pushed before u.
5. When we pop the stack, u comes before v, which satisfies the topological ordering.

*/

import java.util.*;

public class TopologicalSortDFS{

public static void DFS(int i, boolean[] visited, Stack<Integer>stack, List<List<Integer>>adj){

    visited[i] = true;
    for(int node:adj.get(i)){
        DFS(node, visited, stack, adj);
    }
    stack.push(i);
}


public static List<Integer>topologicalSort(int V, List<List<Integer>>adj){

    boolean[] visited = new boolean[V];
    Stack<Integer>stack = new Stack<>();

    for(int i = 0; i < V; i++){
        if(!visited[i]){
            DFS(i, visited, stack, adj);
        }
        List<Integer>topOrder = new ArrayList<>();
        while(!stack.isEmpty()){
            topOrder.add(stack.pop());
        }
        return topOrder;
    }
}


public static void main(String[] args){

    int V = 6;
    List<List<Integer>adj = new ArrayList<>();
    for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> topo = topologicalSort(V, adj);
        System.out.println("Topological Sort: " + topo);

}

}