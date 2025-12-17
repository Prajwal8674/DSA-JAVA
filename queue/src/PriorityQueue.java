public class PriorityQueue {

    int[] pq = new int[10];
    int size = 0;

    // Insert element
    void insert(int value) {
        pq[size++] = value;
    }

    // Delete lowest priority element
    int delete() {
        int max = 0;
        for (int i = 1; i < size; i++) {
            if (pq[i] < pq[max]) {
                max = i;
            }
        }
        
        int item = pq[max];
        pq[max] = pq[size - 1];
        size--;
        return item;
    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(pq[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        PriorityQueue p = new PriorityQueue();

        p.insert(10);
        p.insert(30);
        p.insert(20);

        p.display();
        System.out.println("Deleted: " + p.delete());
        p.display();

    }
}
