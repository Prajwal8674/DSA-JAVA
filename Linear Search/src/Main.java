class SearchLinear{

    public int checkNum(int arr[], int size , int key){
        int start=0;
        int end=size-1;
        for(int i =0 ; i<end;i++){

            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
}
public class Main {

    public static void main(String[] args) {
        SearchLinear s1 = new SearchLinear();
        int arr[] = {1,4,5,7,8,9,2,4};
        System.out.println(s1.checkNum(arr,8,12));

    }
}