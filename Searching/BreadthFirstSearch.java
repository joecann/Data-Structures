package searching;
import java.util.LinkedList;

import dataStructures.Graph;
import dataStructures.Node;

import java.util.ArrayList;

public class BreadthFirstSearch {
	int totalCost = 0;
	Graph g;
	public BreadthFirstSearch(Graph g) {
		this.g = g;
	}
	
	public void bfs(int start, int des) {
		boolean visited[] = new boolean[g.vertices];
		LinkedList<Node> queue = new LinkedList<>();
		ArrayList<Integer> path = new ArrayList<>();
		
		queue.push(new Node(start,0));
		visited[start]=true;
		
		while(!queue.isEmpty()){
			Node v = queue.poll();
			if(!path.contains(v.value))path.add(v.value);//remove if to show full visited nodes
			visited[v.value]=true;
			totalCost+=v.cost;
			
			if(v.value == des) {
				 System.out.println("Breadth First Search: " + path + " = " + totalCost);
				 return;
			}
					
			for(int j = 0; j < g.getList()[v.value].size(); j++) {
				int next = g.getList()[v.value].get(j).des;
				int cost = g.getList()[v.cost].get(j).weight;
				Node nextNode = new Node(next,cost);
				if(!visited[nextNode.value]) {
					queue.add(nextNode);
					
				}
			}
		}
	}

}
