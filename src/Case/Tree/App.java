package Case.Tree;

public class App {
    public static void main(String[] args) {

        Tree<Integer> bst = new BinarySearchTree<>();

        bst.insert(0);
        bst.insert(20);
        bst.insert(30);
        bst.insert(40);
        bst.insert(50);
        bst.insert(60);
        bst.insert(5);
        bst.insert(5);
        bst.insert(5);
        bst.delete(20);


        bst.delete(0);
        bst.traversal();
    }
}
