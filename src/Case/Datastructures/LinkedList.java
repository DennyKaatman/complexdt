package Case.Datastructures;

public class LinkedList<T extends Comparable<T>> implements  List<T>{

    private Node<T> head;
    private int size;

    @Override
    public void insert(T data) {
        if(head  == null){
            this.head = new Node<>(data);
        } else {
            createHead(data);
        }

        size++;
    }

    public void createHead(T data){
        Node<T> node = new Node<>(data);
        node.setNext(head);
        this.head = node;
    }

    @Override
    public void search(T data) {
        if(this.head == null){
            return;
        }

        if(this.head.getData().compareTo(data) == 0){
            System.out.println("TRUE" + data.toString());
        } else {
            search(data, head, head.getNext());
        }
    }

    private void search(T data, Node<T> previous, Node<T> pos) {
        while( pos != null){
            if(pos.getData().compareTo(data) == 0){
                System.out.println("TRUE" + data.toString());
                pos = null;
                return;
            }
            previous = pos;
            pos = pos.getNext();
        }
        System.out.println("False " + data.toString());

    }


    @Override
    public void remove(T data) {
        if(this.head == null){
            return;
        }

        // Get rid of head!!!
        if(this.head.getData().compareTo(data) == 0){
            this.head = this.head.next;
        } else {
            remove(data, head, head.getNext());
        }

        size--;
    }

    private void remove(T data, Node<T> previous, Node<T> pos) {
        while( pos != null){
            if(pos.getData().compareTo(data) == 0){
                previous.setNext(pos.getNext());
                pos = null;
                return;
            }
            previous = pos;
            pos = pos.getNext();
        }
    }

    public void display(){
        Node<T> current = head;

        if ( head == null){
            return;
        }

        while (current != null){
            System.out.print(current.getData() + " > ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public void traverse() {
        if(this.head == null){
            return;
        }

        Node<T> pos = this.head;

        while(pos != null){
            System.out.print(pos+ " > ");
            pos = pos.getNext();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort() {

    }
}
