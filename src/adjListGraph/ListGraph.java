package adjListGraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;



class Graph{
	
	//	Edge object
	class Edge{
		int v; double w;	//destination vertex and weight of the edge
		
		// Constructor
		public Edge(int v, double w) {
			this.v = v;
			this.w = w;
		}
		
		//Edge toString method
		@Override
		public String toString() {
			return "(v:" + this.v + ", w:" + this.w +")";
		}
	}
	
	//Data field ==> an array of LinkedList
	List<Edge>[] G;
	
	//Constructor, n is number of vertices
	public Graph(int n) {
		this.G = new LinkedList[n];
		
		for(int i = 0; i < n; i++) {
			G[i] = new LinkedList<>();
		}
	}
	
	
	//Add a new edge into the graph: u = start vertex, v = end vertex, w = edge weight
	public void addEdge(int u, int v, double w) {
		G[u].add(0, new Edge(v, w));
		G[v].add(0, new Edge(u, w));
	}
	
	
	
	//Graph toString method
	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i < G.length; i++) {
			result += (i + "==>" + G[i] +"\n");
		}
		
		return result;
	}
	
//	DEPTH-FIRST SEARCH
	public boolean hasPathDFS(int src, int dest) {
		Set<Integer> visited = new HashSet<>();
		
		 return hasPathDFS(src, dest, visited);
	}

	private boolean hasPathDFS(int src, int dest, Set<Integer> visited) {
		if(visited.contains(src)) {
			return false;
		}
		if(src == dest){
			return true;
		}

		
		Stack<Integer> st = new Stack<>();
		
		visited.add(src);
		st.push(src);
				
		while(!st.isEmpty()) {
			int curr_node = st.pop();
			
			List<Edge> childList = G[curr_node];
			
			for(Edge edge : childList) {
				if(!visited.contains(edge.v)) {
					st.push(edge.v);
					visited.add(edge.v);
					if(edge.v == dest) {
						return true;
					}
				}
			}
		}
		
		
		return false;
	}
	
	
	
//	BREADTH-FIRST SEARCH
	public boolean hasPathBFS(int src, int dest) {
		Set<Integer> visited = new HashSet<>();
		
		return hasPathBFS(src, dest, visited);
	}

	
	private boolean hasPathBFS(int src, int dest, Set<Integer> visited) {
		if(visited.contains(src)) {
			return false;
		}
		if(src == dest) {
			return true;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(src);
		visited.add(src);
		
		while(!q.isEmpty()) {
			int curr_node = q.poll();
			List<Edge> childList = G[curr_node];
			
			for(Edge edge : childList) {
				if(!visited.contains(edge.v)) {
					visited.add(edge.v);
					q.offer(edge.v);
					if(dest == edge.v) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	
}






public class ListGraph {
	
	public static void main(String[] args) {
//		List<Integer>[] list = new LinkedList[10];
//		
//		for(int i = 0; i < list.length; i++) {
//			list[i] = new LinkedList<>();
//		}
//		
//		list[0].add(21);	list[0].add(39);	list[0].add(-39);	list[0].add(40);
//		list[1].add(232);		list[1].add(42);		list[1].add(234);		list[1].add(345);
//		list[3].add(2);
//		list[5].add(29);
//		list[9].add(122);
//		list[8].add(943);
//		list[7].add(-294);
//		
//		for(List<Integer> l : list) {
//			System.out.println(l);
//		}
		
		
		Graph g = new Graph(10);
		g.addEdge(0, 1, 1.0);
		g.addEdge(0, 2, 1.0);
		g.addEdge(1, 3, 15.0);
		g.addEdge(2, 4, 1.0);
		g.addEdge(3, 5, 1.0);
		g.addEdge(4, 5, 1.0);
		g.addEdge(4, 6, 15.0);
		g.addEdge(9, 7, 1.0);

		System.out.println(g.hasPathDFS(1, 9));
		
		System.out.println(g.hasPathBFS(1, 9));
		
		System.out.println(g.hasPathBFS(1, 6));
		
		
//		System.out.println(g);
	}

}
