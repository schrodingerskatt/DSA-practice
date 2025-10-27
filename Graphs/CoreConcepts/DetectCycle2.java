// Detect Cycle in a Directed Graph using DFS

import java.util.*;

public class DetectCycle2{

    puublic static boolean dfs(int source, boolean[] visited, boolean[] restack, List<List<Integer>>adj){

        visited[node] = true;
        restack[node] = true;

        for(int nbh: adj.get(source)){
            if(!visited[nbh]){
                if(dfs(nbh, visited, restack, adj)) return true;
            }else if(restack[nbh]){
                return true;
            }

        }
        restack[node] = false;
        return false;
    }

    public static boolean hasCycle(int v, List<List<Integer>>adj){

        boolean[] visited = new boolean[v];
        boolean[] restack = new boolean[v];

        for(int i = 0; i < v; i++){
            if(!visited[i]){
                if(dfs(i, ,visited, restack, adj)) return true;
            }
        }
    return false;
    }

    public static void main(String[] args){

        int V = 4;
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);

        if(hasCycle(V, adj)){
            System.out.println("Cycle dtected");
        }
        else{
            System.out.println("No cycle");
        }
    }
}