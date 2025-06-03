package Lab10_BST;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        System.out.println("Input Data: 45, 88, 54, 76, 98, 1, 2, 20, 6, 53, 42, 100, 86, 32, 28, 65, 14");
        bst.insert(45);
        bst.insert(88);
        bst.insert(54);
        bst.insert(76);
        bst.insert(98);
        bst.insert(1);
        bst.insert(2);
        bst.insert(20);
        bst.insert(6);
        bst.insert(53);
        bst.insert(42);
        bst.insert(100);
        bst.insert(86);
        bst.insert(32);
        bst.insert(28);
        bst.insert(65);
        bst.insert(14);
        System.out.print("Inorder (sorted): ");
        bst.inorder(bst.root);
        System.out.print("\nPostorder: ");
        bst.postorder(bst.root);
        System.out.print("\nPreorder: ");
        bst.preorder(bst.root);

        System.out.println("\nHeight of BST: " + bst.height());
        System.out.println("Root of BST is: " + bst.getRoot());
        System.out.println("check whether 10 is in the tree? " + bst.search(10));
        System.out.print("Delete 53");
        bst.delete(53);
        System.out.print("\nUpdated Inorder data (sorted): ");
        bst.inorder(bst.root);
        System.out.println("\nMin Value: " + bst.minValue());
        System.out.println("Max Value: " + bst.maxValue());
        System.out.println("A path form the root to 6 is: " + bst.path(6));

    }
}
