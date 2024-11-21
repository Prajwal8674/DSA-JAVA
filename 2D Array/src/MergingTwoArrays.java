public class MergingTwoArrays {

    public static void merge(int arr1[], int size1 , int arr2[], int size2, int[] ans){

        int i=0,j=0,k=0;

        while(i<size1 && j<size2){

            if(arr1[i]<arr2[j]){
                ans[k++]=arr1[i++];
            }
            else if(arr1[i]>arr2[j]){
                ans[k++]=arr2[j++];
            }
        }
        while(i<size1){
            ans[k++]=arr1[i++];
        }
        while(j<size2){
            ans[k++]=arr2[j++];
        }
    }
    public static void main(String[] args) {

        int[] arr1={1,3,5,7,9};
        int[] arr2={2,4,6};
        int[] ans = new int[arr1.length+ arr2.length];

//        int i =0,j=0, k=0;
//
//        while(i < arr1.length && j < arr2.length){
//
//            if(arr1[i] < arr2[j]){
//                ans[k++]=arr1[i++];
//            }
//            else if (arr1[i] >  arr2[j]) {
//                ans[k++]=arr2[j++];
//            }
//        }
//        while(i< arr1.length){
//            ans[k]=arr1[i];
//            i++;
//            k++;
//        }
//        while(j < arr2.length){
//            ans[k]=arr2[j];
//            j++;
//            k++;
//        }
        merge(arr1, arr1.length,arr2,arr2.length,ans);
        for (int z = 0; z < ans.length; z++) {
            System.out.print(ans[z] + " ");
        }
    }
}
