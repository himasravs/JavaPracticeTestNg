package Collections;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayList1Test {

    @Test
    public void testAddAndSize() {
        ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(1, 2, 3));
        Assert.assertEquals(ar.size(), 3, "Array size should be 3");
    }

    @Test
    public void testForLoopElements() {
        ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(1, 2, 3));
        for (int i = 0; i < ar.size(); i++) {
            Assert.assertEquals(ar.get(i), Integer.valueOf(i + 1));
        }
    }

    @Test
    public void testForEachLoop() {
        ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> collected = new ArrayList<>();
        for (int b : ar) collected.add(b);
        Assert.assertEquals(collected, Arrays.asList(1, 2, 3));
    }

    @Test
    public void testIteratorLoop() {
        ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(1, 2, 3));
        Iterator<Integer> it = ar.iterator();
        List<Integer> iterated = new ArrayList<>();
        while (it.hasNext()) iterated.add(it.next());
        Assert.assertEquals(iterated, Arrays.asList(1, 2, 3));
    }

    @Test
    public void testLambdaStreamIteration() {
        ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> result = new ArrayList<>();
        ar.stream().forEach(result::add);
        Assert.assertEquals(result, Arrays.asList(1, 2, 3));
    }

    @Test
    public void testAddAllWithAnotherArray() {
        ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> ar1 = new ArrayList<>(Arrays.asList(11, 12, 13));
        ar.addAll(ar1);
        Assert.assertTrue(ar.containsAll(Arrays.asList(11, 12, 13)));
    }

    @Test
    public void testStringArrayBasicOperations() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Sravani", "Anil", "Maanya", "X", "Y", "Z", "X", "Y", "X"));
        Assert.assertEquals(names.size(), 9);
        Assert.assertTrue(names.contains("Maanya"));
        Assert.assertEquals(names.indexOf("Maanya"), 2);
        Assert.assertEquals(names.lastIndexOf("X"), 8);
        Assert.assertEquals(names.lastIndexOf("test"), -1);
    }

    @Test
    public void testCloneArray() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> cloned = (ArrayList<String>) names.clone();
        Assert.assertEquals(cloned, names);
        Assert.assertEquals(cloned.get(cloned.size() - 1), "C");
    }

    @Test
    public void testRemoveByValueAndIndex() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Sravani", "Anil", "Maanya", "Z"));
        names.remove("Z");
        Assert.assertFalse(names.contains("Z"));
        names.remove(0);
        Assert.assertEquals(names.get(0), "Anil");
    }

    @Test
    public void testRemoveIfOddNumbers() {
        ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        numList.removeIf(num -> num % 2 == 0);
        Assert.assertEquals(numList, Arrays.asList(1,3,5,7,9));
    }

    @Test
    public void testRemoveIfEvenNumbers() {
        ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        numList.removeIf(num -> num % 2 != 0);
        Assert.assertEquals(numList, Arrays.asList(2,4,6,8));
    }

    @Test
    public void testRetainAllSingleton() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Sravani","Anil","Maanya","Sravani","Y","Z","Sravani","Y","Sravani"));
        names.retainAll(Collections.singleton("Sravani"));
        Assert.assertEquals(names, Arrays.asList("Sravani","Sravani","Sravani","Sravani"));
    }

    @Test
    public void testSubListExtraction() {
        ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
        List<Integer> sublist = new ArrayList<>(numList.subList(9,14));
        Assert.assertEquals(sublist, Arrays.asList(10,11,12,13,14));
    }

    @Test
    public void testConvertArrayListToArray() {
        ArrayList<String> convertStaticArray = new ArrayList<>(Arrays.asList("India","US","London","Pak","Nepal"));
        Object[] arr = convertStaticArray.toArray();
        Assert.assertEquals(arr.length, 5);
        Assert.assertEquals(arr[0], "India");
    }

    @Test
    public void testRemoveDuplicatesUsingLinkedHashSet() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9));
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>(list);
        ArrayList<Integer> noDupList = new ArrayList<>(lhs);
        Assert.assertEquals(noDupList, Arrays.asList(1,2,3,4,5,6,7,8,9));
    }

    @Test
    public void testRemoveDuplicatesUsingStreams() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9));
        List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
        Assert.assertEquals(distinctList, Arrays.asList(1,2,3,4,5,6,7,8,9));
    }

    @Test
    public void testCompareTwoLists() {
        ArrayList<String> l1 = new ArrayList<>(Arrays.asList("A","B","C","D","E"));
        ArrayList<String> l2 = new ArrayList<>(Arrays.asList("A","B","C","D","F"));
        ArrayList<String> l3 = new ArrayList<>(Arrays.asList("A","B","C","D","E"));
        Collections.sort(l1);
        Collections.sort(l2);
        Collections.sort(l3);
        Assert.assertFalse(l1.equals(l2));
        Assert.assertTrue(l1.equals(l3));
    }

    @Test
    public void testRetainAllCommonElements() {
        ArrayList<String> l4 = new ArrayList<>(Arrays.asList("A","B","C","D","F"));
        ArrayList<String> l5 = new ArrayList<>(Arrays.asList("A","B","C","D","E"));
        l4.retainAll(l5);
        Assert.assertEquals(l4, Arrays.asList("A","B","C","D"));
    }
}
