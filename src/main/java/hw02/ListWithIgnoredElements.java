package hw02;

import java.util.*;
import java.util.function.Consumer;

public class ListWithIgnoredElements<E> extends ArrayList<E> {
    private final Collection<? extends E> ignoredElements;

    public ListWithIgnoredElements(Collection<? extends E> collection, Collection<? extends E> ignoredElements) {
        super(collection);
        if (ignoredElements != null) {
            this.ignoredElements = ignoredElements;
        } else {
            this.ignoredElements = Collections.emptyList();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ModifiedItr(super.iterator());
    }

    private class ModifiedItr implements Iterator<E> {
        private int cursor;
        private final Iterator<E> itr;

        ModifiedItr(Iterator<E> itr) {
            this.itr = itr;
        }

        @Override
        public boolean hasNext() {
            E temp;
            for (int i = cursor; i < ListWithIgnoredElements.this.size(); i++) {
                temp = ListWithIgnoredElements.this.get(i);
                if (!ignoredElements.contains(temp)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public E next() {
            E temp;
            while (hasNext()) {
                cursor++;
                temp = itr.next();
                if (!ignoredElements.contains(temp)) {
                    return temp;
                }
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            itr.remove();
            cursor--;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            itr.forEachRemaining(action);
        }
    }

    @Override
    public boolean add(E e) {
        return (!ignoredElements.contains(e)) && super.add(e);
    }

    @Override
    public void add(int index, E element) {
        if (!ignoredElements.contains(element)) {
            super.add(index, element);
        } else {
            System.out.println("The element is ignored!");
        }
    }

    @Override
    public E remove(int index) {
        E removedElement = null;
        if (!ignoredElements.contains(this.get(index))) {
            removedElement = super.remove(index);
        } else {
            System.out.println("The element is ignored!");
        }
        return removedElement;
    }

    @Override
    public boolean remove(Object o) {
        return (!ignoredElements.contains(o)) && super.remove(o);
    }
}
