package Lab6_Queues.Q3;

import java.util.Scanner;

public class Share {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue share = new Queue<Integer>();
        Queue price = new Queue<Integer>();

        System.out.print("Enter your query (In format 'Buy / Sell x shares at $y each'): ");
        String instruction = input.nextLine();
        int shareNum = 0;
        int sharePrice = 0;
        String action = null;
        int capitalGainLoss = 0;

        do {

            if (instruction.isEmpty()) {
                break;
            }
            String[] instructionWords = instruction.split(" ");
            action = instructionWords[0].toLowerCase();
            shareNum = Integer.parseInt(instructionWords[1]);
            sharePrice = Integer.parseInt(instructionWords[4].replaceAll("[^0-9]", ""));

            if (action.equals("buy")) {
                System.out.println("Buying now...");
                share.enqueue(shareNum);
                price.enqueue(sharePrice);
                System.out.println("Queue for Share: Queue: " + share.toString());
                System.out.println("Queue for Price: Queue: " + price.toString());
            } else if (action.equals("sell")) {
                System.out.println("Selling the shares now...");
                while (shareNum >= (int) share.peek()) {
                    shareNum -= (int) share.peek();
                    capitalGainLoss += (int) share.dequeue() * (sharePrice - (int) price.dequeue());;
                }
                if (shareNum != 0 && !share.isEmpty()) {
                    capitalGainLoss += shareNum * (sharePrice - (int) price.peek());
                    Queue<Integer> tempQueue = new Queue<>();
                    tempQueue.enqueue((int) share.dequeue() - shareNum);
                    while (!share.isEmpty()) {
                        tempQueue.enqueue((int) share.dequeue());
                    }
                    while (!tempQueue.isEmpty()) {
                        share.enqueue(tempQueue.dequeue());
                    }
                }

                System.out.println("Total Capital Gain / Loss: " + capitalGainLoss);
                if (share.isEmpty()) {
                    System.out.println("No shares to sell!");
                }
                System.out.println("Queue for Share: Queue: " + share.toString());
                System.out.println("Queue for Price: Queue: " + price.toString());

            }
            System.out.print("Enter your query (In format 'Buy / Sell x shares at $y each'): ");
            instruction = input.nextLine();

        } while (!instruction.isEmpty());
        System.out.println("Final Capital Gain / Loss: " + capitalGainLoss);
    }
}
