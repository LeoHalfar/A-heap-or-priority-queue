import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class priolistreversed {
    private List<Integer> items;

    public priolistreversed() {
        items = new ArrayList<>();
    }

    // Add an element to the priority queue with O(n) time complexity
    public void add(int item) {
        // Find the position to insert the element to maintain the reverse priority
        int index = 0;
        while (index < items.size() && item > items.get(index)) {
            index++;
        }
        items.add(index, item);
    }

    // Remove and return the element with the highest priority in O(1)
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        // Since the elements are stored in reverse priority order, we can remove the first element in O(1)
        return items.remove(0);
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

            nxt = rnd.nextInt(n*10) + 1;
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

            priolistreversed priolistreversed = new priolistreversed();
            double t1 = 0;
            double t0 = 0;
            Integer removed = 0;
            Integer[] treearray = unsorted(1023);
            Random rnd = new Random();
            for (int i = 0; i < 1023; i++) {
                priolistreversed.add(treearray[i]);

            }

            double totaltime = 0;

            for (int j = 0; j < 100; j++) {
                t0 = System.nanoTime();
                removed = priolistreversed.remove();
                priolistreversed.add(removed + (rnd.nextInt(200) + 1));
                t1 = System.nanoTime();

                totaltime += t1 - t0;

            }
            
            tottot += totaltime;
        }
        System.out.println("avarage time in ns:" + tottot / 10000);
    }
}