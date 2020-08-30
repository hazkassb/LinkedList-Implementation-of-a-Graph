package adjListGraph;

import java.util.LinkedList;
import java.util.List;



class Graph{
	
	//	Edge object
	class Edge{
		int v; double w;	//vertex and weight
		
		// Constructor
		public Edge(int v, double w) {
			this.v = v;
			this.w = w;
		}
		
		//Edge toString methof
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
	}
	
	
	
	//Graph toString methof
	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i < G.length; i++) {
			result += (i + "==>" + G[i] +"\n");
		}
		
		return result;
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
		g.addEdge(0, 2, 1.0);
		g.addEdge(0, 5, 1.0);
		g.addEdge(2, 9, 15.0);
		g.addEdge(9, 2, 1.0);
		g.addEdge(1, 2, 1.0);
		g.addEdge(1, 5, 1.0);
		g.addEdge(3, 9, 15.0);
		g.addEdge(5, 2, 1.0);
		g.addEdge(4, 2, 1.0);
		g.addEdge(7, 5, 1.0);
		g.addEdge(7, 9, 15.0);
		g.addEdge(9, 2, 1.0);

		
		
		
		System.out.println(g);
	}

}
