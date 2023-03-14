
import java.util.Vector;

public class Memory {
    Policity allocatePolicy;
    public Vector<Partition> partitionss;

    public Memory(Vector<Partition> partitions) {
        this.partitionss = partitions;
        this.allocatePolicy = new BestFit(); // Default
    }

    public void setAllocatePolicy(Policity allocationPolicy) {
        this.allocatePolicy = allocationPolicy;
    }

    public Vector<Process> allocate(Vector<Process> jobProcesses) {
        allocatePolicy.sort(partitionss);

        Vector<Process> unallocation_process = new Vector<>();
        for (Process process : jobProcesses) {
            boolean isAllocate = false;
            for (int j = 0; j < partitionss.size(); j++) {
                Partition partition = partitionss.get(j);
                if (partition.isEmpty() && partition.size >= process.size) {
                    int space_extra = partition.size - process.size;
                    partition.setProcess(process);
                    if (space_extra > 0)
                        partitionss.insertElementAt(new Partition("Partition" + ((partitionss.size() + 1) - 1), space_extra),
                                j + 1);
                    isAllocate = true;
                    break;
                }
            }
            if (!isAllocate)
                unallocation_process.add(process);
        }
        return unallocation_process;
    }

    public void compact() {
        int totalSize = 0;
        for (Partition p : partitionss) {
            if (p.getProcess() == null)
                totalSize += p.size;
        }
        // Remove all empty spaces
        partitionss.removeIf(i -> i.getProcess() == null);
        if (totalSize > 0)
            // Add the new Compacted Space
            partitionss.add(new Partition("Compaction Partition: ", totalSize));
    }
}
