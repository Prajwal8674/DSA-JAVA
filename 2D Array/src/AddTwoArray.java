public class AddTwoArray {
    public static void main(String[] args) {

        int [][]a = {{1,2,3},{4,5,6},{7,8,9}};
        int [][]b ={{10,20,30},{40,50,60},{70,80,90}};

        if(a.length==b.length && a[0].length==b[0].length){
            int [][]sum = new int[a.length][a.length];

            for(int i=0 ; i < a.length; i++ ){

                for(int j=0 ; j < a.length; j++ ){
                    sum[i][j]=a[i][j]+b[i][j];
                }
            }
            for (int i = 0; i < sum.length; i++) {

                for (int j = 0; j < sum.length; j++) {
                    System.out.print(sum[i][j]+" ");
                }
                System.out.println();
            }
        }

    }
}
