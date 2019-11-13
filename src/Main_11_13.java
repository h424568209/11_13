import java.util.*;

public class Main_11_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int len = scanner.nextInt();
            if (len >= 1000) {
                len = 999;
            }
            if (len == 0) {
                return;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                queue.offer(i);
            }
            while (queue.size() != 1) {
                queue.add(queue.poll());
                queue.add(queue.poll());
                queue.poll();
            }
            System.out.println(queue.peek());
        }
    }
}
