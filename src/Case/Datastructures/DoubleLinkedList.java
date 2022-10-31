package Case.Datastructures;

/**
 * A doubly linked list, this datastructure has nodes inside the list.
 * Every node knows the previous and the next node (if it has).
 * Real Life example: Webpage navigator, go to previous page, go the next page!
 */
public class DoubleLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private int size;

    public DoubleLinkedList(){
        head = null;
        size = 0;
    }

    /**
     * Create head if there is no head yet otherwise add it the to
     * previous node.
     */
    public void createHead(T data){
        if(head == null){
            // Null because it has no previous or next value because: it's new
            head = new Node(data, null, null);
        } else {
            // Create the new node and add the current head to the next for the new created head
            Node node = new Node(data, null, head);
            head.previous = node;
            head = node;
        }
        size++;
    }

    /**
     * Delete the head of the list. Give the new headNode no previous data!
     */
    public void deleteHead(){
        // Check if there is a head
        if(head == null){
            return;
        }

        // Remove the head, get the 2nd node and delete its previous node.
        head = head.next;
        head.previous = null;
        size--;
    }


    /**
     * Create tail if there is no yet otherwise add it the to
     * previous node.
     */
    public void createTail(T data){
        if(head == null){
            // Null because it has no previous or next value because: it's new
            head = new Node(data, null, null);
        } else {
            Node node = head;
            // While the node has a next, go to next to get to the last node
            while(node.next != null){
                node = node.next;
            }

            // Add the last node to the previous and the next is null because it is tail
            Node newNode = new Node(data, node, null);
            node.next = newNode;
        }
    }

    /**
     * Delete the tail of the list! Give the new tailNode no next Data
     */
    public void deleteTail(){
        // Check if there is any node (Case 1)
        if(head == null){
            return;
        }

        // Check if node has a next value  (Case 2)
        if(head.next == null){
            head = null;
            size--;
            return;
        }

        // If node has no next, delete the last one and add to the 2nd last node
        // no node.next to null.
        Node node = head;
        while(node.next != null){
            node = node.next;
        }

        node.next = null;
        size--;
    }

    /**
     * Add a new node to the list
     * @param data you want to add
     * @param index at what index you want to add the data
     */
    public void addNode(T data, int index) {
        // Check if there is any node or index is a right int ()
        if (head == null || index < 1 || index > size) {
            return;
        }

        Node node = head;
        int i = 1;

        // Search for the index where the data has to be added
        while(i < index){
            node = node.next;
            i++;
        }

        // Case 1: New head!
        if(node.previous == null){
            Node newNode = new Node(data, null, node);
            node.previous = newNode;
            head = newNode;
        } else { // Case 2: Add the new node to previous and next
            Node newNode = new Node(data, node.previous, node);
            node.previous.next = newNode;
            node.previous = newNode;
        }
        size++;
    }

    /**
     * Delete a node in the list
     * @param index you want to delete
     */
    public void deleteNode(int index){
        index++;
        // Check if there is any node or index is a right int ()
        if (head == null || index < 1 || index > size) {
            return;
        }


        Node node = head;
        int i = 1;

        // Search for the index where the data has to be added
        while(i < index){
            node = node.next;
            i++;
        }

        if(node.next == null) {
            node.previous.next = null;
        } else if(node.previous == null){
            node = node.next;
            node.previous = null;
            head = node;
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        size--;
    }

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

    public void print(){
        Node node = head;
        while(node != null){
            System.out.print(node.Data() + " > ");
            node = node.next;
            }
    }

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

}
