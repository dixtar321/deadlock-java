package dop;
import java.util.*;

public class TaskQueue {

    LinkedList<MyTask> tasks = new LinkedList<>();

    static class MyTask {
        private ArrayList<Integer> answers;
        private int start, end;

        public MyTask(int start, int end) {
            this.answers = new ArrayList<>();
            this.start = start;
            this.end = end;
        }

        public void addPrime(Integer num) {
            answers.add(num);
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public boolean isComplete() {
            return !answers.isEmpty();
        }
    }

    public void push(MyTask task) {
        synchronized (tasks) {
            tasks.add(task);
        }
    }

    public MyTask pop() {
        synchronized (tasks) {
            if (tasks.isEmpty()) return null;
            return tasks.pop();
        }
    }

    public void showResult() {
        tasks.sort((t1, t2) -> t1.start - t2.start);

        for (MyTask task : tasks) {
            System.out.println(task.answers);
        }
    }

    public int tasksCount() {
        return tasks.size();
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

}
