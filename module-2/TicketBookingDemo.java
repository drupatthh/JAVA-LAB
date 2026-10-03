public class TicketBookingDemo {
    static class TicketPool {
        private int remainingTickets = 3;

        synchronized void book(String customer) {
            if (remainingTickets > 0) {
                int ticketNumber = 4 - remainingTickets;
                remainingTickets--;
                System.out.println(customer + " booked ticket " + ticketNumber
                        + "; tickets remaining: " + remainingTickets);
            } else {
                System.out.println(customer + " could not book; no tickets remain");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TicketPool pool = new TicketPool();
        Thread[] customers = new Thread[5];

        for (int index = 0; index < customers.length; index++) {
            String customer = "Customer " + (index + 1);
            customers[index] = new Thread(() -> pool.book(customer));
            customers[index].start();
        }

        for (Thread customer : customers) {
            customer.join();
        }
    }
}
