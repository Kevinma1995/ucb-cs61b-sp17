import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Ziyi Yan cxfyzy@gmail.com
 *         Created on 05/07/2017.
 */
public class ArrayDequeTest {
    @Test
    public void testResize() {
        ArrayDeque<Integer> intArr = new ArrayDeque<>();
        for (int i = 0; i < 10000; i++) {
            intArr.addFirst(0);
        }
        for (int i = 0; i < 9999; i++) {
            intArr.removeLast();
        }
        assertEquals(1, intArr.size());
        assertEquals(8, intArr.capacity());
    }

    @Test
    public void testAddRemove() throws Exception {
        int[] expected = {1, 2, 3, 4, 5};

        ArrayDeque<Integer> intArr = new ArrayDeque<>();
        intArr.addLast(3);
        intArr.addFirst(2);
        intArr.addLast(4);
        intArr.addFirst(1);
        intArr.addLast(5);
        intArr.addFirst(0);
        intArr.addLast(6);

        intArr.removeFirst();
        intArr.removeLast();

        for (int i = 0; i < expected.length; i++) {
            assertEquals(intArr.get(i).intValue(), expected[i]);
        }
    }
}
