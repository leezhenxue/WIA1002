package Lab10_BST;

public class TreeNode<E extends Comparable<E>> implements Comparable<TreeNode<E>>{
    E element;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(TreeNode<E> other) {
        return this.element.compareTo(other.element);
    }

    @Override 
    public String toString() {
        return element.toString();
    }
}
