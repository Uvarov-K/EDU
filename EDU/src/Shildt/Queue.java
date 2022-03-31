package Shildt;

class Queue {
    int q[];
    int putloc, getloc;

    public Queue(int size) {
        q = new int[size + 1];
        putloc = getloc = 0;

    }


    void put(int i) {
        if (putloc == q.length - 1) {
            System.out.println("q is full ");
            return;
        }
        putloc++;
        q[putloc] = i;


    }

    int get() {
        if (getloc == putloc) {
            System.out.println("q is empty");
            return 0;
        }
        getloc++;
        return q[getloc];

    }

    void printQ() {
        for (int i = 0; i < q.length - 1; i++) {
            System.out.print(q[i] + " ");
        }
    }

}

class QueueTestRun {
    public static void main(String[] args) {
        Queue q1 = new Queue(10);
        int d;
        for (int i = 0; i < 11; i++) {
            q1.put(i);
           d= q1.get();
            System.out.println(d);
        }

        q1.printQ();
        q1.get();
    }
}



