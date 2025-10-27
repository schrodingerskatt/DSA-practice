// Detect Cycle in an undirected graph using DFS

import java.util.*;

public class DetectCycle1{

    public static boolean isCycle(int V, List<List<Integer>>adj){

        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(dfs(i, -1, visited, adj)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>>adj){

        visited[node] = true;
        for(int nbh: adj.get(node)){
            if(!visited[nbh]){
                if(dfs(nbh, node, visited, adj)) return true;
            }else if(nbh != parent){
                  return true;
            }
        }
    return false;
    }

    public static void main(String[] args){

        int V = 5;
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(1); 
        System.out.println(isCycle(V, adj));

    }
}