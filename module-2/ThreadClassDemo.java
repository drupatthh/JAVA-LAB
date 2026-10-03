public class ThreadClassDemo {
    static class NumberThread extends Thread {
        @Override
        public void run() {
            for (int number = 1; number <= 5; number++) {
                System.out.println("Number: " + number);
            }
        }
    }

    static class CharacterThread extends Thread {
        @Override
        public void run() {
            for (char character = 'A'; character <= 'E'; character++) {
                System.out.println("Character: " + character);
            }
        }
    }

    static class MessageThread extends Thread {
        @Override
        public void run() {
            for (int count = 1; count <= 5; count++) {
                System.out.println("Message from thread");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread numbers = new NumberThread();
        Thread characters = new CharacterThread();
        Thread messages = new MessageThread();

        numbers.start();
        characters.start();
        messages.start();

        numbers.join();
        characters.join();
        messages.join();
    }
}
