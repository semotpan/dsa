package dsa.fundamentals;

public final class LinkedList<T extends Comparable<T>> {
    private Node<T> first;
    private Node<T> last;

    private int size = 0;

    public LinkedList() {
    }

    public void add(T value) {
        var newNode = new Node<>(value);

        var l = last;
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
            newNode.prev = l;
        }

        ++size;
    }

    public int size() {
        return size;
    }

    // remove first that is found
    public boolean remove(T t) {

        for (Node<T> it = first; it != null; it = it.next) {
            if (it.value.compareTo(t) == 0) {
                unlink(it);
                return true;
            }
        }

        return false;
    }

    public int remove(int index) {

        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        var ix = 0;
        for (Node<T> it = first; it != null; it = it.next) {
            if (ix == index) {
                unlink(it);
                return ix;
            }
            ++ix;
        }

        return -1;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        var i = 0;
        T value = null;
        for (Node<T> it = first; it != null; it = it.next) {
            if (i == index) {
                value = it.value;
                break;
            }
            ++i;
        }

        return value;
    }

    private void unlink(Node<T> it) {
        if (it == null) {
            return;
        }
        --size;
        if (it == first) {
            first = first.next;
            first.prev = null;
            return;
        }

        if (it == last) {
            last = last.prev;
            last.next = null;
            return;
        }

        it.prev.next = it.next;
        it.next.prev = it.prev;
    }

    public String toString() {
        var sb = new StringBuilder("[");
        var f = first;

        while (f != null) {
            sb.append(f.value);

            if (f.next != null) {
                sb.append(", ");
            }
            f = f.next;
        }

        sb.append("]");
        return sb.toString();
    }

    private static final class Node<T> {

        private Node<T> prev;
        private Node<T> next;
        private final T value;

        private Node(T value, Node<T> prev, Node<T> next) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }

        private Node(T value) {
            this(value, null, null);
        }
    }
}

