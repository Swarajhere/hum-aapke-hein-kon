import java.util.*;

class Bully {

    static boolean[] active;
    static int n, coordinator;

    // Election function
    static void election(int initiator) {

        System.out.println("\nProcess " + initiator +
                           " starts election");

        for (int i = initiator + 1; i < n; i++) {

            if (active[i]) {

                System.out.println("Process " + initiator +
                                   " sends ELECTION to " + i);

                election(i);
                return;
            }
        }

        coordinator = initiator;

        System.out.println("Process " + initiator +
                           " becomes COORDINATOR");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        active = new boolean[n];

        // Initially all active
        for (int i = 0; i < n; i++)
            active[i] = true;

        coordinator = n - 1;

        System.out.println("\nInitial Coordinator: " + coordinator);

        // Fail a process
        System.out.print("Enter process to FAIL: ");
        int fail = sc.nextInt();

        active[fail] = false;

        System.out.println("Process " + fail + " failed!");

        // Start election
        System.out.print("\nEnter initiator process: ");
        int initiator = sc.nextInt();

        if (!active[initiator]) {
            System.out.println("Initiator process is DOWN");
        } else {
            election(initiator);

            System.out.println("\nFinal Coordinator: "
                               + coordinator);
        }

        sc.close();
    }
}