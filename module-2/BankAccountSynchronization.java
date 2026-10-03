import java.util.concurrent.CountDownLatch;

public class BankAccountSynchronization {
    static class Account {
        private int balance = 100;

        boolean unsafeWithdraw(int amount, CountDownLatch bothRead, CountDownLatch release)
                throws InterruptedException {
            int currentBalance = balance;
            if (currentBalance < amount) {
                return false;
            }
            bothRead.countDown();
            release.await();
            balance = currentBalance - amount;
            return true;
        }

        synchronized boolean withdraw(int amount) {
            if (balance < amount) {
                return false;
            }
            balance -= amount;
            return true;
        }

        int getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account unsafeAccount = new Account();
        CountDownLatch bothRead = new CountDownLatch(2);
        CountDownLatch release = new CountDownLatch(1);
        Thread firstUnsafe = new Thread(() -> attemptUnsafeWithdrawal(unsafeAccount, bothRead, release));
        Thread secondUnsafe = new Thread(() -> attemptUnsafeWithdrawal(unsafeAccount, bothRead, release));

        firstUnsafe.start();
        secondUnsafe.start();
        bothRead.await();
        release.countDown();
        firstUnsafe.join();
        secondUnsafe.join();
        System.out.println("Balance after unsynchronized withdrawals: " + unsafeAccount.getBalance());

        Account safeAccount = new Account();
        Thread firstSafe = new Thread(() -> System.out.println(
                "First synchronized withdrawal: " + safeAccount.withdraw(80)));
        Thread secondSafe = new Thread(() -> System.out.println(
                "Second synchronized withdrawal: " + safeAccount.withdraw(80)));

        firstSafe.start();
        secondSafe.start();
        firstSafe.join();
        secondSafe.join();
        System.out.println("Balance after synchronized withdrawals: " + safeAccount.getBalance());
    }

    private static void attemptUnsafeWithdrawal(Account account, CountDownLatch bothRead,
                                                CountDownLatch release) {
        try {
            System.out.println("Unsynchronized withdrawal accepted: "
                    + account.unsafeWithdraw(80, bothRead, release));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
