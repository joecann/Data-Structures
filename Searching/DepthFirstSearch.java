package searching;

import java.util.ArrayList;
import java.util.Stack;

import dataStructures.Graph;
import dataStructures.Node;

public class DepthFirstSearch {
	Graph g;
	int totalCost = 0;
	public DepthFirstSearch(Graph g) {
		this.g = g;
	}
	public void dfs(int start, int des) {
		Stack<Node> stack = new Stack<>();
		ArrayList<Integer> visited = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<>();
		stack.push(new Node(start,0));
		
		while(!stack.isEmpty()) {
    	   Node v = stack.pop();
    	   totalCost+=v.cost;
    	   path.add(v.value);
    	     	   
    	   if(v.value == des) {
    		   System.out.println("Depth First Search: " + path + " = " + totalCost);
    		   return;
    	   }
    	      	   
    	   for(int j = 0; j < g.getList()[v.value].size(); j++) {
    		   int next = g.getList()[v.value].get(j).des;
    		   Node nextNode = new Node(next);
    		   
			   if(!visited.contains(next)) {				   
				   stack.push(nextNode);
				   visited.add(next);
			   }    	   
		   }
		}
	}
}
