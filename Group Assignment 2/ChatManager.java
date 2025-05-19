// Group Tutorial [Tutorial Number] 
// Group Members: 
// Student 1: [Name] – Singly Linked List 
// Student 2: [Name] – Indexed List 
// Student 3: [Name] – Doubly Linked List with Cursor 
// Student 4: [Name] – Undo/Redo with Stack 
// Student 5: [Name] – Testing 

import java.util.*;

public class ChatManager {

    // ===== Student 1 =====
    // LAU MING HUI – Singly Linked List
    static class SinglyLinkedList {

        static class Node {

            String data;
            Node next;

            //constructor
            Node(String data) {
                this.data = data;
            }
        }

        //instantiate both head and tail nodes
        Node head, tail;

        //add first method
        void addFirst(String msg) {
            //case 1: if no node is in the list
            if (head == null) {
                head = new Node(msg);
                tail = head;
            } //case 2: if there exists node in the list
            else {
                Node temp = new Node(msg);
                temp.next = head;
                head = temp;
            }
        }

        //add last method
        void addLast(String msg) {
            //case 1: if no node is in the list
            if (head == null) {
                head = new Node(msg);
                tail = head;
            } //case 2: there exists node in the list
            else {
                Node temp = new Node(msg);
                tail.next = temp;
                tail = temp;
            }
        }

        //remove first method
        String removeFirst() {
            //case if there is no node in the list
            if (head == null) {
                return null;
            } //case if there exist node in the list
            else {
                Node temp = head;
                head = head.next;
                return temp.data;
            }
        }

        //print method
        void print() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data);
                temp = temp.next;
                System.out.print(" -> ");
            }
            System.out.print("null\n");
        }
    }

    // ===== Student 2 ===== 
    // Lee Zhen Xue – Indexed List 
    static class SinglyLinkedListIndexed extends SinglyLinkedList {

        void addAt(int index, String msg) {
            //return if index less than 0
            if (index < 0) {
                return;
            }
            Node newNode = new Node(msg);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
                if (tail == null) {
                    tail = newNode;
                }
                return;
            }
            Node current = head;
            if (head == null) {
                return;
            }
            for (int i = 0; i < index - 1; i++) {
                System.out.println(i);
                if (current == null) {
                    addLast(msg);
                    return;
                }
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            if (newNode.next == null) {
                tail = newNode;
            }
        }

        String removeAt(int index) {
            //return if index less than 0
            if (index < 0) {
                return null;
            }

            if (index == 0) {
                return removeFirst();
            }
            Node current = head;
            //loop to 
            for (int i = 0; i < index - 1 && current != null; i++) {
                current = current.next;
            }
            if (current.next == null) {
                System.out.println("Index out of bound");
                return null;
            }
            if (current.next == tail) {
                tail = current;
                current.next = null;
                return current.data;
            }
            Node temp = current.next;
            current.next = current.next.next;
            return temp.data;
        }
    }

    // ===== Student 3 =====
    // Too Yun Jie – Doubly Linked List with Cursor
    static class DoublyLinkedListWithCursor {

        static class Node {

            String data;
            Node prev, next;

            Node(String data) {
                this.data = data;
            }
        }
        Node head, tail, cursor;

        void insertAtCursor(String msg) {
            Node messageNode = new Node(msg);
            messageNode.next = null;
            messageNode.prev = null;
            //cursor == null will do also
            if (head == null) {
                head = messageNode;
                tail = messageNode;
                cursor = messageNode;
                return;
            }
            if (cursor == tail) {
                cursor.next = messageNode;
                messageNode.prev = cursor;
                tail = messageNode;
                cursor = messageNode;
                return;
            }
            Node temp = cursor.next;

            cursor.next = messageNode;
            messageNode.prev = cursor;
            messageNode.next = temp;
            temp.prev = messageNode;

            cursor = messageNode;
        }

        void moveLeft() {
            if (cursor.prev != null) {
                cursor = cursor.prev;
            }
        }

        void moveRight() {
            if (cursor.next != null) {
                cursor = cursor.next;
            }
        }

        void print() {
            Node temp = head;
            while (true) {

                if (temp == null) {
                    System.out.print("null\n");
                    break;
                }

                if (temp == cursor) {
                    System.out.print("[" + temp.data + "] <-> ");
                } else {
                    System.out.print(temp.data + " <-> ");
                }
                temp = temp.next;
            }
        }
    }

    // ===== Student 4 ===== 
    // [Name] – Undo/Redo with Stack 
    static class UndoRedoManager {

        Stack<String> actionStack, redoActionStack;

        public UndoRedoManager() {
            actionStack = new Stack<>();
            redoActionStack = new Stack<>();
        }

        public void perform(String action) {
            System.out.println("Perform " + action);
            System.out.println("");
            actionStack.push(action);
            redoActionStack.clear();
        }

        public boolean undo() {
            if (actionStack.isEmpty()) {
                System.out.println("No operations to undo.");
                System.out.println("");
                return false;
            }
            System.out.println("Undo " + actionStack.peek());
            redoActionStack.push(actionStack.pop());
            System.out.println("");
            return true;
        }

        public boolean redo() {
            if (redoActionStack.isEmpty()) {
                System.out.println("No operations to redo.");
                System.out.println("");
                return false;
            }
            System.out.println("Redo " + redoActionStack.peek());
            actionStack.push(redoActionStack.pop());
            System.out.println("");
            return true;
        }

        public void printStacks() {
            if (actionStack.isEmpty()) {
                System.out.println("Action stack is empty.");
            } else {
                Stack<String> temp = (Stack) (actionStack.clone());
                System.out.println("Action stack:");
                while (!temp.isEmpty()) {
                    System.out.println(temp.pop());
                }
            }
            if (redoActionStack.isEmpty()) {
                System.out.println("Redo Action stack is empty.");
            } else {
                Stack<String> temp = (Stack) (redoActionStack.clone());
                System.out.println("Redo Action stack:");
                while (!temp.isEmpty()) {
                    System.out.println(temp.pop());
                }
            }
            System.out.println("");
        }
    }

    //=====Student 5 =====
    //Tan Hao Yang - Testing
    public static void main(String[] args) {
        //test Student 1
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst("Hello");
        list.addLast("How are you?");
        list.removeFirst();
        list.print();

        //test Student 2
        SinglyLinkedListIndexed list2 = new SinglyLinkedListIndexed();
        list2.addAt(0, "I am fine");
        list2.addAt(1, "I am good");
        list2.removeAt(1);
        list2.addLast("How about you?");
        list2.print();

        //test Student 3
        DoublyLinkedListWithCursor history = new DoublyLinkedListWithCursor();
        history.insertAtCursor("Hi");
        history.insertAtCursor("Bye");
        history.moveLeft();
        history.insertAtCursor("Wait");
        history.print();

        //test Student 4
        UndoRedoManager manager = new UndoRedoManager();
        manager.perform("add:Hi");
        System.out.println("Undo: " + manager.undo());
        System.out.println("Redo: " + manager.redo());
        manager.printStacks();
    }
}
