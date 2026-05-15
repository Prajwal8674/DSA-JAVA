import java.util.Scanner;

public class MagicSquareUsingArray {

    static boolean isValid(int n) {
        return n % 2 != 0;
    }

    static int[][] createMagicSquare(int n) {

        int[][] magic = new int[n][n];

        int row = 0;
        int col = n / 2;

        for (int num = 1; num <= n * n; num++) {

            magic[row][col] = num;

            int nextRow = (row - 1 + n) % n;
            int nextCol = (col + 1) % n;

            if (magic[nextRow][nextCol] != 0) {
                row = (row + 1) % n;
            } else {
                row = nextRow;
                col = nextCol;
            }
        }
        return magic;
    }

    static void printMagicSquare(int[][] magic) {

        int n = magic.length;
        System.out.println("Magic Square:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(magic[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter odd size: ");
        int n = sc.nextInt();

        if (!isValid(n)) {
            System.out.println("Magic Square works only for odd numbers");
            return;
        }

        int[][] magicSquare = createMagicSquare(n);
        printMagicSquare(magicSquare);

        sc.close();
    }
}
