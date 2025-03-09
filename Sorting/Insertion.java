package sorting;

import java.util.Arrays;

public class Insertion {

   public Insertion(int[] arr){
    System.out.println("+++++++++ Insertion ++++++++++");
    System.out.println(Arrays.toString(arr));
    insertion(arr);
    System.out.println("Sorted Array: " + Arrays.toString(arr));
   }

   public void insertion(int arr[]){
    for(int i = 1; i < arr.length; i++){
        int key = arr[i];
        int index = i-1;
        while(index > -1 && arr[index] > key){
            arr[index+1] = arr[index];
            index--;
        }
        arr[index+1]=key;
    }
    


   }
}
