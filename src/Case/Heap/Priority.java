package Case.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Priority<T extends Comparable<T>> extends PriorityQueue<T> {

    private T[] elements;
    private int size;
    private int capacity;

    public Priority()
    {
        this(500);
    }

    public Priority(int capacity)
    {
        this.capacity = capacity;
        size = 0;
        elements = (T[]) new Comparable[this.capacity];
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    @Override
    public boolean add(T data) {
        if(size() >= capacity) try {
            throw new Exception("Heap is full");
        } catch (Exception e) {
            e.printStackTrace();
        }
        elements[size++] = data;
        bubbleUp();
        return false;
    }

    private void bubbleUp()
    {
        int child = size() - 1;
        int parent = (child-1)/2;

        while(parent >= 0 && elements[child].compareTo(elements[parent]) < 0)
        {
            swap(child, parent);
            child = parent;
            parent = (child-1)/2;
        }
    }

    public T removeMin() throws Exception
    {
        if(isEmpty()) throw new Exception("Empty heap");
        T root = elements[0];
        swap(size()-1, 0);
        elements[size()-1] = null;
        size--;
        bubbleDown();
        return root;
    }

    private void bubbleDown()
    {
        int parent = 0;
        int leftChild = 2*parent + 1;
        int rightChild = 2*parent + 2;

        int choice = compareAndPick(leftChild, rightChild);

        while(choice != -1)
        {
            swap(choice, parent);
            parent = choice;
            choice = compareAndPick(2*choice+1, 2*choice+2);
        }
    }

    private int compareAndPick(int leftChild, int rightChild)
    {
        if(leftChild >= capacity || elements[leftChild] == null) return -1;
        if((elements[leftChild].compareTo(elements[rightChild]) <= 0)|| (elements[rightChild] == null))
            return leftChild;
        return rightChild;
    }

    private void swap(int child, int parent)
    {
        T t = elements[child];
        elements[child] = elements[parent];
        elements[parent] = t;
    }

    @Override
    public String toString()
    {
        return Arrays.stream(elements)
                .filter(element -> element != null)
                .collect(Collectors.toList()).toString();
    }
}
