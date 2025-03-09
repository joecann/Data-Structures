package sorting;
import java.util.Arrays;

public class Quicksort {
    int n = 0;
    //compare the i number with the next j. if the i is lower then pivot & i then swap
    public Quicksort(int arr[],int start, int end){
        System.out.println("+++++++++ Quicksort ++++++++++");
        System.out.println(Arrays.toString(arr));
        sort(arr,start,end);
        System.out.println("Sorted Array: " + Arrays.toString(arr) + " N: " + n);
    }

    public int partition(int arr[], int start, int end) {
    	 int pivot = arr[end];
    	System.out.println("PARTITION" + Arrays.toString(arr) + pivot);
       
        int i = start-1;
        for(int j = start; j < end; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,end);
        return i+1;
    }

    public void sort(int arr[], int start, int end){
    	System.out.println("SORT" + Arrays.toString(arr) + arr[end]);
        if(start < end){
            int pi = partition(arr, start, end);
            sort(arr,start,pi-1);
            sort(arr,pi+1,end);
        }
    }

    public void swap(int arr[], int i, int j){
        if (arr[i] == arr[j]) return;
        System.out.print("SWAP: " + arr[i] + " with " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        System.out.println(Arrays.toString(arr));
        n++;
    }
    
}