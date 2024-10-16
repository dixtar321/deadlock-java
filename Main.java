
package dop;
import java.util.*;
public class Main {

    public static int findMiddleDivisor(int num) {
        List<Integer> divisors = new ArrayList<>();
        int main_divisor = num;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                divisors.add(i);
            }
        }
        main_divisor = divisors.get(divisors.size()/2);
        return main_divisor;
    }

    public static void main(String[] args) {
        int start = 100;
        int end = 1000;
        // Random random = new Random();
        // int start = random.nextInt(2147483647);
        // int end = start + 10000; //300000000
        int step = findMiddleDivisor(end); //корень из end < 7
        TaskQueue queue = new TaskQueue();
        for (int i = start; i < end; i+=step) {
            queue.push(new TaskQueue.MyTask(i, i+step));
        }

        TasksExecutor executor = new TasksExecutor();
        try {
            executor.findPrimeNumbs(queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }

        queue.showResult();
    }
}