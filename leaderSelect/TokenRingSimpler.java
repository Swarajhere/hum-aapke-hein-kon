import java.util.*;

class TokenRingElection {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        boolean[] active = new boolean[n];

        // Initially all active
        for (int i = 0; i < n; i++)
            active[i] = true;

        // Fail process
        System.out.print("Enter process to FAIL: ");
        int fail = sc.nextInt();

        active[fail] = false;

        // Initiator
        System.out.print("Enter initiator process: ");
        int initiator = sc.nextInt();

        if (!active[initiator]) {
            System.out.println("Initiator process is DOWN");
            return;
        }

        System.out.println("\nProcess "
                + initiator +
                " starts election\n");

        int current = initiator;
        int maxId = initiator;

        // Token circulation
        do {

            System.out.println("Election message passed from "
                    + current + " to "
                    + ((current + 1) % n));

            if (active[current] && current > maxId) {
                maxId = current;
            }

            current = (current + 1) % n;

        } while (current != initiator);

        // Final leader
        System.out.println("\nLeader elected is: " + maxId);

        sc.close();
    }
}

// sairaj token ring-
// class TokenRingElection {

// public static void main(String[] args) {

// int n = 5;
// boolean[] active = { true, true, true, true, true };

// int initiator = 2;

// System.out.println("Process " + initiator +
// " starts election\n");

// int current = initiator;
// int maxId = initiator;

// do {

// System.out.println("Election message passed from "
// + current + " to "
// + ((current + 1) % n));

// if (active[current] && current > maxId) {
// maxId = current;
// }

// current = (current + 1) % n;

// } while (current != initiator);

// System.out.println("\nLeader elected is: " + maxId);
// }
// }