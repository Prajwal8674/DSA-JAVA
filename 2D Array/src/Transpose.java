public class Transpose {

    public static void main(String[] args) {

        int[][] a = new int[3][2];
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] ans =new int[arr[0].length][arr.length];


        System.out.println(arr[0].length);
        System.out.println(arr.length);

        for(int i = 0 ; i < arr.length; i++){

            for(int j = 0; j<arr[0].length; j++){
                ans[i][j] = arr[j][i];
            }
        }

        for(int i = 0 ; i < ans.length; i++){

            for(int j = 0 ; j < ans.length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
