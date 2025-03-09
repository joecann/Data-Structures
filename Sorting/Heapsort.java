package sorting;

import java.util.Arrays;

//used in priority queues
public class Heapsort {
    public Heapsort(int arr[]){
        System.out.println("++++++++++ Heapsort ++++++++++");
        System.out.println(Arrays.toString(arr));
        heapsort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr) + " N: " + n);
    }
    
    int n = 0;

    void heapsort(int arr[]){
    	int arrlength = arr.length;
        buildmaxheap(arr, arr.length);
        for(int i = arrlength-1; i > 0; i--){
            swap(arr,0,i); 
            heapify(arr,i,0);
        }
    }

    void buildmaxheap(int arr[], int arrlength){
        for(int i = arrlength/2-1; i >= 0; i--){
            heapify(arr,arrlength,i);
        }
    }

    void heapify(int arr[], int arrlength, int root){
        int left = 2*root+1;
        int right = 2*root+2;
        int largest = root;
        if(left < arrlength && arr[left] > arr[largest]) largest = left;
        if(right < arrlength && arr[right] > arr[largest]) largest = right;
        if(largest != root){
            swap(arr, root, largest);
            heapify(arr,arrlength,largest);
        }
    }

    public void swap(int arr[], int i, int j){
        if (arr[i] == arr[j]) return;
        //System.out.println("Swapping: " + arr[i] + " with " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        System.out.println(Arrays.toString(arr));
        n++;
    }
    
}
