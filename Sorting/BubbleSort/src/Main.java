import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {7,4,9,2,8,6};
        int temp;
        for(int i = 0; i<arr.length-1; i++){

            for(int j = 0; j<arr.length-1;j++){

                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}