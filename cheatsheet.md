# Algorithms
| Algorithm | Time Complexity, Space Complexity, Stability | TLDR |
| --------- | ---------- | ----- |
| Insertion Sort | O(N<sup>2</sup>) | With each iteration the next item in the unordered list insert into to its position in the ordered list | Adding elements to a sorted list, stable, less overhead when N is small
| Bubble Sort | O(N<sup>2</sup>) | With each iteration the biggest in the unordered list swaps to the last position in the unordered list |
| Selection Sort | O(N<sup>2</sup>), Not stable | With each iteration the smallest in the unordered list swaps to the first position in the unordered list, Minimal swaps |
| Quick Sort | O(Nlog(N) to O(N<sup>2</sup>), In Place, Not stable | A pivot is selected, two lists are formed one where all elements in the list are smaller than the pivot and one bigger and continue using recursion |
| Merge sort | O(Nlog(N), Additional Memory O(N) | Divide the list into two, sort them and merge them |
| Hybrid | | General purpose sort algorithms found in libraries
| Radix Sort | | [Here](https://en.wikipedia.org/wiki/Radix_sort) |
| Counting Sort | | | [Here](https://www.geeksforgeeks.org/counting-sort/) |
| Bucket Sort | | | [Here](http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Sorting/bucketSort.htm) |



# Data Structures

| Data Structure | Operation | Complexity | Java API | Notes |
| -------------- | --------- | ---------- | ---------| ------|
| Hash Table | Write | O(1) | HashMap#put ||
| Hash Table | Read | O(1) | HashMap#get ||
| Queue | remove | O(1) | LinkedList#remove ||
| Queue | add | O(1) | LinkedList#add ||
| Min Heap | | | PriorityQueue | Priority queue in Java is a min heap based on the ordering given by the comparator. Comparator needs to have at least 3 different state values for it to work properly |

# Special knowledge
1. `utf-8` uses 1 to 4 8-bit chars to encode Unicode code points
2. `utf-16` ues 1 to 2 16-bit chars
3. frequent unicode code points are encoded with lesser number of chars
4. `ascii` encoded text becomes subset of `utf-8` encoded text
5.  In java char is 2 byte. String is internally stored as an array of `char`
6. `StringBuffer` is threadsafe while `StringBuilder` is more efficient
7. The compiler uses `StringBuffer` when you concatenate using `+`
8. `<<` left shift operator, multiplies by 2, `>>` divides by 2. `>>>` logical right shift, fills MSB with 0 not sign bit
9. `^` is xor.
10. 2<sup>s</sup> complement of a number k represented with n digits (excluding sign bit) is 2<sup>n</sup> - k.
11. Negative numbers are represented using 2<sup>s</sup> complement of the absolute value of the number and a 1 in sign bit.
12. Positive numbers are presented as it is.
13. In Java, arithmetic operators like `+` have precedence over logical operators like `<<`.
14. Helpful java api to memorize `Arrays.fill(int[] arr, int val)`
15. Java datatype basics [here](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)