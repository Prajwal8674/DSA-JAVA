import java.util.Arrays;

public class SortingCharacters {

    public static void main(String[] args) {

        char[] ch = {'f','a','d','g','h'};
        char temp;
        for (int i = 0 ; i< ch.length-1; i++){

            for (int j = 0 ; j<ch.length-1;j++){

                if(ch[j]>ch[j+1]){
                    temp=ch[j];
                    ch[j]=ch[j+1];
                    ch[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(ch));
    }
}
