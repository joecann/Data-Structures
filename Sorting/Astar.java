package maze;

import java.util.*;
import java.util.PriorityQueue;

public class Astar {
	int arr [][];
	Vertex start,goal;
	
	public Astar(int arr[][],Vertex start, Vertex goal) {
				
		this.arr = arr;
		this.start = start;
		this.goal = goal;
		findPath();
	}
	//checks that node stays within the parameters
	public boolean checkPosition(int x, int y) {
		if (x >= 0 && x < arr[0].length && y >= 0 && y < arr.length) return true;
		return false;
	}
	//checks that it is only moving to allowed positions on the grid
	public boolean checkGrid(int x, int y) {
		if(arr[y][x] == 1)return true;
		return false;
	}
	
	//heuristic
	public double getEuclideanDistance(Vertex a, Vertex b) {
		return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
	}
		
	public ArrayList<Vertex> getPath(){
		ArrayList<Vertex> mapPath = new ArrayList<>();
		while(goal.parent != null) {
			mapPath.add(goal);
			goal = goal.parent;			
		}
		mapPath.add(start);
		Collections.reverse(mapPath);		
		return mapPath;
	}
	
	public void findPath() {
		//Priority queue to store nodes to be evaluated, ordered by totalEstimatedCost
		PriorityQueue<Vertex> openset = new PriorityQueue<>((s1, s2) -> Double.compare(s1.totalEstimatedCost, s2.totalEstimatedCost));
		Map<String,Vertex> closedset = new HashMap<>();		
		//init start node
		start.costFromStart = 0;
	    start.estimatedCostToGoal = getEuclideanDistance(start, goal);
	    start.totalEstimatedCost = start.costFromStart + start.estimatedCostToGoal;		
		openset.add(start); //add to queue
		
		while(!openset.isEmpty()) {
			Vertex current = openset.poll();							
			
			if(current.compare(goal)) {//check if goal state
				goal.addParent(current.parent);
   	    		return;
			}
			
			closedset.put(current.getKey(), current);//node has been evalauted
			
			// Check all four directions		    
			int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //up, down, left, right
			for (int[] dir : directions) {
			     int newX = current.x + dir[0];
			     int newY = current.y + dir[1];
			    
			     //position of node abides with the rules of the grid
			     if(checkPosition(newX,newY) && checkGrid(newX,newY)) {
			    	 Vertex neighbour = new Vertex(newX,newY);			    	
			    	 	    	 			    	 
			    	 if (closedset.containsKey(neighbour.getKey())) continue; //if neighbour is already in closed set then continue
			    	 
			    	 double tentativeCostFromStart  = current.costFromStart + 1;
					 //process each neighbour of the current node								
		    	     if (tentativeCostFromStart  < neighbour.costFromStart || !openset.contains(neighbour)) {
		    	    	 //Update costs and parent reference for path reconstruction
				    	 neighbour.addParent(current);
			    	     neighbour.costFromStart = tentativeCostFromStart ;
			    	     neighbour.estimatedCostToGoal = getEuclideanDistance(neighbour, goal);
			    	     neighbour.totalEstimatedCost = neighbour.costFromStart + neighbour.estimatedCostToGoal;
			    	     //Add the neighbour to openset if not already present
			    	     openset.add(neighbour); 
		    	     }
	                	  		    	     
			       }	
				}
			}
		}
}
