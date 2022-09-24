package dsa.fundamentals;

import java.util.Iterator;

public final class Bag<T extends Comparable<T>> implements Iterable<T> {

    private Object[] elements;
    private int capacity;
    private int size;

    public Bag() {
        this(12);
    }

    public Bag(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than 0");
        }
        this.capacity = capacity;
        elements = new Object[capacity];
    }

    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            this.capacity = capacity * 2;
            var temp = new Object[this.capacity];
            System.arraycopy(elements, 0, temp, 0, size);
            elements = temp;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return Bag.this.size > index;
            }

            @Override
            public T next() {
                return (T) Bag.this.elements[index++];
            }
        };
    }
}
