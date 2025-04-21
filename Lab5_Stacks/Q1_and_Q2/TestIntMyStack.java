import java.util.Scanner;

public class TestIntMyStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Integer: ");
        int value = input.nextInt();

        MyStack<Integer> stack = new MyStack<>();
        
        for (int i = 1; i <= value ; i++) {
            stack.push(i);
        }

        System.out.println("Size: " + stack.getSize());

        System.out.print("Pop: ");
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

// The output of the element is reverse from what is pushed inside the stack.
// It is because stack is using last-in-first-out way to hold the data.
