import java.util.concurrent.CountDownLatch;

public class ThreadLifeCycleDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch waiting = new CountDownLatch(1);
        CountDownLatch resume = new CountDownLatch(1);

        Thread worker = new Thread(() -> {
            waiting.countDown();
            try {
                resume.await();
                System.out.println("Runnable (running/ready): "
                        + Thread.currentThread().getState());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "LifecycleWorker");

        System.out.println("New: " + worker.getState());
        worker.start();
        waiting.await();
        Thread.sleep(50);
        System.out.println("Waiting: " + worker.getState());
        resume.countDown();
        Thread.sleep(50);
        System.out.println("Timed waiting: " + worker.getState());
        worker.join();
        System.out.println("Terminated: " + worker.getState());
    }
}
