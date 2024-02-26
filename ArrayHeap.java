import java.util.Random;

public class ArrayHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public ArrayHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }

        heap[size] = value;
        bubbleUp(size);
        size++;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Heap is empty. Cannot remove.");
            return -1; // Return a sentinel value or throw an exception
        }

        int removedValue = heap[0];
        heap[0] = heap[size - 1];
        size--;
        sinkDown(0);
        return removedValue;
    }

    private void bubbleUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap[index] < heap[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void sinkDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex < size && heap[leftChildIndex] < heap[smallestIndex]) {
            smallestIndex = leftChildIndex;
        }
        if (rightChildIndex < size && heap[rightChildIndex] < heap[smallestIndex]) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != index) {
            swap(index, smallestIndex);
            sinkDown(smallestIndex);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
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
        for(int q = 0; q<100; q++){
        double totaltime = 0;
        double t0 = 0;
        double t1 = 0;
        Random rnd = new Random();
        Integer removed = 0;
        ArrayHeap minHeap = new ArrayHeap(1023);
        Integer[] array = unsorted(1023);
        for(int i = 0; i<1023; i++){
           minHeap.insert(array[i]);
    
            
            }
            
            for (int j = 0; j<100; j++){
                t0 = System.nanoTime();
                removed = minHeap.remove();
                minHeap.insert(removed+(rnd.nextInt(200) + 1));
                t1 = System.nanoTime();
                
                totaltime += t1-t0;
        
                }
                tottot += totaltime;
            }
                System.out.println("avarage time in ns:"+ tottot/10000);
    }
}