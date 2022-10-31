package Case.Heap;

public class Heaps {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(12);
        minHeap.insert(7);
        minHeap.insert(6);
        minHeap.insert(10);
        minHeap.insert(8);
        minHeap.insert(20);

        minHeap.print();
        System.out.println();

        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert(12);
        maxHeap.insert(7);
        maxHeap.insert(6);
        maxHeap.insert(10);
        maxHeap.insert(8);
        maxHeap.insert(20);
        maxHeap.print();
    }
}
