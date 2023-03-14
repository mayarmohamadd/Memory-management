# Memory-management
You will develop a memory allocation simulator to allocate
variable-sized partitions of the memory to a given sequence of
processes requests. Apply different allocation policies:
1. First-Fit policy.
2. Best-Fit policy.
3. Worst-Fit policy.
● Add compaction (as option for the user): in compaction you shuffle
the memory contents so as to place all free memory together in one
large block.
Input will be as follows:
- Number of partition
- Partition name and its size.
- Number of process requests.
- Process name and its size.
- Selected policy by the user.
Sample input:
Enter number of partition:
6
Enter number of partition:
Partition0 90
Enter number of partition:
Partition1 20
Enter number of partition:
Partition2 5
Enter number of partition:
Partition3 30
Enter number of partition:
Partition4 120
Enter number of partition:
Partition5 80
Enter number of processes:
4
Process name and its size:
Process1 15
Process name and its size:
Process2 90
Process name and its size:
Process3 30
Process name and its size:
Process4 100
Select the policy you want to apply:
1. First fit
2. Worst fit
3. Best fit
Select policy:
1
Partition 0 (15 KB) => Process 1
Partition 6 (30 KB) => Process 3
Partition 8 (45 KB) => External fragment
Partition 1 (20 KB) => External fragment
Partition 2 (5 KB) => External fragment
Partition 3 (30 KB) => External fragment
Partition 4 (90 KB) => Process 2
Partition 7 (30 KB) => External fragment
Partition 5 (80 KB) => External fragment
Process 4 can not be allocated
Do you want to compact? 1.yes 2.no
1
Partition 0 (15 KB) => Process 1
Partition 6 (30 KB) => Process 3
Partition 4 (90 KB) => Process 2
Partition 9 (100 KB) => Process 4
Partition 10 (110 KB) => External fragment
Select policy:
2
Partition 0 (90 KB) => Process 2
Partition 1 (15 KB) => Process 1
Partition 6 (5 KB) => External fragment
Partition 2 (5 KB) => External fragment
Partition 3 (30 KB) => Process 3
Partition 4 (100 KB) => Process 4
Partition 7 (20 KB) => External fragment
Partition 5 (80 KB) => External fragment
Do you want to compact? 1.yes 2.no
1
Partition 0 (90 KB) => Process 2
Partition 1 (15 KB) => Process 1
Partition 3 (30 KB) => Process 3
Partition 4 (100 KB) => Process 4
Partition 8 (110 KB) => External fragment
Select policy:
3
Partition 0 (30 KB) => Process 3
Partition 8 (60 KB) => External fragment
Partition 1 (20 KB) => External fragment
Partition 2 (5 KB) => External fragment
Partition 3 (30 KB) => External fragment
Partition 4 (15 KB) => Process 1
Partition 6 (90 KB) => Process 2
Partition 7 (15 KB) => External fragment
Partition 5 (80 KB) => External fragment
Process 4 can not be allocated
Do you want to compact? 1.yes 2.no
2
