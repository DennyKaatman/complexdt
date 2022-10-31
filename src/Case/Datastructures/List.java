package Case.Datastructures;

public interface List<T extends Comparable<T>> {
    public void insert(T data);
    void search(T data);
    public void remove(T data);
    public void traverse();
    public int size();
    public void sort();
    public void display();
}
