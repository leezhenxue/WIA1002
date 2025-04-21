public class FindSum {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(235);
        stack.push(26);
        stack.push(27);
        stack.push(942);
        stack.push(38);
        stack.push(76);
        stack.push(45);
        stack.push(7);
        stack.push(3256);
        stack.push(234);
        stack.push(23);
        stack.push(45);

        System.out.println("Sum: " + sum(stack));
    }

    public static int sum(Stack<Integer> stack) {
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
