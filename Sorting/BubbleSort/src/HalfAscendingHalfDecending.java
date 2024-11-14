
public class HalfAscendingHalfDecending {

    public static void main(String[] args) {
        int arr[]={7,5,9,2,3,1,4,8,6,10};
        int temp;
        int mid=arr.length/2;

        for(int i =0 ; i<arr.length-1;i++){

            for(int j = 0 ; j< arr.length-1;j++){

                if(arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for(int i =0 ; i<arr.length-1;i++){

            for(int k = mid ; k< arr.length-1;k++){

                if(arr[k]<arr[k+1]) {
                    temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                }
            }
        }
    }
}
