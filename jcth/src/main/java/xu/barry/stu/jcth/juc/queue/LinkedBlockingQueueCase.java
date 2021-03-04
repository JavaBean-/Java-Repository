package xu.barry.stu.jcth.juc.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueCase {

    public static void main(String[] args) throws InterruptedException {

        int numProducers = 4;
        int numConsumers = 3;

        BlockingQueue<Object> myQueue = new LinkedBlockingQueue<Object>(5);

        for (int i = 0; i < numProducers; i++) {
            new Thread(new Producer(myQueue)).start();
        }

        for (int i = 0; i < numConsumers; i++) {
            new Thread(new Consumer(myQueue)).start();
        }

        Thread.sleep(1000);

        System.exit(0);
    }
}
class Producer implements Runnable {

    protected BlockingQueue<Object> queue;

    Producer(BlockingQueue<Object> theQueue) {
        this.queue = theQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object justProduced = getResource();
                queue.put(justProduced);
                System.out.println("生产者资源队列大小= " + queue.size());
            }
        } catch (InterruptedException ex) {
            System.out.println("生产者 中断");
        }
    }

    Object getResource() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println("生产者 读 中断");
        }
        return new Object();
    }
}

class Consumer implements Runnable {
    protected BlockingQueue<Object> queue;

    Consumer(BlockingQueue<Object> theQueue) {
        this.queue = theQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object obj = queue.take();
                System.out.println("消费者 资源 队列大小 " + queue.size());
                take(obj);
            }
        } catch (InterruptedException ex) {
            System.out.println("消费者 中断");
        }
    }

    void take(Object obj) {
        try {
            Thread.sleep(100); // simulate time passing
        } catch (InterruptedException ex) {
            System.out.println("消费者 读 中断");
        }
        System.out.println("消费对象 " + obj);
    }
}