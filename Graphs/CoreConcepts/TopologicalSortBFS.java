/*
Definition: A topological sort of a Directed Acyclic Graph (DAG) is a linear ordering of its 
vertices such that for every directed edge u → v, vertex u comes before vertex v in the ordering.

Important: Only possible if the graph has no cycles (DAG).

*/

// BFS based approach (Kahn's Algorithm)

public class TopologicalSortBFS {

    public static List<Integer>topologicalSort(int V, List<List<Integer>>adj){

        int[] indegree = new int[V];
        for(int u = 0; u < V; u++){
            for(int v: adj.get(u)){
                indegree[v]++;
            }
        }

        Queue<Integer>q = new ArrayDeque<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0) q.add(i);
        }

        List<Integer>topOrder = new ArrayList<>();

        while(!q.isEmpty()){

            int u = q.poll();
            topOrder.add(u);

            for(int v: adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0) q.add(v);
            }
        }
        if(topOrder.size() != V) {
            System.out.println("Graph has a cycle! Topological sort not possible.");
            return null;
        }

        return topOrder;
    }

    public static void main(String[] args){

        int V = 6;
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer>topo = topologicalSort(V, adj);
        System.out.println("Printing Topological Sort" + topo);
    }
}