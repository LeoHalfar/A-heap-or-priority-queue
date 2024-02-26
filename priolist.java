import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class priolist {
    private List<Integer> items;

    public priolist() {
        items = new ArrayList<>();
    }

    // Add an element to the priority queue
    public void add(int item) {
        items.add(item);
    }

    // Remove and return the element with the highest priority
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        int highestPriority = Integer.MAX_VALUE;
        int highestPriorityIndex = -1;

        for (int i = 0; i < items.size(); i++) {
            int currentItem = items.get(i);
            if (currentItem < highestPriority) {
                highestPriority = currentItem;
                highestPriorityIndex = i;
            }
        }

        if (highestPriorityIndex != -1) {
            return items.remove(highestPriorityIndex);
        } else {
            throw new IllegalStateException("Error removing element from priority queue");
        }
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Get the size of the priority queue
    public int size() {
        return items.size();
    }

    public static Integer[] unsorted(int n) {
        Random rnd = new Random();
        Integer[] array = new Integer[n];
        Integer nxt = 0;
        boolean duplicate = false;

        for (int i = 0; i < n; i++) {
            duplicate = false;

            nxt = rnd.nextInt(n * 10) + 1;
            for (int j = 0; j < i; j++) {
                if (nxt == array[j]) {
                    i--;
                    duplicate = true;
                }
            }
            if (duplicate == false) {
                array[i] = nxt;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        double tottot = 0;
        for (int q = 0; q < 100; q++) {

            priolist priolist = new priolist();
            double t1 = 0;
            double t0 = 0;
            Integer removed = 0;
            Integer[] treearray = unsorted(1023);
            Random rnd = new Random();
            for (int i = 0; i < 1023; i++) {
                priolist.add(treearray[i]);

            }

            double totaltime = 0;

            for (int j = 0; j < 100; j++) {
                t0 = System.nanoTime();
                removed = priolist.remove();
                priolist.add(removed + (rnd.nextInt(200) + 1));
                t1 = System.nanoTime();

                totaltime += t1 - t0;

            }
            
            tottot += totaltime;
        }
        System.out.println("avarage time in ns:" + tottot / 10000);
    }
}