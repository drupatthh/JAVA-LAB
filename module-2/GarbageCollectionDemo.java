public class GarbageCollectionDemo {
    static class Demo {
        private final int number;

        Demo(int number) {
            this.number = number;
        }

        void display() {
            System.out.println("Demo object " + number);
        }
    }

    public static void main(String[] args) {
        Demo first = new Demo(1);
        Demo second = new Demo(2);
        Demo third = new Demo(3);

        first.display();
        second.display();
        third.display();

        first = null;
        third = null;
        System.out.println("Some objects are now eligible for garbage collection.");
        System.gc();
        System.out.println("Garbage collection was requested; its exact timing is not guaranteed.");
        second.display();
    }
}
