package Case.Datastructures;

import Case.ScanData.WaitingClient;

public class App {
    public static void main(String[] args) {
        DoubleLinkedList dl = new DoubleLinkedList();

        dl.createHead(1);
        dl.createHead(2);
        dl.createHead(3);
        dl.addNode(4,3);
        dl.deleteHead();
        dl.deleteNode(3);
        dl.search(3);


        dl.createTail(5);

        dl.print();

        System.out.println();


        List<Integer> list = new LinkedList<>();

        list.insert(10);
        list.insert(-2);
        list.insert(3);
        list.insert(5);
        list.insert(30);
        list.insert(7);
        list.insert(8);
        list.insert(100);
        list.remove(3);
        list.search(3);
        list.display();
        // To: do SORT
        list.display();

        System.out.println();
    }
}
