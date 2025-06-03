package Lab10_BST;

public class BST<E extends Comparable<E>> {

    TreeNode<E> root;
    int size;

    public BST() {
        root = null;
        size = 0;
    }
    

    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean insert(E e) {
        if (root == null) {
            root = new TreeNode<>(e);
            return true;
        }
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                return false;
            }
        }
        if (e.compareTo(parent.element) < 0) {
            parent.left = new TreeNode<>(e);
        } else {
            parent.right = new TreeNode<>(e);
        }
        size++;
        return true;
    }

    public int getSize() {
        return size;
    }

    public int height() {
        return height(root);
    }

    public int height(TreeNode<E> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public E getRoot() {
        return root.element;
    }

    public E minValue() {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            parent = current;
            current = current.left;
        }
        return parent.element;
    }

    public E maxValue() {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            parent = current;
            current = current.right;
        }
        return parent.element;
    }

    public java.util.ArrayList<TreeNode<E>> path(E e) {
        java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
        TreeNode<E> current = root;
        while (current != null) {
            list.add(current);
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return list;
            }
        }
        return null;
    }

    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }
        if (current == null) {
            return false;
        }

        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }

        } else {
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element;

            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            } else {
                parentOfRightMost.left = rightMost.left;
            }
        }
        size--;
        return true;
        

    }

    public boolean clear() {
        root = null;
        size = 0;
        return true;
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root + " ");
        inorder(root.right);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root + " ");

    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
