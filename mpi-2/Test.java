import mpi.*;

public class Test {
    public static void main(String args[]) throws Exception {

        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();

        int n = 8;
        int chunkSize = n / size;

        int[] send = null;
        int[] recv = new int[chunkSize];

        if (rank == 0) {
            send = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        } else {
            send = new int[n];
        }

        // Scatter
        MPI.COMM_WORLD.Scatter(send, 0, chunkSize, MPI.INT,
                recv, 0, chunkSize, MPI.INT, 0);

        // Local average
        double localSum = 0;

        for (int i = 0; i < recv.length; i++)
            localSum += recv[i];

        double localAvg = localSum / recv.length;

        System.out.println("Process " + rank +
                " Local Avg: " + localAvg);

        // Gather local averages
        double[] gathered = new double[size];

        MPI.COMM_WORLD.Gather(
                new double[] { localAvg }, 0, 1, MPI.DOUBLE,
                gathered, 0, 1, MPI.DOUBLE, 0);

        // Final average
        if (rank == 0) {

            double finalSum = 0;

            for (int i = 0; i < gathered.length; i++)
                finalSum += gathered[i];

            double finalAvg = finalSum / size;

            System.out.println("Final Average: " + finalAvg);
        }

        MPI.Finalize();
    }
}

/*
 * import mpi.*;
 * 
 * public class MPISum {
 * public static void main(String args[]) throws Exception {
 * 
 * MPI.Init(args);
 * 
 * int rank = MPI.COMM_WORLD.Rank();
 * int size = MPI.COMM_WORLD.Size();
 * 
 * int n = 8;
 * int chunkSize = n / size;
 * 
 * int[] send = null;
 * int[] recv = new int[chunkSize];
 * 
 * if (rank == 0) {
 * send = new int[]{1,2,3,4,5,6,7,8};
 * } else {
 * send = new int[n];
 * }
 * 
 * // Scatter
 * MPI.COMM_WORLD.Scatter(send, 0, chunkSize, MPI.INT,
 * recv, 0, chunkSize, MPI.INT, 0);
 * 
 * // Local sum
 * int localSum = 0;
 * 
 * for (int i = 0; i < recv.length; i++)
 * localSum += recv[i];
 * 
 * System.out.println("Process " + rank +
 * " Local Sum: " + localSum);
 * 
 * // Gather local sums
 * int[] gathered = new int[size];
 * 
 * MPI.COMM_WORLD.Gather(
 * new int[]{localSum}, 0, 1, MPI.INT,
 * gathered, 0, 1, MPI.INT, 0);
 * 
 * // Final sum at root
 * if (rank == 0) {
 * 
 * int finalSum = 0;
 * 
 * for (int i = 0; i < gathered.length; i++)
 * finalSum += gathered[i];
 * 
 * System.out.println("Final Sum: " + finalSum);
 * }
 * 
 * MPI.Finalize();
 * }
 * }
 * 
 * 
 * 
 * import mpi.*;
 * 
 * public class MPIMultiply {
 * public static void main(String args[]) throws Exception {
 * 
 * MPI.Init(args);
 * 
 * int rank = MPI.COMM_WORLD.Rank();
 * int size = MPI.COMM_WORLD.Size();
 * 
 * int n = 8;
 * int chunkSize = n / size;
 * 
 * int[] send = null;
 * int[] recv = new int[chunkSize];
 * 
 * if (rank == 0) {
 * send = new int[]{1,2,3,4,5,6,7,8};
 * } else {
 * send = new int[n];
 * }
 * 
 * // Scatter
 * MPI.COMM_WORLD.Scatter(send, 0, chunkSize, MPI.INT,
 * recv, 0, chunkSize, MPI.INT, 0);
 * 
 * // Local product
 * int localProd = 1;
 * 
 * for (int i = 0; i < recv.length; i++)
 * localProd *= recv[i];
 * 
 * System.out.println("Process " + rank +
 * " Local Product: " + localProd);
 * 
 * // Gather local products
 * int[] gathered = new int[size];
 * 
 * MPI.COMM_WORLD.Gather(
 * new int[]{localProd}, 0, 1, MPI.INT,
 * gathered, 0, 1, MPI.INT, 0);
 * 
 * // Final product
 * if (rank == 0) {
 * 
 * int finalProd = 1;
 * 
 * for (int i = 0; i < gathered.length; i++)
 * finalProd *= gathered[i];
 * 
 * System.out.println("Final Product: " + finalProd);
 * }
 * 
 * MPI.Finalize();
 * }
 * }
 * 
 * 
 * 
 * import mpi.*;
 * 
 * public class MPIAverage {
 * public static void main(String args[]) throws Exception {
 * 
 * MPI.Init(args);
 * 
 * int rank = MPI.COMM_WORLD.Rank();
 * int size = MPI.COMM_WORLD.Size();
 * 
 * int n = 8;
 * int chunkSize = n / size;
 * 
 * int[] send = null;
 * int[] recv = new int[chunkSize];
 * 
 * if (rank == 0) {
 * send = new int[]{1,2,3,4,5,6,7,8};
 * } else {
 * send = new int[n];
 * }
 * 
 * // Scatter
 * MPI.COMM_WORLD.Scatter(send, 0, chunkSize, MPI.INT,
 * recv, 0, chunkSize, MPI.INT, 0);
 * 
 * // Local average
 * double localSum = 0;
 * 
 * for (int i = 0; i < recv.length; i++)
 * localSum += recv[i];
 * 
 * double localAvg = localSum / recv.length;
 * 
 * System.out.println("Process " + rank +
 * " Local Avg: " + localAvg);
 * 
 * // Gather local averages
 * double[] gathered = new double[size];
 * 
 * MPI.COMM_WORLD.Gather(
 * new double[]{localAvg}, 0, 1, MPI.DOUBLE,
 * gathered, 0, 1, MPI.DOUBLE, 0);
 * 
 * // Final average
 * if (rank == 0) {
 * 
 * double finalSum = 0;
 * 
 * for (int i = 0; i < gathered.length; i++)
 * finalSum += gathered[i];
 * 
 * double finalAvg = finalSum / size;
 * 
 * System.out.println("Final Average: " + finalAvg);
 * }
 * 
 * MPI.Finalize();
 * }
 * }
 * 
 * 
 * 
 * import mpi.*;
 * 
 * public class MPIReciprocal {
 * public static void main(String args[]) throws Exception {
 * 
 * MPI.Init(args);
 * 
 * int rank = MPI.COMM_WORLD.Rank();
 * int size = MPI.COMM_WORLD.Size();
 * 
 * int n = 8;
 * int chunkSize = n / size;
 * 
 * int[] send = null;
 * int[] recv = new int[chunkSize];
 * 
 * if (rank == 0) {
 * send = new int[]{1,2,3,4,5,6,7,8};
 * } else {
 * send = new int[n];
 * }
 * 
 * // Scatter
 * MPI.COMM_WORLD.Scatter(send, 0, chunkSize, MPI.INT,
 * recv, 0, chunkSize, MPI.INT, 0);
 * 
 * // Reciprocal calculation
 * double[] recArr = new double[chunkSize];
 * 
 * for (int i = 0; i < recv.length; i++)
 * recArr[i] = 1.0 / recv[i];
 * 
 * // Gather reciprocals
 * double[] result = new double[n];
 * 
 * MPI.COMM_WORLD.Gather(
 * recArr, 0, chunkSize, MPI.DOUBLE,
 * result, 0, chunkSize, MPI.DOUBLE, 0);
 * 
 * // Print final reciprocal array
 * if (rank == 0) {
 * 
 * System.out.print("Reciprocal Array: ");
 * 
 * for (int i = 0; i < result.length; i++)
 * System.out.print(result[i] + " ");
 * 
 * System.out.println();
 * }
 * 
 * MPI.Finalize();
 * }
 * }
 */