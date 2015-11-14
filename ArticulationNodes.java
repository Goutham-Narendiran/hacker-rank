package com.interview.array;

import java.util.ArrayList;
import java.util.HashMap;


////TARJANS ALGORITHM
//The second case is trickier. We maintain an array disc[] to store
//discovery time of vertices. For every node u, we need to find out the 
//earliest visited vertex (the vertex with minimum discovery time) that can be reached from subtree rooted with u.
//So we maintain an additional array low[] which is defined as follows.
class Graph{
	int V;
	HashMap<Integer,ArrayList<Integer>> adj; // adjacency list
	static int time;
	public Graph(int V){
		this.V = V;
		adj = new HashMap<>();
	}

	public void addEdge(int v, int w){
		if(adj.containsKey(v)){
			adj.get(v).add(w);
		}
		else{
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(w);
			adj.put(v, temp);
		}

		//coz graph is undirected
		if(adj.containsKey(w)){
			adj.get(w).add(v);
		}
		else{
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(v);
			adj.put(w, temp);
		}

	}

	public void AP(){
		boolean visited[] = new boolean[V];
		int disc[] = new int[V];
		int low[] = new int[V];
		int parent[] = new int[V];
		boolean ap[] = new boolean[V];//to store articulation points

		// Initialize parent and visited, and ap(articulation point) arrays
		for (int i = 0; i < V; i++)
		{
			parent[i] = -1;
			visited[i] = false;
			ap[i] = false;
		}

		// Call the recursive helper function to find articulation points
		// in DFS tree rooted with vertex 'i'
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				APUtil(i, visited, disc, low, parent, ap);

		// Now ap[] contains articulation points, print them
		for (int i = 0; i < V; i++)
			if (ap[i] == true)
				System.out.println(i+" ");


	}

	public void APUtil(int u,boolean visited[],int disc[],int[] low,int parent[],boolean ap[]){
		//time = 0;
		int children =0;

		//mark current node as visited
		visited[u] = true;

		//initialize discovery time and low value;
		disc[u] = low[u] = ++time;
		ArrayList<Integer> list = adj.get(u);
		if(list==null)
			return;
		for(int v : list){
			// If v is not visited yet, then make it a child of u
			// in DFS tree and recur for it
			if(!visited[v]){
				children++;
				parent[v] = u;
				APUtil(v, visited, disc, low, parent, ap);

				// Check if the subtree rooted with v has a connection to
				// one of the ancestors of u
				low[u]  = Math.min(low[u], low[v]);


				// (1) u is root of DFS tree and has two or more independent children.
				if (parent[u] == -1 && children > 1)
					ap[u] = true;

				// (2) If u is not root and low value of one of its child is more
				// than discovery value of u.
				if (parent[u] != -1 && low[v] >= disc[u])
					ap[u] = true;
			}

			// Update low value of u for parent function calls.
			else if (v != parent[u])
				low[u]  = Math.min(low[u], disc[v]);

		}
	}

}

public class ArticulationNodes {
	public static void main(String...args){
       
		Graph g3 = new Graph(7);
		g3.addEdge(0, 1);
	    g3.addEdge(1, 2);
	    g3.addEdge(2, 0);
	    g3.addEdge(1, 3);
	    g3.addEdge(1, 4);
	    g3.addEdge(1, 6);
	    g3.addEdge(3, 5);
	    g3.addEdge(4, 5);
	    g3.AP();
	    
//	    Graph g1 = new Graph(5);
//	    g1.addEdge(1, 0);
//	    g1.addEdge(0, 2);
//	    g1.addEdge(2, 1);
//	    g1.addEdge(0, 3);
//	    g1.addEdge(3, 4);
//	    g1.AP();
		
	}
}
