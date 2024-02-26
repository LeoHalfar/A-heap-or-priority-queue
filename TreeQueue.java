
import java.util.Random;


public class TreeQueue {
    public class Node {
        public Integer branchsize;
        public Integer value;
        public Node left, right;

        public Node(Integer value) {
            this.branchsize = 0;
            this.value = value;
            this.left = this.right = null;
        }
    }

    Node root;
    public Integer count;
    public TreeQueue() {
        root = null;
    }

    public Integer remove() {
        Integer rem = root.value;
        remhelp(root);

        return rem;
    }

    public void remhelp(Node root) {

        if (root.branchsize == 0) {
            root = null;
            return;

        }

        if ((root.left == null && root.right != null)) {
            root.value = root.right.value;
            if (root.right.branchsize == 0) {
                root.right = null;
                return;

            }
            remhelp(root.right);
            return;
        }

        if (root.right == null && root.left != null) {
            root.value = root.left.value;
            if (root.left.branchsize == 0) {
                root.left = null;
                return;

            }
            remhelp(root.left);
            return;

        }

        if (root.left.value < root.right.value) {
            root.value = root.left.value;
            if (root.left.branchsize == 0) {
                root.left = null;
                return;

            }
            remhelp(root.left);
            return;

        }

        if (root.left.value > root.right.value) {
            root.value = root.right.value;
            if (root.right.branchsize == 0) {
                root.right = null;
                return;

            }
            remhelp(root.right);
            return;

        }

    }

    public Integer push(Integer incr){
    root.value+=incr;
    count = 0;
    pushhelp(root);
    return count;
    }

    public void pushhelp(Node root){
        Integer tillfällig = 0;
    if(root.left==null&&root.right==null){

    return ;

    }
    if(root.left.value<root.value&&root.right==null) {
    tillfällig = root.value;
    root.value=root.left.value;
    root.left.value=tillfällig;
    count++;
    pushhelp(root.left);
    return ;
    }

    if(root.right.value<root.value&&root.left==null){
     tillfällig = root.value;
    root.value=root.right.value;
    root.right.value=tillfällig;
    count++;
    pushhelp(root.right);
    return ;

    }

    if(root.left.value<root.value&&root.left.value<root.right.value) {
    tillfällig = root.value;
    root.value=root.left.value;
    root.left.value=tillfällig;
    count++;
    pushhelp(root.left);
    return ;
    }

    if(root.right.value<root.value&&root.left.value>root.right.value){
     tillfällig = root.value;
    root.value=root.right.value;
    root.right.value=tillfällig;
    count++;
    pushhelp(root.right);
    return ;

    }


    return ;

    }


    public void add(Integer value) {
        Node newn = new Node(value);
        if (root == null) {

            root = newn;

            return;
        }
        addhelp(newn, root);
    }

    public void addhelp(Node newn, Node root) {
        Integer tillfällig = 0;

        if (root.value > newn.value) {
            tillfällig = newn.value;
            newn.value = root.value;
            root.value = tillfällig;

        }

        if (root.left == null) {
            root.left = newn;
            root.branchsize = (root.branchsize) + 1;
            return;
        }

        if (root.right == null) {
            root.right = newn;
            root.branchsize = (root.branchsize) + 1;
            return;
        }

        if (root.left.value < newn.value && root.left.branchsize <= root.right.branchsize) {
            root.branchsize = (root.branchsize) + 1;
            addhelp(newn, root.left);
            return;

        }

        if (root.right.value < newn.value && root.left.branchsize >= root.right.branchsize) {
            root.branchsize = (root.branchsize) + 1;
            addhelp(newn, root.right);
            return;

        }
        if (root.left.value > newn.value && root.left.branchsize <= root.right.branchsize) {
            root.branchsize = (root.branchsize) + 1;
            tillfällig = newn.value;
            newn.value = root.left.value;
            root.left.value = tillfällig;
            addhelp(newn, root.left);
            return;
        }
        if (root.right.value > newn.value && root.left.branchsize >= root.right.branchsize) {
            root.branchsize = (root.branchsize) + 1;
            tillfällig = newn.value;
            newn.value = root.right.value;
            root.right.value = tillfällig;
            addhelp(newn, root.right);
            return;

        }

    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left); // Traverse left subtree
            System.out.print(node.value + " "); // Print the current node
            printInOrder(node.right); // Traverse right subtree
        }
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
        double tottotdepth = 0;
        for(int q = 0; q<100; q++){
        Random rnd = new Random();
        TreeQueue tree = new TreeQueue();
        Integer depth = 0;
        Integer removed = 0;
        double t1 = 0;
        double t0 = 0;
        
        Integer []treearray = unsorted(1023);
        
        for(int i = 0; i<1023; i++){
        tree.add(treearray[i]);

        
        }
        
        Integer totaldepth=0;
        double totaltime = 0;
        
        for (int j = 0; j<100; j++){
        t0 = System.nanoTime();
        depth = tree.push(rnd.nextInt(200) + 1);
        t1 = System.nanoTime();
        totaldepth += depth;
        totaltime += t1-t0;

        }
        
        /* 
        for (int j = 0; j<100; j++){
        t0 = System.nanoTime();
        removed = tree.remove()+(rnd.nextInt(200) + 1);
        tree.add(removed);
        t1 = System.nanoTime();
        totaltime += t1-t0;
        }
       */
    tottot += totaltime;
    tottotdepth += totaldepth;

    }



        System.out.println("avarage time in ns:"+ tottot/10000 + " avarage depth:" + tottotdepth/10000);

        
        
        //System.out.println(tree.remove());
        //System.out.println(tree.remove());
        //System.out.println(tree.remove());

        // Print nodes in ascending order of branchsizes
        //System.out.println("Nodes in ascending order of branchsizes:");
        //tree.printInOrder();

        // Iterate through the tree using a for-each loop

    }

}