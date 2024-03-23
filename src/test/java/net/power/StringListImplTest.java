package net.power;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

class StringListImplTest {
    static StringListImpl stringList = new StringListImpl();

    @BeforeEach
    public void setUp() {
        stringList = new StringListImpl();
    }
    @Test
    void add() {
        String result = stringList.add("asdf");
        Assertions.assertEquals("asdf",result);
    }

    @Test
    void testAdd() {
        Assertions.assertThrows(RuntimeException.class, () -> stringList.add(10,"ff"));
    }

    @Test
    void testAdd2() {
        String result = stringList.add(1,"w");
        Assertions.assertEquals("w",result);
    }
    @Test
    void set() {
        Assertions.assertThrows(RuntimeException.class, () -> stringList.set(10,"qq"));
    }
    @Test
    void set2() {
        String result = stringList.set(0,"w");
        Assertions.assertEquals("w",result);
    }

    @Test
    void remove() {
        prepareList("a", "b", "c");
        String result = stringList.remove("b");
        Assertions.assertEquals("b",result);
    }

    @Test
    void testRemove() {
        prepareList("a", "b", "c");
        String result = stringList.remove(1);
        Assertions.assertEquals("b",result);
    }

    @Test
    void contains() {
        prepareList("a", "b", "c");
        boolean result = stringList.contains("c");
        Assertions.assertTrue(result);
    }

    @Test
    void indexOf() {
        prepareList("a", "b", "c");

        int result = stringList.indexOf("b");
        Assertions.assertEquals(1,result);
    }
    @Test
    void indexOf2() {
        prepareList("a", "b", "c");

        int result2 = stringList.indexOf("d");
        System.out.println(result2);
        Assertions.assertEquals(-1,result2);
    }
    @Test
    void lastIndexOf() {
        prepareList("a", "b", "c");

        int result = stringList.lastIndexOf("b");
        Assertions.assertEquals(1,result);
    }

    @Test
    void lastIndexOf2() {
        prepareList("a", "b", "c");

        int result2 = stringList.lastIndexOf("d");
        System.out.println(result2);
        Assertions.assertEquals(-1,result2);
    }

    @Test
    void get() {
        prepareList("a", "b", "c");

        String result2 = stringList.get(1);
        System.out.println(result2);
        Assertions.assertEquals("b",result2);
    }

    @Test
    void get2() {
        prepareList("a", "b", "c");

        Assertions.assertThrows(RuntimeException.class, () -> stringList.get(11));
    }

    @Test
    void testEquals() {
        StringListImpl stringList1 = prepareNewStringList("a", "b", "c");
        prepareList("a", "b", "c");

        boolean actual = stringList.equals(stringList1);

        Assertions.assertTrue(actual);
    }
    @Test
    @DisplayName("Проверка на size")
    void testEquals1() {
        StringListImpl stringList1 = prepareNewStringList("a", "b", "c");
        prepareList("a", "b");

        boolean actual = stringList.equals(stringList1);

        Assertions.assertFalse(actual);
    }

    @Test
    void testEquals2() {
        StringListImpl stringList1 = stringList;
        prepareList("a", "b", "c");

        boolean actual = stringList.equals(stringList1);

        Assertions.assertTrue(actual);
    }

    @Test
    void size() {
        prepareList("a", "b", "c");
        int actual = stringList.size();
        Assertions.assertEquals(3, actual);
    }

    @Test
    void isEmpty() {
        prepareList("a", "b", "c");
        boolean actual = stringList.isEmpty();
        Assertions.assertFalse(actual);
    }

    @Test
    void clear() {
        prepareList("a", "b", "c");
        stringList.clear();
        //System.out.println(stringList.get(1));
        StringListImpl newStringList = new StringListImpl();
        Assertions.assertTrue(stringList.equals(newStringList));
    }

    @Test
    void toArray() {
        prepareList("a", "b", "c");
        String[] actual = stringList.toArray();
        System.out.println(Arrays.toString(actual));
    }
    
    private static void prepareList(String ... strings) {
        for (String x : strings) {
            stringList.add(x);
        }
    }

    private static StringListImpl prepareNewStringList(String ... strings) {
        StringListImpl temp = new StringListImpl();
        for (String x : strings) {
            temp.add(x);
        }
        return temp;
    }
}