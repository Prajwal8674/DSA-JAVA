import java.util.Scanner;

/* Passenger details */
class Passenger {
    String name;
    int tier;   // 1 = First, 2 = Second, 3 = Third

    Passenger(String name, int tier) {
        this.name = name;
        this.tier = tier;
    }
}

/* Node for Linked List */
class Node {
    Passenger data;
    Node next;

    Node(Passenger data) {
        this.data = data;
        this.next = null;
    }
}

/* Queue using Linked List */
class SimpleQueue {
    Node front, rear;

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(Passenger p) {
        Node newNode = new Node(p);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    Passenger dequeue() {
        if (isEmpty()) return null;

        Passenger removed = front.data;
        front = front.next;

        if (front == null)
            rear = null;

        return removed;
    }
}

/* Ticket Booking System */
class TicketSystem {

    SimpleQueue firstQueue = new SimpleQueue();
    SimpleQueue secondQueue = new SimpleQueue();
    SimpleQueue thirdQueue = new SimpleQueue();

    int firstSeats = 2;
    int secondSeats = 2;
    int thirdSeats = 3;

    void addPassenger(String name, int tier) {
        Passenger p = new Passenger(name, tier);

        switch (tier) {
            case 1 -> firstQueue.enqueue(p);
            case 2 -> secondQueue.enqueue(p);
            case 3 -> thirdQueue.enqueue(p);
            default -> {
                System.out.println("Invalid tier selection.");
                return;
            }
        }

        System.out.println("Passenger added successfully: " + name);
    }

    void processTickets() {
        System.out.println("------------------------------------");
        System.out.println("Seat Allocation Started");
        System.out.println("------------------------------------");

        allocateFirstTier();
        allocateSecondTier();
        allocateThirdTier();

        System.out.println("------------------------------------");
        System.out.println("Seat Allocation Completed");
        System.out.println("------------------------------------");
    }

    /* Show available seats */
    void showAvailableSeats() {
        System.out.println("------------------------------------");
        System.out.println("AVAILABLE SEATS STATUS");
        System.out.println("------------------------------------");
        System.out.println("First Tier  Seats : " + firstSeats);
        System.out.println("Second Tier Seats : " + secondSeats);
        System.out.println("Third Tier  Seats : " + thirdSeats);
        System.out.println("------------------------------------");
    }

    void allocateFirstTier() {
        while (!firstQueue.isEmpty()) {
            Passenger p = firstQueue.dequeue();

            if (firstSeats > 0) {
                firstSeats--;
                System.out.println(p.name + " allocated First Tier seat");
            }
            else if (secondSeats > 0 && secondQueue.isEmpty()) {
                secondSeats--;
                System.out.println(p.name + " allocated Second Tier seat");
            }
            else if (thirdSeats > 0 && thirdQueue.isEmpty()) {
                thirdSeats--;
                System.out.println(p.name + " allocated Third Tier seat");
            }
            else {
                System.out.println(p.name + " could not be allocated a seat");
            }
        }
    }

    void allocateSecondTier() {
        while (!secondQueue.isEmpty()) {
            Passenger p = secondQueue.dequeue();

            if (secondSeats > 0) {
                secondSeats--;
                System.out.println(p.name + " allocated Second Tier seat");
            }
            else if (thirdSeats > 0 && thirdQueue.isEmpty()) {
                thirdSeats--;
                System.out.println(p.name + " allocated Third Tier seat");
            }
            else {
                System.out.println(p.name + " could not be allocated a seat");
            }
        }
    }

    void allocateThirdTier() {
        while (!thirdQueue.isEmpty()) {
            Passenger p = thirdQueue.dequeue();

            if (thirdSeats > 0) {
                thirdSeats--;
                System.out.println(p.name + " allocated Third Tier seat");
            }
            else {
                System.out.println(p.name + " could not be allocated a seat");
            }
        }
    }
}

/* Main Program */
public class TicketBooking {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TicketSystem system = new TicketSystem();

        while (true) {
            System.out.println("====================================");
            System.out.println("TRAIN TICKET BOOKING SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Passenger");
            System.out.println("2. Allocate Seats");
            System.out.println("3. Show Available Seats");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter passenger name: ");
                String name = sc.nextLine();

                System.out.println("------------------------------------");
                System.out.println("Select Ticket Tier");
                System.out.println("------------------------------------");
                System.out.println("1. First Tier");
                System.out.println("2. Second Tier");
                System.out.println("3. Third Tier");
                System.out.println("------------------------------------");
                System.out.print("Enter tier: ");

                int tier = sc.nextInt();
                system.addPassenger(name, tier);
            }
            else if (choice == 2) {
                system.processTickets();
            }
            else if (choice == 3) {
                system.showAvailableSeats();
            }
            else {
                System.out.println("Program terminated.");
                break;
            }
        }
    }
}
