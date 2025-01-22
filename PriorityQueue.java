package dataStructures;
import java.util.ArrayList;

public class PriorityQueue {
	//curently returns max number
	public class Sort {
		  
	    //compare the i number with the next j. if the i is lower then pivot & i then swap
	    public Sort(ArrayList<Node> arr,int start, int end){
	        sort(arr,start,end);
	    }

	    public int partition(ArrayList<Node> arr, int start, int end) {
	        int pivot = arr.get(end).cost;
	        int i = start-1;
	        for(int j = start; j < end; j++){
	            if(arr.get(j).cost <= pivot){ //change < or > for min or max return
	                i++;
	                swap(arr,i,j);
	            }
	        }
	        swap(arr,i+1,end);
	        return i+1;
	    }

	    public void sort(ArrayList<Node> arr, int start, int end){
	        if(start < end){
	            int pi = partition(arr, start, end);
	            sort(arr,start,pi-1);
	            sort(arr,pi+1,end);
	        }
	    }

	    public void swap(ArrayList<Node> arr, int i, int j){
	        if (arr.get(i).value == arr.get(j).value) return;
	        Node temp = arr.get(i);
	        arr.set(i, arr.get(j));
	        arr.set(j, temp);
	    }
	}
	
	ArrayList<Node> arr;	
	public PriorityQueue() {
		arr = new ArrayList<>();
	}
	
	public void enqueue(int node, int cost) {
		arr.add(new Node(node,cost));
		if(arr.size()>1) new Sort(arr,0,arr.size()-1);
	}
	
	public Node peek() {
		return arr.get(0); 		
	}
	
	public Node dequeue() {
		Node value = arr.get(0);
		arr.remove(0);
		return value;
	}
	
	public boolean isEmpty() {
		if(arr.isEmpty()) return true;
		return false;
	}
		
	public void print() {
		try {
			for(int i = 0; i < arr.size(); i++) {
				System.out.print(arr.get(i).value + "(" + arr.get(i).cost + ")");
			}
			System.out.println();
		} 
		catch (Exception e) {}
	}
}
