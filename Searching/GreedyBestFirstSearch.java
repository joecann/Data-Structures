package searching;

import java.util.ArrayList;

import dataStructures.Graph;
import dataStructures.Node;
import dataStructures.PriorityQueue;
import dataStructures.Graph.Edge;

public class GreedyBestFirstSearch {
	int totalCost = 0;
	Graph g;
	/*Greedy Best-First Search does not guarantee 
	 * finding the optimal path, as it can get 
	 * trapped in local optima by always choosing 
	 * the path that looks best at the moment. */
	public GreedyBestFirstSearch(Graph g) {
		this.g = g;
		System.out.println(euclideanDistance(2,2,5,1));
	}
	
	protected double euclideanDistance(int x1, int x2, int y1, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
	
	public void search(int start, int des) {
		ArrayList<Integer> path = new ArrayList<>();
		PriorityQueue queue = new PriorityQueue();
		ArrayList<Node> visited = new ArrayList<>();
			
		queue.enqueue(start,0);
		visited.add(new Node(start, 0));
		
		while(!queue.isEmpty()){
			Node v = queue.dequeue();
			path.add(v.value);
			totalCost+= v.cost;
						
			 if(v.value == des) {
				 System.out.println("Greedy Best First Search: " + path + " = " + totalCost);
				 return;
			 }
				
			for(int j = 0; j < g.getList()[v.value].size(); j++) {
				//TODO add euchlidean distance to cost
				Edge edge = g.getList()[v.value].get(j);
				int next = edge.des;
				int cost = edge.weight;
				Node nextNode = new Node(next,cost);
									
				if(!visited.contains(nextNode)) {
					queue.enqueue(next,cost);
					visited.add(nextNode);
				}
			}
		}
	}

}
