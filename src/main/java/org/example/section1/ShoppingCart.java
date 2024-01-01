// reference: https://www.baeldung.com/java-iterator-vs-iterable
package org.example.section1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ShoppingCart<E> implements Iterable<E>{
    private final List<E> items = new ArrayList<>();
    private int size;

    public void addItem(E item){
        items.add(item);
    }

    @Override
    public Iterator<E> iterator() {
        return new ShoppingCartIterator();
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }

    class ShoppingCartIterator implements Iterator {
        int pointer;
        int lastPointer;

        @Override
        public boolean hasNext() {
            return pointer != size;
        }

        @Override
        public Object next() {
            int current = pointer;

            List<E> items = ShoppingCart.this.items;
            // validating

            pointer++;
            lastPointer = current;
            return items.get(lastPointer);
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public void forEachRemaining(Consumer action) {
            Iterator.super.forEachRemaining(action);
        }
    }

}



