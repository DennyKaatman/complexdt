package Case.Tree;

/**
 * Interface for the Binary and AVL tree, minimum standards for the trees
 * @param <T>, given data
 */
public interface Tree<T> {
    public void traversal();
    public void insert(T data);
    public void delete(T data);
    public T getMaxValue();
    public T getMinValue();
}
