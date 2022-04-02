package Test;
import static org.junit.Assert.*;

import deque.ArrayDeque;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ArrayDequeTest {

    PrintStream console = null;
    ByteArrayOutputStream bytes = null;

    @org.junit.Before
      public void beforeTest() throws Exception {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @Test
    public void testRemove(){
        ArrayDeque<String> arr1 = new ArrayDeque<>();
        arr1.addFirst("hello");
        arr1.addFirst("wht");
        arr1.addLast("world");
        arr1.removeFirst();
        String s = new String("hello\nworld");
        arr1.printDeque();
        assertEquals(s,bytes.toString().trim());
    }
}
