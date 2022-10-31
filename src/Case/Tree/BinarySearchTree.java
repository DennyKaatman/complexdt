package Case.Tree;

public class BinarySearchTree<T extends  Comparable<T>> implements Tree<T> {

    public Node<T> rootNode;

    /**
     * Traversal to test the current tree.
     */
    @Override
    public void traversal() {
        // Check if there is a root
        if(rootNode != null){
            System.out.println("Printing out inOrder traversal...");
            inOrderTraversal(rootNode);
            System.out.println();
            System.out.println("Printing out preOrder traversal...");
            preOrderTraversal(rootNode);
            System.out.println();
            System.out.println("Printing out postOrder traversal...");
            postOrderTraversal(rootNode);
        }
    }

    /**
     * Recursive method that will print the smallest left child to the biggest right child
     */
    private void inOrderTraversal(Node<T> node){
        if(node.getLeftChild() != null){
            inOrderTraversal(node.getLeftChild());
        }

        System.out.print(node + " - ");

        if(node.getRightChild() != null){
            inOrderTraversal(node.getRightChild());
        }
    }

    /**
     * Recursive method that will print the preOrder traversal of the tree
     */
    private void preOrderTraversal(Node<T> node){
        System.out.print(node + " - ");

        if(node.getLeftChild() != null){
            inOrderTraversal(node.getLeftChild());
        }

        if(node.getRightChild() != null){
            inOrderTraversal(node.getRightChild());
        }
    }


    /**
     * Recursive method that will print the preOrder traversal of the tree
     */
    private void postOrderTraversal(Node<T> node){
        if(node.getLeftChild() != null){
            inOrderTraversal(node.getLeftChild());
        }

        if(node.getRightChild() != null){
            inOrderTraversal(node.getRightChild());
        }

        System.out.print(node + " - ");
    }

    @Override
    public void insert(T data) {
        // Check if there is a root, otherwise create a new root
        if(rootNode == null){
            rootNode = new Node<T>(data);
        } else {
            insertNode(data, rootNode);
        }
    }

    /**
     * Recursive method that checks the value of the data, if the data is lower
     * than the current node it will go to the leftChild of the node. Otherwise, it will
     * go to the rightChild.
     *    want to put in the tree
     */
    private void insertNode(T data, Node<T> rootNode) {
        if(data.compareTo(rootNode.getData()) < 0) {
            if(rootNode.getLeftChild() != null){
                insertNode(data, rootNode.getLeftChild());
            } else {
                Node<T> newNode = new Node<T>(data);
                rootNode.setLeftChild(newNode);
            }
        } else {
            if (rootNode.getRightChild() != null){
                insertNode(data, rootNode.getRightChild());
            } else {
                Node<T> newNode = new Node<T>(data);
                rootNode.setRightChild(newNode);
            }
        }
    }

    @Override
    public void delete(T data) {
        // Check if there is a root
        if(rootNode != null){
            rootNode = delete(rootNode, data);
        }
    }

    /**
     * First we check if there is a root, then we use the comperable metho to
     * compare the value to see if we need to remove one child (left or right) or two.
     * @param rootNode is the root of the tree
     * @param data the data we want to delete
     */
    private Node<T> delete(Node<T> rootNode, T data) {
        // Check if there is a root
        if (rootNode == null) {
            return null;
        }

        // Look if data is smaller or bigger then node
        if (data.compareTo(rootNode.getData()) < 0) {
            //We need to set the child and delete it
            rootNode.setLeftChild(delete(rootNode.getLeftChild(), data));
        } else if (data.compareTo(rootNode.getData()) > 0) {
            rootNode.setRightChild(delete(rootNode.getRightChild(), data));
        } else {
            if (rootNode.getLeftChild() == null && rootNode.getRightChild() == null) {
                return null;
            }

            if (rootNode.getLeftChild() == null) {
                // Create a temporary Node to save, remove the right child
                Node<T> tNode = rootNode.getRightChild();
                rootNode = null;
                return tNode;
            } else if (rootNode.getRightChild() == null) {
                // Create a temporary Node to save, remove the left child
                Node<T> tNode = rootNode.getRightChild();
                rootNode = null;
                return tNode;
            }


            // If none of this is the case, it means the root has 2 children and we remove both of the nodes
            Node<T> tNode = getPredecessor(rootNode.getLeftChild());

            rootNode.setData(tNode.getData());
            rootNode.setLeftChild(delete(rootNode.getLeftChild(), tNode.getData()));
        }
        return  rootNode;
    }

    /**
     * Recursive method that gets the highest value
     */
    private Node<T> getPredecessor(Node<T> node){
        if(node.getRightChild() != null){
            return getPredecessor(node.getRightChild());
        }
        return node;
    }

    @Override
    public T getMaxValue() {
        // Check if there is a root
        if(rootNode == null){
            return null;
        }
        return getMax(rootNode);
    }

    /**
     * As long as the node has a right child, call the method recursive
     * and return the right child.
     * @param node is the current node the tree is looking at
     * @return the biggest node
     */
    private T getMax(Node<T> node){
        if(node.getRightChild() != null){
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    @Override
    public T getMinValue() {
        // Check if there is a root
        if(rootNode == null){
            return null;
        }
        return getMin(rootNode);
    }

    /**
     * As long as the node has a left child, call the method recursive
     * and return the left child.
     * @param node is the current node the tree is looking at
     * @return the smallest node
     */
    private T getMin(Node<T> node){
        if(node.getLeftChild() != null){
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }
}
