package Case.AVLtree;

public class AVLTree implements Tree {
    private Node root;

    @Override
    public void insert(int data) {
        root = insert(root, data);
    }

    @Override
    public void delete(int data) {
       root = delete(root, data);
    }

    private Node insert(Node node, int data) {

        if (node == null){
            return new Node(data);
        }

        if(data < node.getData()) {
            node.setLeftNode(insert(node.getLeftNode(),data));
        } else {
            node.setRightNode(insert(node.getRightNode(), data));
        }

        node.setHeight( Math.max( height(node.getLeftNode()), height(node.getRightNode())) +1);

        node = settleViolation(data, node);
        
        
        return node;
    }

    private Node settleViolation(int data, Node node) {

        int balance = getBalance(node);

        // Case 1: Left Heavy Tree LEFT:LEFT
        if(balance > 1 && data < node.getLeftNode().getData()) {
            return rightRotation(node);
        }

        // Case 2: Right Heavy TREE right:right
        if(balance < -1 && data > node.getRightNode().getData()) {
            return leftRotation(node);
        }

        // Case 3: Left Right
        if( balance > 1 && data > node.getLeftNode().getData()) {
            node.setLeftNode(leftRotation(node.getLeftNode()));
            return rightRotation(node);
        }

        // Case 4: Right left
        if( balance < -1 && data < node.getRightNode().getData()) {
            node.setRightNode(rightRotation(node.getRightNode()));
            return leftRotation(node);
        }


        return node;
    }

    private Node delete(Node node, int data){

        if (node == null) return node;

        if(data < node.getData()){
            node.setLeftNode(delete(node.getLeftNode(),data));
        } else if(data > node.getData()){
            node.setRightNode(delete(node.getRightNode(),data));
        } else {
            if (node.getLeftNode() == null && node.getRightNode() == null){
                System.out.println("Removing a leaf node");
                return null;
            }

            if(node.getLeftNode() == null){
                System.out.println("Removing the right child..");
                Node tempNode = node.getRightNode();
                node = null;
                return tempNode;
            } else if (node.getRightNode() == null){
                System.out.println("Removing the left child..");
                Node tempNode = node.getLeftNode();
                node = null;
                return tempNode;
            }

            System.out.println("Removing item with two children...");
            Node tempNode = getPredecessor(node.getLeftNode());
            
            node.setData(tempNode.getData());
            node.setLeftNode(delete(node.getLeftNode(), tempNode.getData()));
        }
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
    
        return settleDeletion(node);
    }

    private Node settleDeletion(Node node) {
        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.getLeftNode()) < 0){
                node.setLeftNode(leftRotation(node.getLeftNode()));
            }
            return rightRotation(node);
        }

        if (balance < -1) {
            if (getBalance(node.getRightNode()) > 0){
                node.setRightNode(rightRotation(node.getRightNode()));
            }
            return leftRotation(node);
        }

        return node;
    }

    private Node getPredecessor(Node node) {
        Node predecessor = node;

        while(predecessor.getRightNode() !=null)
            predecessor = predecessor.getRightNode();

        return predecessor;
    }

    private Node rightRotation(Node node){
        System.out.println("Rotating to right...ON NODE:" + node);

        Node tempLeftNode = node.getLeftNode();
        Node t = tempLeftNode.getRightNode();

        tempLeftNode.setRightNode(node);
        node.setLeftNode(t);

        node.setHeight( Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
        tempLeftNode.setHeight( Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode()))+1);

        return tempLeftNode;
    }

    private Node leftRotation(Node node){
        System.out.println("Rotating to left... ON NODE:" + node );

        Node tempRightNode = node.getRightNode();
        Node t = tempRightNode.getLeftNode();

        tempRightNode.setLeftNode(node);
        node.setRightNode(t);

        node.setHeight( Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
        tempRightNode.setHeight( Math.max(height(tempRightNode.getRightNode()), height(tempRightNode.getLeftNode()))+1);

        return tempRightNode;
    }

    private int height(Node node){
        if(node == null) {
            return -1;
        }

        return node.getHeight();
    }

    private int getBalance(Node node){
        if (node == null){
            return 0;
        }
        return height(node.getLeftNode()) - height(node.getRightNode());
    }

    @Override
    public void traverse() {
        if (root == null) return;

        inOrderTraversal(root);
    }



    private void inOrderTraversal(Node node) {
        if(node.getLeftNode() != null){
            inOrderTraversal(node.getLeftNode());
        }

        System.out.println(node);

        if(node.getRightNode() != null){
            inOrderTraversal(node.getRightNode());
        }
    }
}
