/**
 * @author Ziyi Yan cxfyzy@gmail.com
 *         Created on 08/07/2017.
 */
public class OffByN implements CharacterComparator {
    private int N;
    public OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 5;
    }
}
