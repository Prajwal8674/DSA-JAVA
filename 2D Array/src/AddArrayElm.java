public class AddArrayElm {
    public static void main(String[] args) {

        int sum=0;
        int[][] arr={ {1,2,3},
                      {4,5,6},
                      {7,8,9}
        };
        for(int i = 0 ; i < arr.length ; i++){

            for (int j = 0; j < arr.length; j++) {

                sum+=arr[i][j];
            }
        }
        System.out.println(sum);
    }
}