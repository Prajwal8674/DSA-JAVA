import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node() {
        data = 0;
        next = null;
    }
}

public class MagicSquare {

    static Node head = null;

    static void createList(int n) {
        Node temp = null;

        for (int i = 0; i < n * n; i++) {
            Node newNode = new Node();

            if (head == null) {
                head = newNode;
                temp = head;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }
    }

    static Node getNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    static void fillMagicSquare(int n) {
        int row = 0;
        int col = n / 2;

        for (int num = 1; num <= n * n; num++) {

            int index = row * n + col;
            getNode(index).data = num+9;

            int nextRow = (row - 1 + n) % n;
            int nextCol = (col + 1) % n;
            int nextIdx = nextRow * n + nextCol;

            if (getNode(nextIdx).data != 0) {
                row = (row + 1) % n;
            } else {
                row = nextRow;
                col = nextCol;
            }
        }
    }

    static void printMagicSquare(int n) {
        System.out.println("Magic Square:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(getNode(i * n + j).data + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter odd size: ");
        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println("Magic Square works only for odd numbers");
            return;
        }

        createList(n);
        fillMagicSquare(n);
        printMagicSquare(n);

    }
}
