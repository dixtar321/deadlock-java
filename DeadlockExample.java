public class DeadlockExample {
    private static final Object lock_1 = new Object();
    private static final Object lock_2 = new Object();

    public static void main(String[] args) {
        Thread thread_1 = new Thread(() -> {
            synchronized (lock_1) {
                System.out.println("Thread 1 acquired lock 1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock_2) {
                    System.out.println("Thread 1 acquired lock 2");
                }
            }
        });

        Thread thread_2 = new Thread(() -> {
            synchronized (lock_2) {
                System.out.println("Thread 2 acquired lock 2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock_1) {
                    System.out.println("Thread 2 acquired lock 1");
                }
            }
        });

        thread_1.start();
        thread_2.start();
    }
}
// массив - 10000 элементов целыми числами от min до max
// start и end генерятся random (проверка, что между ними есть хотя бы одно число)