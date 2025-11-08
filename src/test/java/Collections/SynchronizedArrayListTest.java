package Collections;

import org.testng.annotations.Test;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedArrayListTest {

    /**
     * Demonstrates synchronization using Collections.synchronizedList
     */
    @Test
    public void testSynchronizedList() {
        // Create a synchronized List
        List<String> subjects = Collections.synchronizedList(new ArrayList<String>());
        subjects.add("Java");
        subjects.add("Python");
        subjects.add("Ruby");

        // Synchronize on the list before iterating
        synchronized (subjects) {
            Iterator<String> it = subjects.iterator();
            System.out.println("Iterating through synchronized ArrayList using Collections.synchronizedList:");
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }

    /**
     * Demonstrates thread-safe iteration using CopyOnWriteArrayList
     */
    @Test
    public void testCopyOnWriteArrayList() {
        CopyOnWriteArrayList<String> empList = new CopyOnWriteArrayList<>();
        empList.add("Tom");
        empList.add("Kint");
        empList.add("Mint");

        System.out.println("Iterating through CopyOnWriteArrayList:");
        Iterator<String> iterator = empList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * Demonstrates modification during iteration using CopyOnWriteArrayList
     */
    @Test
    public void testConcurrentModification() {
        CopyOnWriteArrayList<String> empList = new CopyOnWriteArrayList<>();
        empList.add("Alex");
        empList.add("Brian");
        empList.add("Charles");

        System.out.println("Demonstrating safe modification during iteration:");
        for (String name : empList) {
            System.out.println(name);
            if (name.equals("Brian")) {
                empList.add("David"); // This is safe with CopyOnWriteArrayList
            }
        }

        System.out.println("After modification: " + empList);
    }
}
