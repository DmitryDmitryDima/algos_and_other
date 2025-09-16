package language.random_things;

import java.util.Iterator;
import java.util.function.Consumer;

public class CustomIterator {

    public static void main(String[] args) {

        for (int i:Range.of(0,2)){
            System.out.println(i);
        }
    }
}


class Range implements Iterable<Integer>{

    public static Range of(int left, int right){
        return new Range(left, right);
    }

    private int current;
    private final int limit;
    private Range(Integer left, Integer right){
        current = left;
        limit = right;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator();
    }



    private class CustomIterator implements Iterator<Integer>{

        @Override
        public boolean hasNext() {
            return Range.this.current<limit;
        }

        @Override
        public Integer next() {

            return Range.this.current++;
        }
    }
}
