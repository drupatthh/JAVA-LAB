public class RunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread numbers = new Thread(() -> {
            for (int number = 1; number <= 5; number++) {
                System.out.println("Number: " + number);
            }
        });
        Thread letters = new Thread(() -> {
            for (char letter = 'A'; letter <= 'E'; letter++) {
                System.out.println("Letter: " + letter);
            }
        });

        numbers.start();
        letters.start();
        numbers.join();
        letters.join();

        System.out.println("Runnable separates a task from a thread and allows the class to extend another class.");
    }
}
