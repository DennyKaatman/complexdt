package Case.AVLtree;

public class App {
    public static void main(String[] args) {
        Tree avl = new AVLTree();

    avl.insert(10);
    avl.insert(15);
    avl.insert(5);
    avl.insert(14);


    avl.delete(5);

    avl.traverse();
        System.out.println();

    avl.delete(14);
    avl.insert(15);
    avl.insert(12);

    avl.traverse();
    }

}
