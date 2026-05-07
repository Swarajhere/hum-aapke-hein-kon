import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no. of processes: ");
        int n = sc.nextInt();

        System.out.println("\nRing:");
        for (int i = 0; i < n; i++)
            System.out.print(i + " -> ");
        System.out.println("0");

        System.out.print("Sender: ");
        int sender = sc.nextInt();

        System.out.print("Receiver: ");
        int receiver = sc.nextInt();

        sc.nextLine();
        System.out.print("Message: ");
        String msg = sc.nextLine();

        int token = 0;

        while (token != sender) {
            System.out.println("Token passed to process " + token);
            token = (token + 1) % n;
        }

        System.out.println("\n Token reached sender " + sender);

        System.out.println("Process " + sender + " enters Critical Section");

        int i = sender;
        while (i != receiver) {
            System.out.println("Message forwarded from " + i + " to " + ((i + 1) % n));
            i = (i + 1) % n;
        }

        System.out.println("\nReceiver " + receiver + " received message: " + msg);
        System.out.println("Process " + sender + " exits Critical Section");
        sc.close();
    }
}