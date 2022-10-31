package Case.Heap;

public class MinHeap {
    private int[] heap;
    private int capacity;
    private int pos;

    public MinHeap() {
        pos = 1;
        capacity = 10;
        heap = new int[capacity];
    }

    public void insert(int value) {
        if(pos == capacity){

        } else {
            heap[pos++]= value;

            int child = pos - 1;
            int parent = child / 2;

            while(heap[parent] > heap[child] && parent > 0){
                int tmp = heap[parent];
                heap[parent] = heap[child];
                heap[child] = tmp;

                child = parent;
                parent = child/2;
            }
        }
    }

    public void print(){
        for (int i = 1; i < pos; i++) {
            System.out.print(heap[i] + " ");
        }

    }
}
