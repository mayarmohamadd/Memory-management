import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void printMemoryInfo(Vector<Partition> partitions, Vector<Process> unallocatedProcesses2) {
        System.out.println("................................................");
        System.out.println("Partitions:");
        for (Partition p : partitions) {
            System.out.print(p.name + ": (" + p.size + " KB) => ");
            if (p.getProcess() != null)
                System.out.println(p.getProcess().name);
            else
                System.out.println("External Fragment");
        }
        if (unallocatedProcesses2.size() > 0) {
            System.out.println();
            System.out.print("Processes can not be allocated => ");
            for (Process p : unallocatedProcesses2)
                System.out.print(p.name + " ");
        }
        System.out.println();
        System.out.println("................................................");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take Memory.Memory Partitions From the User
        Vector<Partition> partitions = PartitionInput();
        // Take Processes From the User
        Vector<Process> processes = ProcessInput();

        // Select Allocation Method
        int choice;
        do {
            System.out.println("Memory Allocation Policy: ");
            System.out.println("[1] First Fit");
            System.out.println("[2] Worst Fit");
            System.out.println("[3] Best Fit");
            choice = sc.nextInt();
            System.out.println("PRESS Any Other Key For Exit ");

            // Send deep to keep user input from change as we use this inputs many times
            Memory memory = new Memory(getSavePartitions(partitions));
            switch (choice) {
                case 1 -> {
                    memory.setAllocatePolicy(new FirstFit());
                }
                case 2 -> {
                    memory.setAllocatePolicy(new WorstFit());
                }
                case 3 -> {
                    memory.setAllocatePolicy(new BestFit());
                }
                default -> System.exit(0);
            }

            // Allocate Processes into Partitions
            Vector<Process> UnallocateProcess = memory.allocate(getSaveProcesses(processes));
            System.out.println(UnallocateProcess);

            // Print Partitions
            printMemoryInfo(memory.partitionss, UnallocateProcess);

            // Compact Memory?
            System.out.println("Compact Memory?");
            System.out.println("[1] YES");
            System.out.println("[2] NO");
            int choice2 = sc.nextInt();
            if (choice2 == 1) {
                memory.compact();
                Vector<Process> unallocateProcesse2 = memory.allocate(UnallocateProcess);
                printMemoryInfo(memory.partitionss, unallocateProcesse2);
            }
        } while (true);
    }

    public static Vector<Partition> PartitionInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Partitions: ");
        int partitionsNum = sc.nextInt();
        Vector<Partition> partitions = new Vector<>();
        for (int i = 0; i < partitionsNum; i++) {
            System.out.println("Partition [" + (i) + "] :");
            System.out.print("  Name: ");
            String name = sc.next();
            System.out.print("  Size: ");
            int size = sc.nextInt();
            partitions.add(new Partition(name, size));
        }
        return partitions;
    }

    public static Vector<Process> ProcessInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Number of Processes: ");
        int processeNum = sc.nextInt();
        Vector<Process> processes = new Vector<>();
        for (int i = 0; i < processeNum; i++) {
            System.out.println("Process [" + (i + 1) + "] ");
            System.out.print("  Name: ");
            String name = sc.next();
            System.out.print("  Size: ");
            int size = sc.nextInt();
            processes.add(new Process(name, size));
        }
        return processes;
    }

    public static Vector<Partition> getSavePartitions(Vector<Partition> partitions) {
        Vector<Partition> savePartitions = new Vector<Partition>();
        for (Partition p : partitions)
            savePartitions.add(new Partition(p.name, p.size));
        return savePartitions;
    }

    public static Vector<Process> getSaveProcesses(Vector<Process> processes) {
        Vector<Process> saveProcesses = new Vector<Process>();
        for (Process p : processes)
            saveProcesses.add(new Process(p.name, p.size));
        return saveProcesses;
    }
}
