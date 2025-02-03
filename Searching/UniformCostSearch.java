package searching;

import java.util.ArrayList;
import java.util.LinkedList;

import dataStructures.Graph;
import dataStructures.Node;
import dataStructures.PriorityQueue;
import dataStructures.Graph.Edge;

public class UniformCostSearch {
	int totalCost = 0;
	Graph g;
	public UniformCostSearch(Graph g) {
		this.g = g;
	}
	
	public void search(int start, int des) {
		//boolean visited[] = new boolean[g.vertices];
		LinkedList<Integer> path = new LinkedList<>();
		PriorityQueue queue = new PriorityQueue();
		ArrayList<Node> visited = new ArrayList<>();
		
		queue.enqueue(start,0);
		visited.add(new Node(start, 0));
		
		while(!queue.isEmpty()){
			Node v = queue.dequeue();
			path.add(v.value);
			totalCost+= v.cost;			
			
			 if(v.value == des) {
				 System.out.println("Uniform Cost Search: " + path + " = " + totalCost);
				 return;
			 }
				
			for(int j = 0; j < g.getList()[v.value].size(); j++) {
				
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
