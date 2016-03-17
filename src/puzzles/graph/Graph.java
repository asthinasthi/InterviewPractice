package puzzles.graph;

import java.util.LinkedList;

public class Graph {

	int numOfVertices;
	LinkedList<Integer> adj[];
	
	public Graph(int v){
		numOfVertices = v;
		adj = new LinkedList[v];
		for(int i=0; i<v ; i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	public void addEdge(int s, int d){
		adj[s].add(d);
	}
	
	public void BFS(int source){
		boolean[] visited = new boolean[numOfVertices];
		visited[source] = true;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		while(!queue.isEmpty()){
			int s = queue.poll();
			System.out.print(s + " --> ");
			for(int element : adj[s]){
				if(!visited[element]){
					visited[element] = true;
					queue.add(element);
				}
			}
		}
		
	}
	
	public static void main(String[] args){
		Graph g = new Graph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
		
        g.BFS(2);
	}
	
}
