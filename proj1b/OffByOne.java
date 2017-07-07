/**
 * @author Ziyi Yan cxfyzy@gmail.com
 *         Created on 08/07/2017.
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
