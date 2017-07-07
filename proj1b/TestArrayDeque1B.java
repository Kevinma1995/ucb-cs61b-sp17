import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Ziyi Yan cxfyzy@gmail.com
 *         Created on 07/07/2017.
 */
public class TestArrayDeque1B {
    @Test
    public void testRamdomly() {
        StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> arraySolution = new ArrayDequeSolution<>();

        for (int i = 0; i < 100; i++) {
            int randomNumber = StdRandom.uniform(4);
            switch (randomNumber) {
                case 0:
                    studentArrayDeque.addFirst(i);
                    arraySolution.addFirst(i);
                    break;
                case 1:
                    studentArrayDeque.addLast(i);
                    arraySolution.addLast(i);
                    break;
                case 2:
                    if (arraySolution.size() > 0 && studentArrayDeque.size() > 0) {
                        studentArrayDeque.removeFirst();
                        arraySolution.removeFirst();
                    }
                    break;
                case 3:
                    if (arraySolution.size() > 0 && studentArrayDeque.size() > 0) {
                        studentArrayDeque.removeLast();
                        arraySolution.removeLast();
                    }
                    break;
                default:
                    break;
            }
        }

        assertEquals("size()", arraySolution.size(), studentArrayDeque.size());
        for (int i = 0; i < arraySolution.size(); i++) {
            assertEquals("get(i)", arraySolution.get(i), studentArrayDeque.get(i));
        }
    }
}
