//package Case.Tree;
//
//public class AvlTree <T extends  Comparable<T>> implements Tree<T> {
//
//    private Node<T> rootNode;
//
//    @Override
//    public void traversal() {
//
//    }
//
//    @Override
//    public void insert(T data) {
//        rootNode = insert(rootNode, data);
//    }
//
//    @Override
//    public void delete(T data){
//        rootNode = delete(rootNode, data);
//    }
//
//    @Override
//    public T getMaxValue() {
//        return null;
//    }
//
//    @Override
//    public T getMinValue() {
//        return null;
//    }
//
//    private Node leftRotation(Node node){
//        Node tRightNode = node.getRightChild();
//        Node t = tRightNode.getLeftChild();
//
//        tRightNode.setLeftChild(node);
//        node.setRightChild(t);
//
//        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) +1 );
//        tRightNode.setHeight(Math.max(height(tRightNode.getRightChild()), height(tRightNode.getLeftChild())) +1 );
//
//        return tRightNode;
//    }
//}
