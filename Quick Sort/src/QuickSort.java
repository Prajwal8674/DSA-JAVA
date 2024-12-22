import java.util.Arrays;

public class QuickSort {

    public static void swap(int[] arr, int a , int b){

        int temp = arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
    }
    public static  int[] partition(int[] arr,int start,int end){

        int pivot = arr[start];
        int count = 0 ;

        for(int i = start+1 ; i <= end ; i++){

            if(arr[i]<=pivot){
                count++;
            }
        }
        int pivotIndex=start+count;
        swap(arr,arr[pivotIndex],arr[start]);
        return arr;
    }
    public static void main(String[] args)
    {
        int[] arr = {3,4,1,2,5};
        //System.out.println(partition(arr,0, arr.length-1));
        partition(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}