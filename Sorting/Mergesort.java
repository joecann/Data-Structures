package sorting;
import java.util.Arrays;


public class Mergesort {
    int count = 0;
    public Mergesort(int[] arr){
        System.out.println("++++++++++++ Mergesort ++++++++++++");
        System.out.println(Arrays.toString(arr));
        mergesort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr) + " N: " + count);
    }

    public void mergesort(int[] arr){
        int n = arr.length;
        if(n < 2) return;
        int mid = n/2;
      
        int left[] = new int[mid];
        int right[] = new int[n-mid];

        for(int i = 0; i < mid; i++) left[i] = arr[i];
        for(int j = mid; j < n; j++) right[j-mid] = arr[j];
        count++;
        mergesort(left);
        mergesort(right);
        merge(arr,left,right,mid,n-mid);
        
        System.out.println(Arrays.toString(arr));
    }

    public void merge(int arr[], int L[], int R[], int left, int right){
        int i = 0; int j = 0; int k = 0;
        while(i < left && j < right){
            if(L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while(i < left) arr[k++] = L[i++];
        while(j < right) arr[k++] = R[j++];
        
    }
    
}
