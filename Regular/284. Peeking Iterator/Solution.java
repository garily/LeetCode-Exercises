// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {
    private Integer curVal;
    private Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) curVal = iterator.next();
        else curVal = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return curVal;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer out = curVal;
        if (out == null) throw new NoSuchElementException();
        if (iterator.hasNext()) curVal = iterator.next();
        else curVal = null;
        return out;
    }

    @Override
    public boolean hasNext() {
        return curVal != null;
    }
}
