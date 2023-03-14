
import java.util.Collections;
import java.util.Vector;

public class WorstFit implements Policity {
    
    public void sort(Vector<Partition> partitions) {
        // Sort Vector in Descending Order
        Collections.sort(partitions);
        Collections.reverse(partitions);
    }
}
