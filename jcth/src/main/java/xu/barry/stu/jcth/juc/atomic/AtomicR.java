package xu.barry.stu.jcth.juc.atomic;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import xu.barry.stu.jcth.utils.model.Father;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicR {

    private Father person = new Father("barry", 12);

    private AtomicReference<Father> personReference = new AtomicReference<>(person);


    @Test
    public void WithOutAtomicReferenceTest() throws Exception {
        Thread t1 = new Thread(() -> {
            synchronized (this){
                person.setName("aaa");
                for (int i = 0; i < 1000; i++) {
                    person.setAge(person.getAge() + 1);
                }
            }

        });
        Thread t2 = new Thread(() -> {
            person.setName("bbb");
            synchronized (this) {
                for (int i = 0; i < 1000; i++) {
                    person.setAge(person.getAge() + 1);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(JSONObject.toJSONString(person));
    }

    @Test
    public void AtomicReferenceTest() throws Exception {
        Thread t1 = new Thread(() -> {
            for (; ; ) {
                Father per = personReference.get();
                Father father = new Father(per.getName(), per.getAge() + 2);
                if (personReference.compareAndSet(per, father)) {
                    break;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (; ; ) {
                Father per = personReference.get();
                Father father = new Father(per.getName(), per.getAge() + 2);
                if (personReference.compareAndSet(per, father)) {
                    break;
                }
            }
        });
        Thread t3 = new Thread(() -> {
            for (; ; ) {
                Father per = personReference.get();
                Father father = new Father(per.getName(), per.getAge() + 2);
                if (personReference.compareAndSet(per, father)) {
                    break;
                }
            }
        });
        Thread t4 = new Thread(() -> {
            for (; ; ) {
                Father per = personReference.get();
                Father father = new Father(per.getName(), per.getAge() + 2);
                if (personReference.compareAndSet(per, father)) {
                    break;
                }
            }
        });
        Thread t5 = new Thread(() -> {
            for (; ; ) {
                Father per = personReference.get();
                Father father = new Father(per.getName(), per.getAge() + 2);
                if (personReference.compareAndSet(per, father)) {
                    break;
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        //Thread.sleep(100);
        System.out.println(JSONObject.toJSONString(personReference.get()));
        System.out.println(JSONObject.toJSONString(personReference.get()));
        System.out.println(JSONObject.toJSONString(personReference.get()));

    }

}
