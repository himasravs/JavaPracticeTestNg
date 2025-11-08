package Collections;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hashmap1Test {

    @Test
    public void testHashMapBasicOperations() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 45);
        map.put('b', 46);
        map.put('c', 47);
        map.put('c', 48); // overrides
        map.put('d', 49);
        map.put('a', 46); // overrides
        map.put(null, 99); // null key works

        // ✅ verify key-value pairs
        Assert.assertEquals(map.get('a'), Integer.valueOf(46));
        Assert.assertEquals(map.get('c'), Integer.valueOf(48));
        Assert.assertEquals(map.get(null), Integer.valueOf(99));

        // ✅ remove and verify
        map.remove('a');
        Assert.assertNull(map.get('a'), "Removed key should return null");
    }

    @Test
    public void testCompareHashMapsByEquality() {
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(3, "C");
        map2.put(1, "A");
        map2.put(2, "B");

        HashMap<Integer, String> map3 = new HashMap<>();
        map3.put(1, "A");
        map3.put(2, "B");
        map3.put(3, "D"); // different value

        Assert.assertTrue(map1.equals(map2), "Order doesn't matter in HashMap equality");
        Assert.assertFalse(map1.equals(map3), "Different values -> should not be equal");

        // Compare only keys
        Assert.assertTrue(map1.keySet().equals(map2.keySet()));
        Assert.assertTrue(map1.keySet().equals(map3.keySet()));
    }

    @Test
    public void testExtraKeyDetectionUsingSet() {
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");

        HashMap<Integer, String> map4 = new HashMap<>();
        map4.put(1, "A");
        map4.put(2, "B");
        map4.put(3, "C");
        map4.put(4, "D");

        HashSet<Integer> combined = new HashSet<>(map4.keySet());
        combined.removeAll(map1.keySet());
        Assert.assertTrue(combined.contains(4), "Extra key 4 should be detected");
    }

    @Test
    public void testCompareHashMapValues() {
        HashMap<Integer, String> map5 = new HashMap<>();
        map5.put(1, "A");
        map5.put(2, "B");
        map5.put(3, "C");

        HashMap<Integer, String> map6 = new HashMap<>();
        map6.put(4, "A");
        map6.put(5, "B");
        map6.put(6, "C");

        HashMap<Integer, String> map7 = new HashMap<>();
        map7.put(1, "A");
        map7.put(2, "B");
        map7.put(3, "C");
        map7.put(4, "C");

        // ✅ Compare values using ArrayList (order sensitive)
        Assert.assertTrue(
                new ArrayList<>(map5.values()).equals(new ArrayList<>(map6.values())),
                "Both maps have same values in same order"
        );

        // ✅ Compare values using HashSet (order insensitive)
        Assert.assertTrue(
                new HashSet<>(map5.values()).equals(new HashSet<>(map7.values())),
                "Same values ignoring order"
        );
    }

    @Test
    public void testImmutableSingletonMap() {
        Map<String, Integer> map = Collections.singletonMap("Sravani", 100);
        Assert.assertEquals(map.get("Sravani"), Integer.valueOf(100));

        Assert.expectThrows(UnsupportedOperationException.class, () -> map.put("Test", 99));
    }

    @Test
    public void testStreamToMapConversion() {
        Map<String, String> map12 = Stream.of(new String[][]{
                {"Father", "Tom"},
                {"Mother", "Rose"}
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        Assert.assertEquals(map12.get("Father"), "Tom");

        map12.put("Child", "Tim");
        Assert.assertEquals(map12.get("Child"), "Tim");
    }

    @Test
    public void testSimpleEntryToMap() {
        Map<String, String> map13 = Stream.of(
                new AbstractMap.SimpleEntry<>("Sravani", "Software"),
                new AbstractMap.SimpleEntry<>("Anil", "Scientist")
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Assert.assertNull(map13.get("Father"));
        Assert.assertEquals(map13.get("Sravani"), "Software");

        map13.put("Maanya", "Studying");
        Assert.assertEquals(map13.get("Maanya"), "Studying");
    }

    @Test
    public void testMapOfAndMapOfEntries() {
        Map<String, String> map14 = Map.of();
        Assert.assertTrue(map14.isEmpty());

        Map<String, String> map15 = Map.of("A1", "V1");
        Assert.assertEquals(map15.get("A1"), "V1");
        Assert.expectThrows(UnsupportedOperationException.class, () -> map15.put("A2", "V2"));

        Map<String, String> map16 = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("A", "ONE"),
                new AbstractMap.SimpleEntry<>("B", "TWO"),
                new AbstractMap.SimpleEntry<>("C", "THREE")
        );
        Assert.assertEquals(map16.get("A"), "ONE");

        // convert immutable to mutable
        Map<String, String> map18 = new HashMap<>(map16);
        map18.put("E", "Five");
        Assert.assertTrue(map18.containsKey("E"));
    }

    @Test
    public void testCompanyMapToListConversion() {
        HashMap<String, Integer> compDetails = new HashMap<>();
        compDetails.put("Google", 19000);
        compDetails.put("Amazon", 18000);
        compDetails.put("Facebook", 17000);
        compDetails.put("Microsoft", 16000);

        List<String> companies = new ArrayList<>(compDetails.keySet());
        List<Integer> employees = new ArrayList<>(compDetails.values());

        Assert.assertEquals(companies.size(), 4);
        Assert.assertEquals(employees.size(), 4);
        Assert.assertTrue(companies.contains("Google"));
    }
}
