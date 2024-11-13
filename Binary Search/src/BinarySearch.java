public class BinarySearch {
    public static int checkBinary(int[] arr,int size, int key){

        int start=0;
        int end=size-1;
        int mid=start+end/2;

        while(start<=end){
            if(arr[mid]==key){
                return mid;
            }
            if(key>arr[mid]){
                start=mid+1;
            }
            else{
               end=mid-1;
            }
            mid=(start+end)/2;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={3,5,7,9,11};
        System.out.println(checkBinary(arr,5,9));
       }
}